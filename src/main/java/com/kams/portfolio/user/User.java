package com.kams.portfolio.user;

import jakarta.persistence.*;

@Entity
@Table(name = "users")   // matches your table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;


    @Column(nullable = false, length = 255)
    private String password;

    @Column(length = 20)
    private String role = "ADMIN";  // default in postgre db

    protected User()
    {

    }  // JPA requires no-args constructor

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // --- getters & setters ---
    public Long getId()
    {
        return id;
    }
    public String getUsername()
    { return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
