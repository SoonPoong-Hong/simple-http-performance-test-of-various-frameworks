plugins {
    id("org.springframework.boot") version "2.3.9.RELEASE"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("eclipse")
    application
    java
}

group = "rocklike.test"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

java.sourceCompatibility = JavaVersion.VERSION_11

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

application {
    mainClass.set("rocklike.test.boot.SpringbootServer")
}

tasks.bootJar {
    mainClassName = "rocklike.test.boot.SpringbootServer"
    archiveFileName.set("springboot.jar")
}