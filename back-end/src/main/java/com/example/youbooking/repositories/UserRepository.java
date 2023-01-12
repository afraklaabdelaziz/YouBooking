package com.example.youbooking.repositories;

import com.example.youbooking.entities.Hotel;
import com.example.youbooking.entities.Status;
import com.example.youbooking.entities.User;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByTelephone(String telephone);

    User findUserByEmail(String email);

    public List<User> findUserByStatus(Status status);

   List<User> findAll(Specification<User> searchUser);
}
