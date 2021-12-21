package com.lfcode.msecommerceconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MsEcommerceConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsEcommerceConfigServerApplication.class, args);
    }

}
