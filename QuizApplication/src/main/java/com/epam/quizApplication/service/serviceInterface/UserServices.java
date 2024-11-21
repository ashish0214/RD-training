package com.epam.quizApplication.service.serviceInterface;

import com.epam.quizApplication.model.User;

public interface UserServices {
    void creatUser(User user);
    void deleteUser(User user);
    boolean validate(String username, String password);
}


