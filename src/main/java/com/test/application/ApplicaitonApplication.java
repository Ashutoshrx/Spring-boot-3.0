package com.test.application;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@OpenAPIDefinition(info = @Info(
        title = "User API",
        version = "1.0.0",
        description = "User Description",
        termsOfService = "Enact's Terms & conditions",
        contact = @Contact(name = "Ashutosh Satapathy",
                email = "xyz@enact.com"),
        license = @License(name = "Apache 2.0", url = "Enact Dummy Project")
))
public class ApplicaitonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicaitonApplication.class, args);
    }

}
