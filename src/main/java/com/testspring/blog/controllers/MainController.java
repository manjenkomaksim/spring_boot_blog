package com.testspring.blog.controllers;

import com.testspring.blog.models.Post;
import com.testspring.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Main Page");
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "home";
    }

    @GetMapping("/contacts")
    public String contacts(Model model) {
        model.addAttribute("title", "About Us");
        return "contacts";
    }

}