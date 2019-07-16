package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postCRUD;
    private final UserRepository userCRUD;
    private User userDB;


    public PostController(UserRepository user, PostRepository post) {
        this(post, user);
    }

    public PostController(PostRepository post, UserRepository user){
        this.postCRUD = post;
        this.userCRUD = user;
    }

    public PostController(PostRepository postCRUD, UserRepository userCRUD, User userDB) {
        this.postCRUD = postCRUD;
        this.userCRUD = userCRUD;
        this.userDB = userDB;
    }

    @GetMapping("/posts")
    public String getPosts(Model viewModel) {
        viewModel.addAttribute("posts", postCRUD.findAll());
        return "po/index";
    }

    @GetMapping("/posts/create")
    public String getCreateForm(Model model){
        model.addAttribute("post", new Post());
        return "po/create";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String getPostByIDDescription(@PathVariable int id) {
        return "view an individual post";
    }

    @GetMapping("/posts/create")
    public String createPost(@ModelAttribute Post postToSave){
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDB = (User) userCRUD.findOne(sessionUser.getId());
        postToSave.setUser(userDB);
        Post savedPost = postCRUD.save(postToSave);
        return "redirect:/posts";
    }

    @GetMapping("/po/delete/{id}")
    protected String deletePost(@PathVariable long id){
    postCRUD.delete(id);
    return "redirect:/po/profile";
    }

    @GetMapping("/po/edit/{id}")
    protected String editPost(@PathVariable long id, Model model){
    Post post = postCRUD.findOne(id);
    model.addAttribute("post", post);
    return "po/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost(@ModelAttribute Post postToEdit){
    User sessionUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    postToEdit.setUser(userDB);
    postCRUD.save(postToEdit);
    return "redirect:/posts/profile";
    }

    @GetMapping("/posts/profile")
    public String showIndivdualPost(Model viewModel){
    User sessionUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User userDB = (User) userCRUD.findOne(sessionUser.getId());
    long user = sessionUser.getId();
    viewModel.addAttribute("posts", postCRUD.findAllByUserId(user));
    return "po/profile";
    }

}
