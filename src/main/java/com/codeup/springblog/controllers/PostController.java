package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/post")
public class PostController {

        @GetMapping
        @ResponseBody
        public String allpPosts() {
            return "post index page";
        }

        @GetMapping("/{id}")
        @ResponseBody
        public String onePost(@PathVariable long id) {
            return "view an individual post " + id;
        }

        @GetMapping("/posts/create")
        @ResponseBody
        public String postsCreate() {
            return "view the form for creating a post";
        }

        @PostMapping("/posts/create")
        @ResponseBody
        public String postsCreatePost() {
            return "create a new post";
        }


}
