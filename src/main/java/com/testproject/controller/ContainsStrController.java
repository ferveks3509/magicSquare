package com.testproject.controller;

import com.testproject.service.ContainsStrService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContainsStrController {

    private final ContainsStrService containsStrService;

    public ContainsStrController(ContainsStrService containsStrService) {
        this.containsStrService = containsStrService;
    }

    @PostMapping("/contains")
    public String contains(@RequestParam("firstInput") String firstInput,
                           @RequestParam("secondInput") String secondInput, Model model) {
        model.addAttribute("resultStr", containsStrService.sortedString(firstInput, secondInput));
        return "index";
    }

    @PostMapping("/containsSave")
    public String containsSave(@RequestParam("firstInput") String firstInput,
                               @RequestParam("secondInput") String secondInput, Model model) {
        model.addAttribute("resultStr", containsStrService.sortedSave(firstInput, secondInput));
        return "index";
    }
}
