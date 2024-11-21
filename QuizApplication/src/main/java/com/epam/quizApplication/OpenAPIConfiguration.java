package com.epam.quizApplication;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName(" : Ashish Singh Rana");
        myContact.setEmail("asish_rana@epam.com");

        Info information = new Info()
                .title("Quiz Application API")
                .version("1.0")
                .description("This API exposes endpoints to manage Quiz.")
                .contact(myContact);
        return new OpenAPI().info(information).servers(Collections.singletonList(server));
    }
}