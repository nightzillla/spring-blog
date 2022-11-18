package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Roll_DiceController {

    @GetMapping(path = "/roll-dice/{num}")
    public String roll(@PathVariable int num, Model model) {
        model.addAttribute("randomNumber",(int)(6.0 * Math.random()) + 1);
        return "roll_Dice";
    }

}
