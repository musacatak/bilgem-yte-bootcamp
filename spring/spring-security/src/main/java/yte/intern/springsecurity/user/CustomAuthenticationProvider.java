package yte.intern.springsecurity.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final CustomUserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        // 1. Kullanıcıyı çek
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (passwordEncoder.matches(password,userDetails.getPassword())) {
            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        } else {
            throw new BadCredentialsException("Given username and password is wrong");
        }
        // 2. Kullanıcının şifresi ile authentication objesinden gelen şifreyi karşılaştır
        // 3. Eğer şifre uymuyorsa BadCredentialException fırlat
        // 4. eğer şifre uyuyorsa return new UsernamePasswordAuthenticationToken(username,null,authorities)
        // Tokeni döneerek authenticationu tamamla. Authorities, veri tabanından çekilen kullanıcının üzerinden gelmeli
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}