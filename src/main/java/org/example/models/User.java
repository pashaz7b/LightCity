package org.example.models;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;

    public User()
    {

    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void sign(String username,String password)
    {
        setPassword(password);
        setUsername(username);
    }
}
