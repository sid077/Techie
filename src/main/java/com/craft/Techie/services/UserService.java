package com.craft.Techie.services;

import com.craft.Techie.dao.UserDAO;
import com.craft.Techie.repositories.UserRepository;
import com.craft.Techie.services.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceImpl {
    @Autowired
    UserRepository userRepository;
    @Override
    public boolean addUser(UserDAO userDAO) {
        return false;
    }

    @Override
    public boolean deleteUser(int userId) {
        return false;
    }

    @Override
    public boolean modifyUser(UserDAO userDAO) {
        return false;
    }

    @Override
    public UserDAO getUser(int id) {
        return null;
    }
}
