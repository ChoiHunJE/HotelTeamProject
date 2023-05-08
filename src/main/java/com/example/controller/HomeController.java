package com.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest request) {
    	
    	Locale currentLocale = request.getLocale();
    	String countryCode = currentLocale.getCountry();
    	String countryName = currentLocale.getDisplayCountry();
    	
    	String langCode = currentLocale.getLanguage();
    	String langName = currentLocale.getDisplayLanguage();
    	
    	System.out.println(countryCode + ": " + countryName);
    	System.out.println(langCode + ": " + langName);
    	
    	System.out.println("=================");
    	String[] languages = Locale.getISOLanguages();
    	
    	for (String language : languages) {
    		Locale locale = new Locale(language);
    		System.out.println(language + ": " + locale.getDisplayLanguage());
    	}
    	
        return "index";
    }
}
