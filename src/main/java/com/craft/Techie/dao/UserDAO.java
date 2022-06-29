package com.craft.Techie.dao;

import com.craft.Techie.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDAO {
    String firstName;
    String lastName;
    String designation;
    String highlight;
    String company;
    public static User convertToEntity(UserDAO userDAO) {
        User user = new User();
        user.setFirstName(userDAO.getFirstName());
        user.setLastName(userDAO.getLastName());
        user.setHighlight(userDAO.getHighlight());
        user.setDesignation(userDAO.getDesignation());
        user.setCompany(userDAO.getCompany());
        return user;
    }
}
