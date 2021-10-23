package com.matrixboot.leiai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author shishaodong
 */
@EnableJpaAuditing
@EnableFeignClients
@SpringBootApplication
public class LeiAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeiAiApplication.class, args);
    }

}
