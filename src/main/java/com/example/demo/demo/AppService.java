package com.example.demo.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class AppService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    // Method to fetch data using RestTemplate (Synchronous)
//    public String getDataFromApi() {
//        String apiUrl = "http://localhost:8080/inventory";  // Example API URL
//        return restTemplate.getForObject(apiUrl, String.class);
//    }

    public List<Map<String, Object>> getDataFromApi() {
        // Call the API using RestTemplate to get the raw JSON response as a String
        String apiUrl = "http://localhost:8080/inventory";
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);

        try {
            // Use Jackson's ObjectMapper to convert the JSON string to List<Map<String, Object>>
            return objectMapper.readValue(jsonResponse, new TypeReference<List<Map<String, Object>>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Or throw an exception as needed
        }
    }
}
