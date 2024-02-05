package com.bkaracan.champions;

import com.bkaracan.champions.dto.contact.ContactInfoDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {ContactInfoDTO.class})
@OpenAPIDefinition(
        info = @Info(
                title = "Champions microservice REST API doc.",
                version = "v1",
                contact = @Contact(
                        name = "Burak Karacan",
                        email = "burakkaracan94@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Champions microservice REST API doc."
        )
)
public class ChampionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChampionsApplication.class, args);
    }

}
