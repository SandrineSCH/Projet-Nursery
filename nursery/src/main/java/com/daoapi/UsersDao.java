package com.daoapi;

import com.entities.Users;

import java.util.List;

public interface UsersDao {
    public boolean saveOrUpdate (Users users);
    public List<Users> list();
    public boolean delete(Users users);
}
