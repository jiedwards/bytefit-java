//package com.example.bytefit.bytefit.controller;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = FoodController.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class FoodControllerTest {
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @LocalServerPort
//    private int port;
//
//    private String getRootUrl() {
//        return "http://localhost:" + port;
//    }
//    @Test
//    public void contextLoads() {
//    }
//
//    @Test
//    public void testGetAllFoods() {
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/foods",
//                HttpMethod.GET, entity, String.class);
//        Assert.assertNotNull(response.getBody());
//    }
//
//}