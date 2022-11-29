package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Coffee;
import com.codeup.springblog.models.Customer;
import com.codeup.springblog.models.Supplier;
import com.codeup.springblog.repositories.CoffeeRepositories;
import com.codeup.springblog.repositories.CustomerRepository;
import com.codeup.springblog.repositories.SupplierRepositories;
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
    private final CustomerRepository customerDao;
    public CoffeeController(CoffeeRepositories coffeesDao, SupplierRepositories suppliersDao, CustomerRepository customerDao){
        this.coffeesDao = coffeesDao;
        this.suppliersDao = suppliersDao;
        this.customerDao = customerDao;
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
    @GetMapping("/all-coffees")
    public String allCoffees(Model model){
        List<Coffee> coffees = coffeesDao.findAll();
        model.addAttribute("coffees", coffees);
        return "all-coffees";
    }

    @GetMapping("/new")
    public String addCoffeeForm(Model model){
        List<Supplier> suppliers = suppliersDao.findAll();
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("coffee", new Coffee());
        return "create-coffee";
    }
    @PostMapping("/new")
    public String addCoffeeForm(@ModelAttribute Coffee coffee){
        coffeesDao.save(coffee);
        return "redirect:/coffee/all-coffees";
    }
    @PostMapping
    public String singUp(@RequestParam(name="email") String email, Model model){
        model.addAttribute("email", email);
        return "coffee";
    }

    @GetMapping("/all")
    public String showAllCoffee(Model model){
        List<Coffee> allCoffee = coffeesDao.findAll();
        model.addAttribute("coffees", allCoffee);
        return "all-coffee";
    }
    @GetMapping("/suppliers")
    public String showSuppliersForm(Model model){
        List<Supplier> suppliers = suppliersDao.findAll();
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("supplier", new Supplier());
        return "/suppliers";
    }
    @PostMapping("/suppliers")
    public String insertSupplier(@RequestParam(name = "name") String name){
        Supplier supplier = new Supplier(name);
        suppliersDao.save(supplier);
        return "redirect:/coffee/suppliers";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("customer", new Customer());
        return "/registration";
    }


    @PostMapping("/customer/new")
    public String registerCustomer(@ModelAttribute Customer customer) {
        customerDao.save(customer);
        return "redirect:/coffee";
    }
    @PostMapping("/customer/{customerId}/favorite/{coffeeId}")
    public String favoriteCoffee(@PathVariable long customerId, @PathVariable long coffeeId) {
        Customer customer = customerDao.findById(customerId);
        List<Coffee> favorites = customer.getCoffeeList();
        favorites.add(coffeesDao.findById(coffeeId));
        customer.setCoffeeList(favorites);
        customerDao.save(customer);
        return "redirect:/coffee";
    }

} // end of CoffeeController
