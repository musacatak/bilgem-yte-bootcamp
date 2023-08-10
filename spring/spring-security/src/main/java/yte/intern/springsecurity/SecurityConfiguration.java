package yte.intern.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import yte.intern.springsecurity.user.CustomAuthenticationProvider;


@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

    @Autowired
    private final CustomAuthenticationProvider customAuthenticationProvider;

    public SecurityConfiguration(CustomAuthenticationProvider customAuthenticationProvider) {
        this.customAuthenticationProvider = customAuthenticationProvider;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

        authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider);
    }

    @Bean
    @Primary
    public HttpSecurity securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/admin")).hasRole("ADMIN")
                .requestMatchers(AntPathRequestMatcher.antMatcher("/user")).hasAnyRole("USER", "ADMIN")
                .requestMatchers(AntPathRequestMatcher.antMatcher("/login")).permitAll()
                .anyRequest().authenticated()
                //diğer matcherlarım
                .and()
                .formLogin()
                    .disable();


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


