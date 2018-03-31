package com.entities;

import javax.persistence.*;

@Entity
@Table (name= "users")
public class Users {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Basic
    @Column(name = "user_name", nullable = false, length = 30)
    private String userName;

    @Basic
    @Column(name = "user_email", nullable = false, length = 30)
    private String userEmail;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userId != users.userId) return false;
        if (userName != null ? !userName.equals(users.userName) : users.userName != null) return false;
        if (userEmail != null ? !userEmail.equals(users.userEmail) : users.userEmail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        return result;
    }
}
