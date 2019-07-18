package com.example.demo.configuration;

import com.example.demo.model.Arguments;
import com.example.demo.service.cli.ArgumentsReader;
import com.example.demo.service.html.ContentProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Autowired
    private ArgumentsReader argumentsReader;

    @Bean
    public Arguments getArguments(){
        return argumentsReader.getArguments();
    }


}
