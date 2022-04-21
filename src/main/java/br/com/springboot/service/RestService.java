package br.com.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.constructor.Construct;


// @Service
public class RestService {

    // @Value("${omdbapi.url}")

    private String params;

    public RestService(String params) {
        this.params = params;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String getOMDBApi() {
        String url = "http://www.omdbapi.com/?apikey=bb182d9e&"+this.params;
        return this.restTemplate().getForObject(url, String.class);
    }
}