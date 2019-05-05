package com.jbb.uploaddemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author jbb
 */
@SpringBootApplication
public class UploadDemoApplication {
    private static Logger logger = LoggerFactory.getLogger(UploadDemoApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UploadDemoApplication.class, args);
        ConfigurableEnvironment env = context.getEnvironment();
        logger.info("\n\t项目地址：http://127.0.0.1:{}\n" +
                "\tswagger地址：http://127.0.0.1:{}/swagger-ui.html#/", env.getProperty("server.port"), env.getProperty("server.port"));
    }

}
