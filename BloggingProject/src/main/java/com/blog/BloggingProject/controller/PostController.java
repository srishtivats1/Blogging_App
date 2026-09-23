package com.blog.BloggingProject.controller;

import org.springframework.ui.Model;
import com.blog.BloggingProject.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
