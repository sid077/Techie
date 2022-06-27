package com.craft.Techie.services;

import com.craft.Techie.dao.UserDAO;
import com.craft.Techie.entities.User;
import com.craft.Techie.repositories.UserRepository;
import com.craft.Techie.services.serviceimpl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService implements UserServiceImpl {
    @Autowired
    private UserRepository userRepository;

    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    public UserDAO addUser(UserDAO userDAO) {
        User user = userDAO.convertToEntity(userDAO);
        user = userRepository.save(user);
        userDAO = modelMapper.map(user,UserDAO.class);
        return userDAO;
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
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
        UserDAO userDAO = modelMapper.map(user,UserDAO.class);
        return userDAO;
    }
}
