package com.nastichichika.second_try.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;
/*
{
   "login": "admin",
   "password":"123456",
   "name":"admin",
   "role":"1"
}
*/
public class SignupRequest {

    @Size(max = 50)
    private String login;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private String name;

    private String role;

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
