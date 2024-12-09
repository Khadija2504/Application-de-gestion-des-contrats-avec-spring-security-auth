package com.example.gestioncontrat.form;

import jakarta.validation.constraints.NotEmpty;

public class LoginForm {

    @NotEmpty(message = "User email is required")
    private String email;

    @NotEmpty(message = "Password is required")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}