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
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

var mainClzNm = "rocklike.test.webflux.WebfluxApp"
application {
    mainClass.set(mainClzNm)
}

tasks.bootJar {
    mainClassName = mainClzNm
    archiveFileName.set("springboot-webflux.jar")
}