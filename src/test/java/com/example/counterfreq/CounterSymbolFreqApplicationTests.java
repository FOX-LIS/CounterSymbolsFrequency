package com.example.counterfreq;

import com.example.counterfreq.dto.CountResponse;
import com.example.counterfreq.services.CounterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CounterSymbolFreqApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    CounterService counterService;

    @Test
    void testCounterForTypicalInputString() {
        String inputString = "aaaaabcccc";
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        map.put('a', 5);
        map.put('c', 4);
        map.put('b', 1);
        CountResponse expectedResponse = new CountResponse(map);
        CountResponse actualResponse = counterService.countSymbols(inputString);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void testCounterForEmptyString() {
        String inputString = "";
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        CountResponse expectedResponse = new CountResponse(map);
        CountResponse actualResponse = counterService.countSymbols(inputString);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void testCounterForNullString() {
        String inputString = null;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        CountResponse expectedResponse = new CountResponse(map);
        CountResponse actualResponse = counterService.countSymbols(inputString);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void testCounterForStringWithSpaces() {
        String inputString = "ррffр рр ррfрр";
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        map.put('р', 9);
        map.put('f', 3);
        CountResponse expectedResponse = new CountResponse(map);
        CountResponse actualResponse = counterService.countSymbols(inputString);
        assertEquals(expectedResponse, actualResponse);
    }

}
