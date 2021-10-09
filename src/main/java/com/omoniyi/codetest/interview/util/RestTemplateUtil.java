package com.omoniyi.codetest.interview.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateUtil {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
