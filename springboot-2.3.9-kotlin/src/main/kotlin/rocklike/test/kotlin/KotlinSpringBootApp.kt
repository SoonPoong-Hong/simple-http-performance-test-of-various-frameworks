package rocklike.test.kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringBoot

fun main(args: Array<String>) {
	runApplication<KotlinSpringBoot>(*args)
}
