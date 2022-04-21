package br.com.springboot.service;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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