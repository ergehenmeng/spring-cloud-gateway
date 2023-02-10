package com.eghm.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class GatewayApplication {

    @Value("${nacos.name}")
    private String nacosName;

    public static void main(String[] args) {
        new SpringApplicationBuilder(GatewayApplication.class).web(WebApplicationType.REACTIVE).build().run(args);
    }

    @GetMapping("/nacos/name")
    public String nacos() {
        return nacosName;
    }
}
