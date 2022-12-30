package com.example.youbooking.repositories;

import com.example.youbooking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByTelephone(String telephone);

    User findUserByEmail(String email);
}
