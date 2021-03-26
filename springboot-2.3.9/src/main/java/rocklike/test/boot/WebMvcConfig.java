package rocklike.test.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void addViewControllers( ViewControllerRegistry registry) {
        logger.info("=== addViewControllers");
    }

}