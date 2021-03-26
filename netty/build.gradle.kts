import org.gradle.jvm.tasks.Jar
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
    id("eclipse")
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    application
    java
}

group = "rocklike.test"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.isDeprecation = true
    options.release.set(11)
    // options.compilerArgs.add("-Xlint:unchecked")
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencyManagement {
    imports {
        mavenBom("io.netty:netty-bom:4.1.60.Final")
        mavenBom("org.junit:junit-bom:5.6.2")
    }
}
dependencies {
    implementation("io.netty:netty-codec-http")
    implementation("org.slf4j:slf4j-simple:1.7.30")
    compileOnly("org.projectlombok:lombok:1.18.18")

    annotationProcessor("org.projectlombok:lombok:1.18.18")
}

val theMainClass = "rocklike.test.netty.NettyHttpServer"

val mainClassName = theMainClass
application {
    mainClass.set(theMainClass)
}

// https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow
// https://imperceptiblethoughts.com/shadow/getting-started/#default-java-groovy-tasks
// https://stackoverflow.com/questions/53853474/shadowjar-no-value-has-been-specified-for-property-mainclassname
// gradle shadowJar

//=== [주의] shadowJar 에서 필요함.
project.setProperty("mainClassName", theMainClass)

tasks.withType<ShadowJar>() {
    archiveFileName.set("netty-fat.jar")
    manifest {
        attributes["Main-Class"] = theMainClass
    }
}
