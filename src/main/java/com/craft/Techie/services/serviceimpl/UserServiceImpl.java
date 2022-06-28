package com.craft.Techie.services.serviceimpl;

import com.craft.Techie.dao.UserDAO;

/*
 * Declare CRUD operations for User
 */
public interface UserServiceImpl {
    public UserDAO addUser(UserDAO userDAO);
    public boolean deleteUser(int userId);
    public UserDAO modifyUser(UserDAO userDAO,int userId);
    public UserDAO getUser(int id);
}
