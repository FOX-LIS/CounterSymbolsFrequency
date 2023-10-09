package com.example.counterfreq.services;

import com.example.counterfreq.dto.CountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CounterServiceImpl implements CounterService{

    public CountResponse countSymbols(String inputStr){
        if (inputStr == null || inputStr.isBlank()) {
            return new CountResponse(new LinkedHashMap<>());
        }
        inputStr = inputStr.toLowerCase().replaceAll("\\s", "");
        HashMap<Character, Integer> freqSymbolMap = new HashMap<>();
        for (int i = 0; i < inputStr.length(); i++) {
            char curChar = inputStr.charAt(i);
            addSymbolToMap(freqSymbolMap, curChar);
        }
        LinkedHashMap<Character, Integer> sortedMap = sortMap(freqSymbolMap);
        return new CountResponse(sortedMap);
    }

    private static void addSymbolToMap(HashMap<Character, Integer> freqSymbolMap, char curChar) {
        if (freqSymbolMap.containsKey(curChar)) {
            int count = freqSymbolMap.get(curChar);
            freqSymbolMap.put(curChar, ++count);
        } else {
            freqSymbolMap.put(curChar, 1);
        }
    }

    private static LinkedHashMap<Character, Integer> sortMap(Map<Character, Integer> map){
        return map.entrySet().stream()
                        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    }
}
