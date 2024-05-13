package com.CookApp.CookApp.service;

import com.CookApp.CookApp.bdd.User;

import java.util.List;

public interface UserService {

    User creer(User user);

    List<User> lire();

    User modifier(Long id, User user);

    String supprimer(Long id);
}