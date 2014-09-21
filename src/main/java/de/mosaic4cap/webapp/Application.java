package de.mosaic4cap.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Lobedan on 21.09.2014.
 *
 * Entrypoint for mosaic4cap webapplication
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@ImportResource(value = "classpath:/META-INF/*.xml")
public class Application extends SpringBootServletInitializer {

    //CHECKSTYLE:OFF
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    //CHECKSTYLE:ON
}