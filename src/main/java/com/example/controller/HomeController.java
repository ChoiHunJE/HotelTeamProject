package com.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest request,
                   Model model) {
       
       model.addAttribute("channel", "ok java");
       
        return "index";
    }
    
    @GetMapping("/locale")
    public String changeLocale(@RequestParam String language,
                         Model model) {
       System.out.println("language selected = " + language);
       model.addAttribute("channel", "ok java");
       
       return "index";
    }
    
}