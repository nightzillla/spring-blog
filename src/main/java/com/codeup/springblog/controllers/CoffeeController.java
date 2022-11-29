package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Coffee;
import com.codeup.springblog.models.Supplier;
import com.codeup.springblog.repositories.CoffeeRepositories;
import com.codeup.springblog.repositories.SupplierRepositories;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {

    private final CoffeeRepositories coffeesDao;
    private final SupplierRepositories suppliersDao;
    public CoffeeController(CoffeeRepositories coffeesDao, SupplierRepositories suppliersDao){
        this.coffeesDao = coffeesDao;
        this.suppliersDao = suppliersDao;
    }
    @GetMapping
    public String coffee(){
        return "coffee";
    }

    @GetMapping("/{roast}")
    public String roast(@PathVariable String roast, Model model){
        Coffee selection = new Coffee(roast, "Cool Beans");
        Coffee selection2 = new Coffee(roast, "Coffee Bros");
        selection.setOrigin("Ethiopia");
        selection2.setOrigin("Vietnam");
        List<Coffee> selections = new ArrayList<>(List.of(selection, selection2));
        model.addAttribute("selections", selections);
        return "coffee";
    }
    @PostMapping
    public String singUp(@RequestParam(name="email") String email, Model model){
        model.addAttribute("email", email);
        return "coffee";
    }
    @GetMapping("/suppliers")
    public String showSuppliersForm(Model model){
        List<Supplier> suppliers = suppliersDao.findAll();
        model.addAttribute("suppliers", suppliers);
        return "/suppliers";
    }
    @PostMapping("/suppliers")
    public String insertSupplier(@RequestParam(name = "name") String name){
        Supplier supplier = new Supplier(name);
        suppliersDao.save(supplier);
        return "redirect:/coffee/suppliers";
    }

    @GetMapping("/register")
    public String showRegistrationForm(){
        return "/registration";
    }

    @PostMapping("/customer/new")
    public String RegisterCustomer() {
        return "redirect:/coffee";
    }





} // end of CoffeeController
