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
        userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        userRepository.deleteById(userId);
        return true;
    }

    @Override
    public UserDAO modifyUser(UserDAO userDAO, int userId) {
        User originalUser = userRepository.getReferenceById(userId);
        originalUser.setFirstName(userDAO.getFirstName());
        originalUser.setLastName(userDAO.getLastName());
        originalUser.setDesignation(userDAO.getDesignation());
        originalUser.setCompany(userDAO.getCompany());
        originalUser.setHighlight(userDAO.getHighlight());
        originalUser =  userRepository.saveAndFlush(originalUser);
        userDAO = modelMapper.map(originalUser,UserDAO.class);
        return userDAO;
    }

    @Override
    public UserDAO getUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
        UserDAO userDAO = modelMapper.map(user,UserDAO.class);
        return userDAO;
    }
}
