package rocklike.test.kotlin

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


//@EnableWebSecurity
//class WebSecurityConfig() : WebSecurityConfigurerAdapter() {
//    override fun configure(http: HttpSecurity) {
//        http.cors().and().csrf().disable()
//                .authorizeRequests()
//                .anyRequest()
//                .permitAll()
//    }
//}

@Configuration
class WebMvcConfig() : WebMvcConfigurer {
    val logger = LoggerFactory.getLogger(this.javaClass.name)
    override fun addViewControllers(registry: ViewControllerRegistry) {
        logger.info("=== addViewControllers")
//        registry.addRedirectViewController("/new", "/new/index.html")
//        registry.addRedirectViewController("/new/", "/new/index.html")
    }
}