package com.todo.config.auth.jwt.resource;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

    private static final long serialVersionUID = -5616176897013108345L;

    private String username;
    private String password;

//    eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2aXRhbGlpIiwiZXhwIjoxNjEzNTc0MTU2LCJpYXQiOjE2MTI5NjkzNTZ9.eCdlcGm6YNWNKnLWLOsJkkZNZhuHhso0wCQvP0YlYp0uMDiLwpodRoN-Z_gQG_UtuEgpzR3BQwFO5uWi9E3e1w

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
