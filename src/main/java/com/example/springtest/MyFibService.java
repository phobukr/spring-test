package com.example.springtest;

import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;

public interface MyFibService {
    List<Integer> generateFibonacciNumbers(int n);
}

class MyFibServiceImpl implements MyFibService {

    @Override
    public List<Integer> generateFibonacciNumbers(int n) {
        try {
            validateInput(n);
            List<Integer> fibNumbers = generateFibonacciSequence(n);
            renderOutput(fibNumbers);
            return fibNumbers;
        } catch (Exception e) {
            handleException(e);
            throw e;
        }
    }

    private void validateInput(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input should be a non-negative integer");
        }
        if (n > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Input is too large");
        }
    }

    private List<Integer> generateFibonacciSequence(int n) {
        if (n == 0) {
            return List.of();
        }

        if (n == 1) {
            return List.of(0);
        }

        if (n == 2) {
            return List.of(0, 1);
        }

        List<Integer> fibNumbers = new ArrayList<>(List.of(0, 1));
        int i = 2;
        long last = 1;
        long secondLast = 0;

        while (i < n) {
            long next = last + secondLast;
            if (next > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("Input is too large");
            }
            fibNumbers.add((int) next);
            secondLast = last;
            last = next;
            i++;
        }

        return fibNumbers;
    }

    private void renderOutput(List<Integer> fibNumbers) {
        System.out.println("Fibonacci sequence: " + fibNumbers);
    }

    private void handleException(Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
}