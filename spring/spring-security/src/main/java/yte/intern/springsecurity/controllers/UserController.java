package yte.intern.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user")
    public String userMessage() {
        return "Merhaba, burası user dünyası.";
    }

    @GetMapping("/admin")
    public String adminMessage() {
        return "Merhaba, burası admin odası.";
    }

}
