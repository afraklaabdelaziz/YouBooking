package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.Client;
import com.example.youbooking.entities.Status;
import com.example.youbooking.entities.User;
import com.example.youbooking.repositories.ClientRepository;
import com.example.youbooking.services.IAdresseService;
import com.example.youbooking.services.IClientService;
import com.example.youbooking.services.IUserService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    IUserService userService;
    @Autowired
    IAdresseService adresseService;
    @Autowired
    ClientRepository clientRepository;
    @Override
    public ResponseDTO addClient(Client client) {
        if(client == null || client == new Client()){
            return new ResponseDTO("bad request","information is required");

        }else if (userService.findUserByTelephone(client.getTelephone()).getData() != null ){
            return new ResponseDTO("bad request","this user with this phone is present");

        }else if(userService.findUserByEmail(client.getEmail()) != null){
            return new ResponseDTO("bad request","user with this email is present");

        }else {
            adresseService.addAdressse(client.getAdresse());
            client.setStatus(Status.Active);
            clientRepository.save(client);
            return new ResponseDTO("success","user is added",client);
        }

    }

}
