package com.kams.portfolio.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // List all posts (blogs + photos) or filter by type
    @GetMapping
    public String showPosts(@RequestParam(required = false) String type, Model model) {
        List<Post> posts;
        if (type != null) {
            posts = postRepository.findByTypeAndPublished(type, true);
        } else {
            posts = postRepository.findByPublishedTrue();
        }
        model.addAttribute("posts", posts);
        return "posts";
    }

    // Shortcut for blogs
    @GetMapping("/blogs")
    public String showBlogs(Model model) {
        model.addAttribute("posts", postRepository.findByTypeAndPublished("blog", true));
        return "posts";
    }

    // Shortcut for photos
    @GetMapping("/photos")
    public String showPhotos(Model model) {
        model.addAttribute("posts", postRepository.findByTypeAndPublished("photo", true));
        return "posts";
    }

    // Add post form
    @GetMapping("/add")
    public String showAddPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "add-post";
    }

    // Save new post
    @PostMapping
    public String savePost(@ModelAttribute Post post) {
        post.setPublished(true);
        postRepository.save(post);
        return "redirect:/posts?type=" + post.getType();
    }
}
