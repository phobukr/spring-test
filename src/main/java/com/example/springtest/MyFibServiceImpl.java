package com.example.springtest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MyFibServiceImpl implements MyFibService {

    @Override
    public List<Integer> generateFibonacciNumbers(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("Count must be a positive integer");
        }

        List<Integer> fibonacciNumbers = new ArrayList<>();
        int a = 0;
        int b = 1;

        for (int i = 0; i < count; i++) {
            fibonacciNumbers.add(a);
            int sum = a + b;
            a = b;
            b = sum;
        }

        return fibonacciNumbers;
    }
}