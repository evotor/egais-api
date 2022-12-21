// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        maven {
            url = uri("http://10.12.76.10:8080/content/groups/public-release")
            isAllowInsecureProtocol = true
        }
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
        google()

    }

    dependencies {
        classpath("com.android.tools.build:gradle:4.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:1.6.0")
    }
}

allprojects {
    repositories {
        maven {
            url = uri("http://10.12.76.10:8080/content/groups/public-release")
            isAllowInsecureProtocol = true
        }
        google()
        maven {
            url = uri("https://jitpack.io")
        }
    }
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}
