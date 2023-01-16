package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.Client;
import com.example.youbooking.entities.Image;
import com.example.youbooking.entities.Status;
import com.example.youbooking.entities.User;
import com.example.youbooking.repositories.ClientRepository;
import com.example.youbooking.services.IAdresseService;
import com.example.youbooking.services.IClientService;
import com.example.youbooking.services.IUserService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    IUserService userService;
    @Autowired
    IAdresseService adresseService;
    @Autowired
    ClientRepository clientRepository;
    @Override
    public ResponseDTO addClient(Client client, MultipartFile file) {
        if(client == null || client == new Client()){
            return new ResponseDTO("bad request","information is required");

        }else if (userService.findUserByTelephone(client.getTelephone()).getData() != null ){
            return new ResponseDTO("bad request","this user with this phone is present");

        }else if(userService.findUserByEmail(client.getEmail()) != null){
            return new ResponseDTO("bad request","user with this email is present");

        }else {
            adresseService.addAdressse(client.getAdresse());
            client.setPassword(new BCryptPasswordEncoder().encode(client.getPassword()));
            client.setStatus(Status.Active);

            try {
                Image image = uploadImage(file);
                client.setImage(image);
            }catch (Exception e){

            }

            clientRepository.save(client);
            return new ResponseDTO("success","user is added",client);
        }

    }

    public Image uploadImage(MultipartFile multipartFiles) throws IOException {
        Image image = new Image(multipartFiles.getOriginalFilename(),
                multipartFiles.getContentType(),
                multipartFiles.getBytes());
        return image;

    }

}
