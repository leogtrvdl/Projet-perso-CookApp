package com.CookApp.CookApp.repository;

import com.CookApp.CookApp.bdd.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
