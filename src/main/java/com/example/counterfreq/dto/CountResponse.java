package com.example.counterfreq.dto;

import java.util.LinkedHashMap;
public record CountResponse(LinkedHashMap<Character, Integer> resultMap) {}
