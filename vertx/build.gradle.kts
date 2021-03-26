import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
  java
  application
  id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "rocklike.test.vertx"
version = "1.0.0-SNAPSHOT"

repositories {
  mavenCentral()
  mavenLocal()
}

val vertxVersion = "4.0.3"
val junitJupiterVersion = "5.7.0"

val theMainClassName = "rocklike.test.vertx.MainVerticle"
val mainVerticleName = "rocklike.test.vertx.MainVerticle"
val launcherClassName = "io.vertx.core.Launcher"

//val watchForChange = "src/**/*"
//val doOnChange = "${projectDir}/gradlew classes"

application {
  mainClass.set(theMainClassName)
}

dependencies {
  implementation(platform("io.vertx:vertx-stack-depchain:$vertxVersion"))
  implementation("io.vertx:vertx-web")
  testImplementation("io.vertx:vertx-junit5")
  testImplementation("org.junit.jupiter:junit-jupiter:$junitJupiterVersion")
}

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}

//=== [주의] shadowJar 에서 필요함.
project.setProperty("mainClassName", launcherClassName)

tasks.withType<ShadowJar> {
  archiveFileName.set("vertx-fat.jar")
  manifest {
    attributes(mapOf("Main-Verticle" to mainVerticleName))
  }
  mergeServiceFiles()
}

tasks.withType<Test> {
  useJUnitPlatform()
  testLogging {
    events = setOf(PASSED, SKIPPED, FAILED)
  }
}

//tasks.withType<JavaExec> {
//  args = listOf("run", mainVerticleName, "--redeploy=$watchForChange", "--launcher-class=$launcherClassName", "--on-redeploy=$doOnChange")
//}
