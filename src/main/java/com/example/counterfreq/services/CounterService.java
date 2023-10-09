package com.example.counterfreq.services;

import com.example.counterfreq.dto.CountResponse;

public interface CounterService {
    CountResponse countSymbols(String inputStr);
}
