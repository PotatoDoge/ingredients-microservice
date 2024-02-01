package com.ingredients.ms.ingredientsmicroservice.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalAuthenticationService {

    private final String externalAuthUrl;
    private final RestTemplate restTemplate;

    public ExternalAuthenticationService(@Value("${external.auth.url}") String externalAuthUrl, RestTemplate restTemplate) {
        this.externalAuthUrl = externalAuthUrl;
        this.restTemplate = restTemplate;
    }

    public boolean authenticateToken(String authToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authToken);
        int responseStatusCode = 0;

        try{
            HttpEntity<String> entity = new HttpEntity<>(headers);


            ResponseEntity<String> response = restTemplate.exchange(
                    externalAuthUrl,
                    HttpMethod.GET,
                    entity,
                    String.class
            );

            responseStatusCode = response.getStatusCode().value();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return responseStatusCode == 200;
    }
}


