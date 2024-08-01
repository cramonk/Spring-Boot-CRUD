package ru.cramonk.spring.spring_boot_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.cramonk.spring.spring_boot_crud.entity.User;
import ru.cramonk.spring.spring_boot_crud.service.UserService;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.showAll());
        return "users";
    }

    @GetMapping(value = "/new")
    public String creationPage(@ModelAttribute("user") User user, Model model) {
        model.addAttribute(user);
        return "new_user";
    }

    @PostMapping(value = "/")
    public String addOrUpdateUser(@ModelAttribute("user") User user) {
        userService.addOrUpdateUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/update")
    public String updatePage(@RequestParam("id") Long id, @ModelAttribute("user") User user, Model model) {
        model.addAttribute(userService.getUser(id));
        return "update_user";
    }

    @PostMapping(value = "/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}