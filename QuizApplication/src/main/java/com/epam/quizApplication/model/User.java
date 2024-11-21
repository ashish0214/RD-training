package com.epam.quizApplication.model;

import com.epam.quizApplication.constant.Role;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "User_DataBase")
public class User {
    @Id
    @Column(name = "UserName")
    private String userName;

    @Column(name = "Password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "Role")
    Role role;

}
