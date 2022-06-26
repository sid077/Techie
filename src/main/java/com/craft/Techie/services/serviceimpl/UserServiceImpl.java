package com.craft.Techie.services.serviceimpl;

import com.craft.Techie.dao.UserDAO;

/*
 * Declare CRUD operations for User
 */
public interface UserServiceImpl {
    public boolean addUser(UserDAO userDAO);
    public boolean deleteUser(int userId);
    public boolean modifyUser(UserDAO userDAO);
    public UserDAO getUser(int id);
}
