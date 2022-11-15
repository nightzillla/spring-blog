package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    @GetMapping(path = "/add/{number}/and/{number2}")
    @ResponseBody
    public int addThreePlusFour(@PathVariable int number, @PathVariable int number2) {
        return number + number2;
    }

    @GetMapping(path = "/subtract/{number}/from/{number2}")
    @ResponseBody
    public int subtractThreeFromTen(@PathVariable int number, @PathVariable int number2) {
        return number - number2;
    }

    @GetMapping(path = "/multiply/{number}/{number2}")
    @ResponseBody
    public int multiplyFourFromFive(@PathVariable int number, @PathVariable int number2) {
        return number * number2;
    }

    @GetMapping(path = "/divide/{number}/by/{number2}")
    @ResponseBody
    public double multiplyFourFromFive(@PathVariable double number, @PathVariable double number2) {
        return number / number2;
    }
}
