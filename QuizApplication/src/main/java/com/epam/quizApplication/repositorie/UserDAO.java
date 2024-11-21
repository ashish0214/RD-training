package com.epam.quizApplication.repositorie;

import com.epam.quizApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,String> {
}
