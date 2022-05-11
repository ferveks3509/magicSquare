package com.testproject.service;

import com.testproject.model.ContainsStrModel;
import com.testproject.repository.ContainsStrRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContainsStrService {

    private final ContainsStrRepository containsStrRepository;

    public ContainsStrService(ContainsStrRepository containsStrRepository) {
        this.containsStrRepository = containsStrRepository;
    }

    public List<ContainsStrModel> findByDate(String localDate) {
        return containsStrRepository.findByCreated(localDate);
    }


    public TreeSet<String> sortedString(String inputFirst, String inputSecond) {
        TreeSet<String> rsl = new TreeSet<>();
        String[] first = inputFirst.split(" ");
        String[] second = inputSecond.split(" ");
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