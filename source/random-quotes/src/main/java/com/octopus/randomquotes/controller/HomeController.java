package com.octopus.randomquotes.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${app.version}")
    private String appVersion;

    @Value("${environment.name}")
    private String environmentName;

    @RequestMapping("/")
    public String home() {

        return "Running " + appVersion + " in " + environmentName;
    }

}
