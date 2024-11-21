package com.epam.quizApplication.Dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public class UserDTO {

    @Email
    private String userName;
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "Password must be at least 8 characters long, contain at least one digit, one uppercase letter, one lowercase letter, and one special character, and must not contain whitespace."
    )
    private String password;
}
