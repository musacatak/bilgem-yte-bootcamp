package yte.intern.springsecurity.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {


    private final AuthenticationManager authenticationManager;

    public String login(LoginRequest loginRequest){
        Authentication authenticated = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(),loginRequest.password()));

        if(authenticated.isAuthenticated()){
            SecurityContext newContext = SecurityContextHolder.createEmptyContext();
            newContext.setAuthentication(authenticated);
            SecurityContextHolder.setContext(newContext);

            return "Authentication is successful";
        }
        else {
            System.out.println("Login Failed");
            return "Authentication Failed!";
        }
    }
}
