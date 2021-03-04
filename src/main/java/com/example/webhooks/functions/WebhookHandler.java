package com.example.webhooks.functions;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class WebhookHandler {

    @Bean
    public Function<String, String> respondToSms(){
        return String::toUpperCase;
    }
}
