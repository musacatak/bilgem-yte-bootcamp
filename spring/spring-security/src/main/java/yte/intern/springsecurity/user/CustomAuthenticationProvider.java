package yte.intern.springsecurity.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        // 1. Kullanıcıyı çek
        Users user = (Users) userDetailsService.loadUserByUsername(username);
        // 2. Kullanıcının şifresi ile authentication objesinden gelen şifreyi karşılaştır
        if (!password.equals(user.getPassword())) {
            // 3. If passwords do not match, throw a BadCredentialsException.
            throw new BadCredentialsException("Bad credentials");
        }
        // 3. Eğer şifre uymuyorsa BadCredentialException fırlat
        // 4. eğer şifre uyuyorsa return new UsernamePasswordAuthenticationToken(username,null,authorities)

        return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
        // Tokeni döneerek authenticationu tamamla. Authorities, veri tabanından çekilen kullanıcının üzerinden gelmeli
    }

    @Override
    public boolean supports(Class<?> authentication){

        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);

    }
}
