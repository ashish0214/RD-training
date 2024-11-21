package com.epam.quizApplication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main  {
    private static final Logger log = LogManager.getLogger(Main.class);

    @Bean
    public ModelMapper mapperMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}


