package yte.intern.springsecurity.user;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final CustomAuthenticationProvider customAuthenticationProvider;

    public LoginService(CustomAuthenticationProvider customAuthenticationProvider) {
        this.customAuthenticationProvider = customAuthenticationProvider;
    }

    public String authenticateUser(String username, String password) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authentication = customAuthenticationProvider.authenticate(authenticationToken);

            if (authentication.isAuthenticated()) {
                return "Login successful!";
            } else {
                return "Login failed!";
            }
        } catch (Exception e) {
            return "Login failed!";
        }
    }
}
