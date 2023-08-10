package yte.intern.springsecurity.user;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        userRepository.save(new Users(null, "musa", passwordEncoder.encode("musa"),
                true,true,true,true,Set.of(new Authority("ROLE_USER"))));
        userRepository.save(new Users(null, "catak", passwordEncoder.encode("catak"),
                true,true,true,true,Set.of(new Authority("ROLE_USER"), new Authority("ROLE_ADMIN"))));
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
