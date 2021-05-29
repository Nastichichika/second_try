package com.nastichichika.second_try.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, TEACHER;

    @Override
    public String getAuthority() {
        return name();
    }
}
