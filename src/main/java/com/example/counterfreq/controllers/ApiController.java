package com.example.counterfreq.controllers;

import com.example.counterfreq.dto.CountResponse;
import com.example.counterfreq.services.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final CounterService counterService;

    @GetMapping("/countSymbols/{string}")
    public ResponseEntity<CountResponse> countSymbols(@PathVariable("string") String inputString) {
        CountResponse response = counterService.countSymbols(inputString);
        return ResponseEntity.ok(response);
    }

}
