package com.example.project.contract;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;


/**
 * configuration class for spring-cloud-contract-verifier
 */
@SpringBootTest(classes = BaseClassForContractTests.Config.class)
public class BaseClassForContractTests {

    @Autowired
    WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @EnableAutoConfiguration // (exclude = {which config classes we want to exclude})
    @Configuration
    @ComponentScan(basePackages = {"com.example.project"})
    static class Config {
        // we could also add some @Bean-s here
    }
}
