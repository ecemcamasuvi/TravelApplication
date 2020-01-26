package com.basic.system;

import com.basic.business.controller.DestinationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(DemoApplication.class).headless(false).run(args);
        DestinationController destinationController = (DestinationController) context.getBean(DestinationController.class);
        destinationController.init();
    }

}
