package yte.intern.springsecurity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Users implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_authorities",
    joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<Authority> authorities;



    @Override
    public boolean isAccountNonExpired(){
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked(){
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled(){
        return isEnabled;
    }


}
