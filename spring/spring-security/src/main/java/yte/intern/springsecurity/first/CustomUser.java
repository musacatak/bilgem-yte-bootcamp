//package yte.intern.springsecurity;
//
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//
//@AllArgsConstructor
//public class CustomUser implements UserDetails {
//
//    private String username;
//    private String password;
//    private List<SimpleGrantedAuthority> authorities;
//
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public boolean isAccountNonExpired(){
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked(){
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired(){
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled(){
//        return true;
//    }
//}
