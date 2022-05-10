package com.testproject.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContainsStr {

    public TreeSet<String> sortedArrays(String[] first, String[] second) {
        TreeSet<String> rsl = new TreeSet<>();
        for (String value : first) {
            for (String s : second) {
                if (s.contains(value)) {
                    rsl.add(value);
                }
            }
        }
        return rsl;
    }
}
