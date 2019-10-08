package com.giant.cloud.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GiantDubboApplication {

    public static void main(String[] args) {
        SpringApplication.run(GiantDubboApplication.class, args);
    }
}
