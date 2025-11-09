pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "FormulaOne"
include(
    ":app",
    ":core:api",
    ":core:database",
    ":core:design",
    ":core:navigation",

    ":features:debug:data",
    ":features:debug:presentation",

    ":features:home:data",
    ":features:home:presentation",

    ":features:settings:data",
    ":features:settings:presentation",
)
