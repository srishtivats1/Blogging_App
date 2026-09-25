package com.blog.BloggingProject.controller;

import com.blog.BloggingProject.model.Post;
import org.springframework.ui.Model;
import com.blog.BloggingProject.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable Long id, Model model) {
        Post post =repo.findById(id).orElse(null);
        model.addAttribute("post", post);
        return "edit_post";
    }
    @GetMapping("/post/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        Post post = repo.findById(id).orElse(null);
        model.addAttribute("post", post);
        return "view_post";
    }

    @PostMapping("/update")
    public String updatePost(Post post) {
        repo.save(post);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/";
    }
}
