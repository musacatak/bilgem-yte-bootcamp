package yte.intern.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import yte.intern.springsecurity.user.CustomAuthenticationProvider;
import yte.intern.springsecurity.user.LoginService;


@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

    private final CustomAuthenticationProvider customAuthenticationProvider;

    public SecurityConfiguration(CustomAuthenticationProvider customAuthenticationProvider) {
        this.customAuthenticationProvider = customAuthenticationProvider;
    }

    @Bean
    public HttpSecurity securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/admin")).hasRole("ADMIN")
                .requestMatchers(AntPathRequestMatcher.antMatcher("/user")).hasAnyRole("USER", "ADMIN")
                .requestMatchers(AntPathRequestMatcher.antMatcher("/login")).permitAll()
                .anyRequest().authenticated()
                //diğer matcherlarım
                .and()
                .httpBasic()
                .and()
                .formLogin().disable();


    }

    @Bean
    public CustomAuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider(loginService());
    }

    @Bean
    public LoginService loginService() {
        return new LoginService(userDetailsService(), authenticationProvider());
    }


//    // ıt can run without autowired because of the constroctor has only bean elements
//    @Autowired
//    public SecurityConfiguration(AuthenticationManagerBuilder authenticationManagerBuilder,
//                                 UserDetailsServiceImpl userDetailsService) throws Exception {
//
//
//
////        UserDetails user = User.builder()
////                .username("user")
////                .password("user")
////                .authorities("ROLE_USER")
////                .build();
////
////        UserDetails admin = User.builder()
////                .username("admin")
////                .password("admin")
////                .authorities("ROLE_ADMIN")
////                .build();
//
//        authenticationManagerBuilder
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.authorizeHttpRequests()
//                .requestMatchers(AntPathRequestMatcher.antMatcher("/admin")).hasRole("ADMIN")
//                .requestMatchers(AntPathRequestMatcher.antMatcher("/user")).hasAnyRole("USER", "ADMIN")
//                .requestMatchers(AntPathRequestMatcher.antMatcher("/login")).permitAll()
//                .anyRequest().authenticated()
//                //diğer matcherlarım
//                .and()
//                .httpBasic()
//                .and()
//                .formLogin().disable()
//
//
//    }


}


