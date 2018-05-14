package com.yash.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.yash.demo.domain.FileModel;

@SpringBootApplication
@EnableConfigurationProperties({
    FileModel.class
})
public class Gmsr_ui_screen extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Gmsr_ui_screen.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Gmsr_ui_screen.class, args);
    }

}
