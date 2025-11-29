package com.kams.portfolio.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserPageController {

    @GetMapping("/users-page")
    public String showUsersPage() {
        return "users"; // loads users.html from templates/
    } 

    @GetMapping("/add-user")
    public String showAddUserForm() {
        return "add-user"; // loads add-user.html from templates/
    }
}
