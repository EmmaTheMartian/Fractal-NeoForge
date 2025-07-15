plugins {
	id("dev.architectury.loom") version "1.10-SNAPSHOT"
	id("maven-publish")
}

fun prop(key: String) = property(key) as String

version = prop("mod_version")
group = prop("maven_group")

base {
	archivesName = prop("mod_id")
}

repositories {
	maven("https://maven.neoforged.net")
	maven("https://maven.parchmentmc.org")

	// EMI
	maven("https://maven.terraformersmc.com/releases/") {
		content {
			includeGroup("dev.emi")
			includeGroup("com.terraformersmc")
		}
	}

	// REI
	maven("https://maven.shedaniel.me/") {
		content {
			includeGroup("me.shedaniel")
			includeGroup("me.shedaniel.cloth")
			includeGroup("me.shedaniel.cloth.api")
			includeGroup("dev.architectury")
		}
	}

	// JEI
	maven("https://maven.blamejared.com/") {
		content {
			includeGroup("mezz.jei")
		}
	}
}

dependencies {
	minecraft("com.mojang:minecraft:${prop("minecraft_version")}")

	@Suppress("UnstableApiUsage")
	mappings(loom.layered {
		officialMojangMappings()
		parchment("org.parchmentmc.data:parchment-${prop("parchment_minecraft_version")}:${prop("parchment_mappings_version")}@zip")
	})

	neoForge("net.neoforged:neoforge:${prop("neo_version")}")

	// Recipe viewers
	compileOnly("mezz.jei:jei-${prop("minecraft_version")}-neoforge-api:${prop("jei_version")}")
//	modCompileOnly("me.shedaniel:RoughlyEnoughItems-api-neoforge:${prop("rei_version")}")
	modCompileOnly("me.shedaniel:RoughlyEnoughItems-api-neoforge:${prop("rei_version")}")
	modCompileOnly("me.shedaniel:RoughlyEnoughItems-default-plugin-neoforge:${prop("rei_version")}")
//	modApi("me.shedaniel.cloth:basic-math:0.6.1")
	modCompileOnly("dev.emi:emi-neoforge:${prop("emi_version")}")
	modCompileOnly("dev.emi:emi-neoforge:${prop("emi_version")}:api")

	when (prop("recipe_viewer").lowercase()) {
		"jei" -> runtimeOnly("mezz.jei:jei-${prop("minecraft_version")}-neoforge:${prop("jei_version")}")
		"rei" -> modLocalRuntime("me.shedaniel:RoughlyEnoughItems-neoforge:${prop("rei_version")}")
		"emi" -> modLocalRuntime("dev.emi:emi-neoforge:${prop("emi_version")}")
		"disabled" -> {}
		else -> println("Unknown recipe viewer specified: ${prop("recipe_viewer")}. Must be EMI, REI or disabled.")
	}
}

loom {
    accessWidenerPath = file("src/main/resources/fractal.accesswidener")

	runs {
		register("testmodClient") {
			client()
			runDir("run")
			source(sourceSets.test.get())
			property("forge.enabledGameTestNamespaces", "fractal_test")

			mods {
				register("fractal") {
					sourceSet(sourceSets.main.get())
				}

				register("fractal_test") {
					sourceSet(sourceSets.test.get())
				}
			}
		}
	}
}

java {
	toolchain.languageVersion = JavaLanguageVersion.of(21)
	withSourcesJar()
	withJavadocJar()
}

val replaceProperties = mapOf(
	"minecraft_version"       to prop("minecraft_version"),
	"minecraft_version_range" to prop("minecraft_version_range"),
	"neo_version"             to prop("neo_version"),
	"neo_version_range"       to prop("neo_version_range"),
	"loader_version_range"    to prop("loader_version_range"),
	"mod_id"                  to prop("mod_id"),
	"mod_name"                to prop("mod_name"),
	"mod_license"             to prop("mod_license"),
	"mod_version"             to prop("mod_version"),
	"mod_authors"             to prop("mod_authors"),
	"mod_description"         to prop("mod_description"),
)

val generateModMetadata = tasks.register<ProcessResources>("generateModMetadata") {
	inputs.properties(replaceProperties)
	expand(replaceProperties)
	from("src/main/templates")
	into("build/generated/sources/modMetadata")
}

val generateTestModMetadata = tasks.register<ProcessResources>("generateTestModMetadata") {
	inputs.properties(replaceProperties)
	expand(replaceProperties)
	from("src/test/templates")
	into("build/generated/sources/testModMetadata")
}

// Include the output of "generateModMetadata" as an input directory for the build
// this works with both building through Gradle and the IDE.
sourceSets.main.get().resources.srcDir(generateModMetadata)
sourceSets.test.get().resources.srcDir(generateTestModMetadata)
// To avoid having to run "generateModMetadata" manually, make it run on every project reload
tasks.ideaSyncTask.configure {
	dependsOn(generateModMetadata)
	dependsOn(generateTestModMetadata)
}

publishing {
	publications {
		register<MavenPublication>("mavenJava") {
			from(components["java"])
			artifactId = prop("mod_id")
		}
	}

	repositories {
		maven("file://${project.projectDir}/repo")
	}
}
