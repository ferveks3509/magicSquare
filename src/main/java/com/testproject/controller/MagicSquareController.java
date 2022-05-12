package com.testproject.controller;

import com.testproject.service.MagicSquareService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MagicSquareController {

    private final MagicSquareService magicSquareService;

    public MagicSquareController(MagicSquareService magicSquareService) {
        this.magicSquareService = magicSquareService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/magicSquare")
    public String inputNumb(@RequestParam("magicSq") String magicSq, Model model) {
        model.addAttribute("result",magicSquareService.save(magicSq));
        return "index";
    }

    @PostMapping("/magicSquareCount")
    public String inputValue(@RequestParam("magicSq") String magicSq, Model model) {
        model.addAttribute("result",magicSquareService.result(magicSq));
        return "index";
    }

    @PostMapping("/saveFile")
    public String saveFile(@RequestParam("fileName") String fileName,
                           @RequestParam("magicSq") String magicSq) {
        magicSquareService.saveFile(magicSq, fileName);
        return "index";
    }

    @PostMapping("/findByDate")
    public String findByDate(@RequestParam("localDate") String localDate, Model model) {
        model.addAttribute("magicSquares", magicSquareService.findByDate(localDate));
        return "index";
    }

    @PostMapping("/findFile")
    public String findFile(@RequestParam("fileName") String fileName, Model model) {
        magicSquareService.loadFile(fileName);
        model.addAttribute("result", magicSquareService.loadFile(fileName));
        return "index";
    }
}
