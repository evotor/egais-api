// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        mavenCentral()
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
        mavenCentral()
        google()
        maven {
            url = uri("https://jitpack.io")
        }
    }
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}
