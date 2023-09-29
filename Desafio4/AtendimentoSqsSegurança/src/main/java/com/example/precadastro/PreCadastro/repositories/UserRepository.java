package com.example.precadastro.PreCadastro.repositories;

import com.example.precadastro.PreCadastro.models.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public User findUserByEmail(String email) {
        User user = new User(email, "123456"); // senha fixa 123456
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        return user;
    }
}
