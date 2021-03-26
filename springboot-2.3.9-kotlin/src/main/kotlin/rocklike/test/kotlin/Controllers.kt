package rocklike.test.kotlin

import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class PocController() {
    val logger = LoggerFactory.getLogger(this.javaClass.name)

    @RequestMapping(path = ["/ping/{p}"], produces = [MediaType.TEXT_PLAIN_VALUE])
    fun ping(@PathVariable p: String?): ResponseEntity<String> {
        val p3 = p+p+p
        return ResponseEntity.ok().body(p3)
    }

    @RequestMapping(path = ["/bksdfkqfl-no-use/{p}"])
    fun others(@PathVariable p: String?): ResponseEntity<String> {
        val p3 = p+p+p
        return ResponseEntity.ok().body(p3)
    }

    @RequestMapping(path = ["/bkskfaks-no-use/{p}"])
    fun others2(@PathVariable p: String?): ResponseEntity<String> {
        val p3 = p+p+p
        return ResponseEntity.ok().body(p3)
    }

    @RequestMapping(path = ["/vxkcvka-no-use/{p}"])
    fun others3(@PathVariable p: String?): ResponseEntity<String> {
        val p3 = p+p+p
        return ResponseEntity.ok().body(p3)
    }

}