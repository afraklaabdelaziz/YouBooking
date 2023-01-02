package com.example.youbooking.controllers;

import com.example.youbooking.services.IAdminService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    IAdminService adminService;
    @PutMapping("/{id}")
    public ResponseDTO acceptePropritaire(@PathVariable Long id){
        return adminService.acceptePropritaire(id);
    }
}
