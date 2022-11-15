package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    @RequestMapping(path = "/add/{number}/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public int addThreePlusFour(@PathVariable int number, @PathVariable int number2) {
        return number + number2;
    }

    @RequestMapping(path = "/subtract/{number}/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public int subtractThreeFromTen(@PathVariable int number, @PathVariable int number2) {
        return number - number2;
    }

    @RequestMapping(path = "/multiply/{number}/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public int multiplyFourFromFive(@PathVariable int number, @PathVariable int number2) {
        return number * number2;
    }

    @RequestMapping(path = "/divide/{number}/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public double multiplyFourFromFive(@PathVariable double number, @PathVariable double number2) {
        return number * number2;
    }
}
