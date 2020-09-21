import de.fayard.refreshVersions.bootstrapRefreshVersions
buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("de.fayard.refreshVersions:refreshVersions:0.9.5")
    }
}
bootstrapRefreshVersions()

rootProject.name = "oop-lab-slides"
include(":00 - intro")
include(":01 - java-basic-tools")
include(":02 - java-advanced-tools")
include(":03 - eclipse")
include(":04 - dvcs-1")
include(":05 - dvcs-2")
include(":06 - dvcs-testing")
include(":07 - javadoc-jar")
include(":08 - code-quality-multiplatform-profiling")
include(":09 - dvcs-workflow")
include(":10 - javafx")
include(":13 - report-template")