package com.cine_play.web.controller;

import com.cine_play.domain.service.CinePlayAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final String plataform;
    private final CinePlayAiService aiService;

    public HelloController(@Value("${spring.application.name}") String plataform, CinePlayAiService aiService) {
        this.plataform = plataform;
        this.aiService = aiService;
    }

    @GetMapping("/hello")
    public String hello() {
        return this.aiService.generateGreeting(plataform);
    }
}
