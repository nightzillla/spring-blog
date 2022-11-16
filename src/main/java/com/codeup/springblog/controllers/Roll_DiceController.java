package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roll-dice/n")
public class Roll_DiceController {

    int roll() {
        return (int)(6.0 * Math.random()) + 1;
    }

}
