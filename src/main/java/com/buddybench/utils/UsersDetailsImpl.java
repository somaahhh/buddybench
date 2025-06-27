package com.buddybench.utils;

import com.buddybench.entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsersDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String uuid;
    private String userName;
    private String email;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean loginStatus;

    private UsersDetailsImpl(Long id, String uuid, String userName, String email, String password,
                             Collection<? extends GrantedAuthority> authorities, boolean loginStatus) {
        super();
        this.id = id;
        this.uuid = uuid;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.loginStatus = loginStatus;
    }


    public static UsersDetailsImpl buildUserWithAuth(Optional<Users> user) {

        List<GrantedAuthority> authorities = user.get().getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
        return new UsersDetailsImpl( user.get().getId(),  user.get().getUuid(),  user.get().getUserName(),  user.get().getEmailId(),
                user.get().getPassword(), authorities, user.get().isLoginStatus());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public String getEmailId() {
        return getEmailId();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UsersDetailsImpl user = (UsersDetailsImpl) o;
        return Objects.equals(id, user.id);
    }


}
