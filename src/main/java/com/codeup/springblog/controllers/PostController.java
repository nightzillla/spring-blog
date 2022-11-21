package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Coffee;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepositories;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    private final PostRepositories postDao;

    public PostController(PostRepositories postDao) {
        this.postDao = postDao;
    }
        @GetMapping
//        @ResponseBody
        public String allPosts(Model model) {
//            Post post1 = new Post(1,"First","This is my first post!!");
//            Post post2 = new Post(2,"Second","Hey everyone, I'm back");
            List<Post> allPostsList = postDao.findAll();
            model.addAttribute("post",allPostsList);
//            return "/posts/show";
            return "/posts/index";
        }

        @GetMapping("/{id}")
//        @ResponseBody
        public String onePost(@PathVariable long id, Model model) {
            Post post1 = new Post(1,"First","This is my first post!!");
            Post post2 = new Post(2,"Second","Hey everyone, I'm back");
            Post post3 = new Post(3,"yo","heye heye heyyyy");
            List<Post> allPosts = new ArrayList<>(List.of(post1, post2, post3));
            Post post = null;
            for (Post UserPost : allPosts){
                if(UserPost.getId() == id){
                    post = UserPost;
                }
            }
            model.addAttribute("post", post);
            return "/posts/show";
        }
//        return "view an individual post " + id;
//    }
        @GetMapping("/post/create")
//        @ResponseBody
        public String postsCreate() {
            return "posts/create";
//            return "view the form for creating a post";
        }
        @PostMapping("/create")
//        @ResponseBody
        public String postsCreatePost(@RequestParam (name = "title") String title, @RequestParam (name = "body")String body) {
            Post post = new Post (title, body);
            postDao.save(post);
            return "redirect:/post";
        }
}
