package com.epam.quizApplication.service;

import com.epam.quizApplication.exception.ResourceAlreadyExistException;
import com.epam.quizApplication.exception.ResourceNotFoundException;
import com.epam.quizApplication.model.User;
import com.epam.quizApplication.repositorie.UserDAO;
import com.epam.quizApplication.service.serviceInterface.UserServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices {
    private static Logger log= LogManager.getLogger(UserServicesImpl.class);
    UserDAO userDao;

    public UserServicesImpl(UserDAO userDAOImpl){
        this.userDao=userDAOImpl;
    }

    public void creatUser(User user) throws ResourceAlreadyExistException {
        if (isUserNamePresent(user)) {
            throw new ResourceAlreadyExistException("Enter Different username");
        } else {
            userDao.save(user);
            log.info("User created Successfully");
        }
    }
    public void deleteUser(User user) throws ResourceNotFoundException {
        if (isUserNamePresent(user)) {
            userDao.delete(user);
            log.info("User deleted Successfully");
        } else {
            throw new ResourceNotFoundException("No User Present to remove");
        }
    }

    public boolean validate(String username, String password) {
        return userDao.findAll().stream()
                .anyMatch(user -> username.equals(user.getUserName()) && password.equals(user.getPassword()));
    }


    boolean isUserNamePresent(User user) {
        return userDao.existsById(user.getUserName());
    }
}
