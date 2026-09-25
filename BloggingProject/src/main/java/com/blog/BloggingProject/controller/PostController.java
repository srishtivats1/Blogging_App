package com.blog.BloggingProject.controller;

import com.blog.BloggingProject.model.Post;
import org.springframework.ui.Model;
import com.blog.BloggingProject.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class PostController {
    @Autowired
    PostRepo repo;
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("post",repo.findAll());
        return "index";
    }
    @GetMapping("/new")
    public String showNewPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "new_post";
    }

    @PostMapping("/save")
    public String savePost(Post post) {
        repo.save(post);
        return "redirect:/";
    }
}
