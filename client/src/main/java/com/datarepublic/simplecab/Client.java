package com.datarepublic.simplecab;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Client {

  public static void main(String[] args){
    //Sample Rest client
    RestTemplate restTemplate = new RestTemplate();
    String resourceUrl = "http://localhost:8080/cabservice/clearcache";
    ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
    System.out.println(String.format("Response status code: %s, Response body: %s",
			response.getStatusCode(), response.getBody()));
  }
}
