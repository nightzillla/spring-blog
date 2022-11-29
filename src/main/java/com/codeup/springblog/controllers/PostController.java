package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepositories;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/post")
public class PostController {

    private final PostRepositories postDao;
    private final UserRepository userDao;

    public PostController(PostRepositories postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping
    public String allPosts(Model model) {

        List<Post> allPostsList = postDao.findAll();
        model.addAttribute("post", allPostsList);
        return "/posts/index";
    }

    @GetMapping("/{id}")
    public String onePost(@PathVariable long id, Model model) {
        Post post1 = new Post(1, "First", "This is my first post!!");
        Post post2 = new Post(2, "Second", "Hey everyone, I'm back");
        Post post3 = new Post(3, "yo", "heye heye heyyyy");
        List<Post> allPosts = new ArrayList<>(List.of(post1, post2, post3));
        Post post = null;
        for (Post UserPost : allPosts) {
            if (UserPost.getId() == id) {
                post = UserPost;
            }
        }
        model.addAttribute("post", post);
        return "/posts/show";
    }

    @GetMapping("/post/{id}")
    public String twoPost(@PathVariable long id, Model model) {
        Post post = postDao.findById(id);
        model.addAttribute("post", post);
        return "/posts/show";
    }

    @GetMapping("/post/create")
    public String addPost(){
        return "/posts/show";
    }

    @PostMapping("/post/create")
    public String submitPost(@RequestParam(name="title") String title, @RequestParam(name="body") String body){
        User user = userDao.findById(1L);
        Post post = new Post(title, body, user);
        postDao.save(post);
        return "/posts/user";
    }

    public String postsCreatePost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        Post post = new Post(title, body);
        postDao.save(post);
//            userDao.save(post);
        return "redirect:/post";
    }

//    @GetMapping("/post/user")
//    public String userCreate() {
//        return "posts/user";
//    }


}
