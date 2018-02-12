package com.octopus.randomquotes.controller;

import com.octopus.randomquotes.model.Quote;
import com.octopus.randomquotes.repository.QuoteRepositoryStub;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
public class QuotesController {

    @Value("${app.version}")
    private String appVersion;

    @Value("${environment.name}")
    private String environmentName;

    @RequestMapping("/quote")
    public String quote(Model model) {

        Random rand = new Random();
        long index = rand.nextInt(10) + 1;
        Quote randomQuote = QuoteRepositoryStub.get(index);

        model.addAttribute("quote", randomQuote.getQuoteText());
        model.addAttribute("author", randomQuote.getAuthor());

        return "quote";
    }

}
