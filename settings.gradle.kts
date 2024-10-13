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

rootProject.name = "FakeHH"

include(":app")

include(":common")
include(":common:utilities")
include(":common:ui")

include(":data")
include(":data:network")
include(":data:database")

include(":domain")

include(":features")
include(":features:main")
include(":features:favorite")
include(":features:vacancy")





