package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("roll-dice")
public class DiceController {

//    @GetMapping(path = "/roll-dice/{num}")
//    public String diceRoll(@PathVariable int num, Model model) {
//        model.addAttribute("randomNumber",(int)(6.0 * Math.random()) + 1);
//        return "roll_dice";
//    }
    @GetMapping
    public String diceRoll(){
        return "roll-dice";
    }
    @GetMapping("/{guess}")
    public String showRoll(@PathVariable String guess, Model model){
        int randomNumber = (int) (Math.random() *6) + 1;
        model.addAttribute("randomNumber", randomNumber);
        model.addAttribute("userGuess", guess);
        return "roll-dice";
    }
}
