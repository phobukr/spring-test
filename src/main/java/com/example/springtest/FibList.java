package com.example.springtest;

import java.util.ArrayList;
import java.util.List;

public class FibList {
    private int num;
    private List<Long> fibSequence;
    private boolean isTruncated;

    public FibList(int num) {
        this.num = num;
        this.fibSequence = new ArrayList<>();
        this.isTruncated = false;
        validateInput();
        generateFibonacci();
    }

    private void validateInput() {
        if (num < 0) {
            throw new IllegalArgumentException("Input number cannot be negative");
        }
    }

    private void generateFibonacci() {
        if (num == 0) {
            return;
        }
        if (num == 1) {
            fibSequence.add(0L);
            return;
        }
        fibSequence.add(0L);
        fibSequence.add(1L);
        int i = 2;
        while (i < num) {
            long next = fibSequence.get(i - 1) + fibSequence.get(i - 2);
            if (next > Long.MAX_VALUE) {
                isTruncated = true;
                break;
            }
            fibSequence.add(next);
            i++;
        }
    }

    public List<Long> getFibSequence() {
        return fibSequence;
    }

    public String getTruncationMessage() {
        if (isTruncated) {
            return "The Fibonacci sequence has been truncated due to exceeding the maximum limit.";
        } else {
            return "";
        }
    }
}