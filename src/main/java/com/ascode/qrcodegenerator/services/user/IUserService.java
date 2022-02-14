package com.ascode.qrcodegenerator.services.user;

import com.ascode.qrcodegenerator.domains.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();
    User getUserById(final Long id);
    User createUser(final User user);
}
