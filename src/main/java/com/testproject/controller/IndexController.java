package com.testproject.controller;

import com.testproject.service.ContainsStr;
import com.testproject.service.MagicSquareService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    private final MagicSquareService magicSquareService;
    private final ContainsStr containsStrService;

    public IndexController(MagicSquareService magicSquareService, ContainsStr containsStr) {
        this.magicSquareService = magicSquareService;
        this.containsStrService = containsStr;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/magicSquare")
    public String inputNumb(@RequestParam("magicSq") String magicSq, Model model) {
        model.addAttribute("result",magicSquareService.save(magicSq));
        model.addAttribute("result2", "hello");
        return "index";
    }
}
