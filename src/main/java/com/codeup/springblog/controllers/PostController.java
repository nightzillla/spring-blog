package com.codeup.springblog.controllers;

import com.codeup.springblog.config.EmailService;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepositories;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final EmailService emailService;

    public PostController(PostRepositories postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/")
    public String allPosts(Model model) {

        List<Post> allPostsList = postDao.findAll();
        model.addAttribute("posts", allPostsList);
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

    @GetMapping("/posts/{id}")
    public String twoPost(@PathVariable long id, Model model) {
        Post post = postDao.findById(id);
        model.addAttribute("post", post);
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreatePostForm(Model model){
        model.addAttribute("post", new Post ());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String submitPost(@ModelAttribute Post post){
        User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long userId = loginUser.getId();
        loginUser = userDao.findById(userId);
        post.setUser(loginUser);
        postDao.save(post);
        emailService.prepareAndSent(loginUser, post.getTitle(),post.getBody());
        return "redirect:/";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditPost(Model model,  @PathVariable long id ){
        Post post = postDao.findById(id);
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post) {

        List<User> userList = userDao.findAll();
        postDao.save(post);
        return "redirect:/";
    }

}
