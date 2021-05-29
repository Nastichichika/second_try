package com.nastichichika.second_try.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
 
    @NotBlank
    @Size(max = 50)
    private String login;

    private String role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public String getName() {
        return name;
    }
 
    public void setName(String username) {
        this.name = username;
    }
 
    public String getLogin() {
        return login;
    }
 
    public void setLogin(String email) {
        this.login = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
      return this.role;
    }
    
    public void setRole(String role) {
      this.role = role;
    }
}
