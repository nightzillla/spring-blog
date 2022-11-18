package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Coffee;
import com.codeup.springblog.models.Post;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

        @GetMapping("/")
//        @ResponseBody
        public String allPosts(Model model) {
            Post post1 = new Post("all Posts","I am testing for title");
            Post post2 = new Post("all Body","I am testing for body");
            List<Post> allPostsList = new ArrayList<>(List.of(post1, post2));
            model.addAttribute("allPosts",allPostsList);
            return "/posts/show";
        }

        @GetMapping("/{id}")
//        @ResponseBody
        public String onePost(@PathVariable int id, Model model) {
            Post singlePost = new Post ("My Title", "My Body");
            model.addAttribute("aPost", singlePost);
            return "/posts/show";
        }
//        return "view an individual post " + id;
//    }

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
