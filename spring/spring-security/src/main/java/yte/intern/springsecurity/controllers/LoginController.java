package yte.intern.springsecurity.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yte.intern.springsecurity.user.LoginService;
import yte.intern.springsecurity.user.Users;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String login(@RequestBody Users request) {
        return loginService.authenticateUser(request.getUsername(), request.getPassword());
    }
}