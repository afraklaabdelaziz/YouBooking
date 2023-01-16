package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.Image;
import com.example.youbooking.entities.Proprietaire;
import com.example.youbooking.entities.Status;
import com.example.youbooking.repositories.ProprietaireRepository;
import com.example.youbooking.services.IAdresseService;
import com.example.youbooking.services.IProprietaireService;
import com.example.youbooking.services.IUserService;
import com.example.youbooking.services.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProprietaireServiceImpl implements IProprietaireService {
        @Autowired
        IUserService userService;
        @Autowired
        IAdresseService adresseService;
        @Autowired
        ProprietaireRepository proprietaireRepository;
        @Override
        public ResponseDTO addPropritaire(Proprietaire proprietaire, MultipartFile file) {
            if(proprietaire == null || proprietaire == new Proprietaire()){
                return new ResponseDTO("bad request","information is required");

            }else if (userService.findUserByTelephone(proprietaire.getTelephone()).getData() != null ){
                return new ResponseDTO("bad request","this user with this phone is present");

            }else if(userService.findUserByEmail(proprietaire.getEmail()) != null){
                return new ResponseDTO("bad request","user with this email is present");

            }else {
                adresseService.addAdressse(proprietaire.getAdresse());
                proprietaire.setPassword(new BCryptPasswordEncoder().encode(proprietaire.getPassword()));

                try {
                    Image image = uploadImage(file);
                    proprietaire.setImage(image);
                }catch (Exception e){

                }

                proprietaireRepository.save(proprietaire);
                return new ResponseDTO("success","user is added");
            }
        }

    @Override
    public ResponseDTO findPropritaireByStatusDesactive(Status status) {
        return new ResponseDTO("success","Onners",proprietaireRepository.findByStatus(status));
    }

    @Override
    public ResponseDTO getUserByEmail(String email){
        Proprietaire proprietaire = proprietaireRepository.findProprietaireByEmail(email);
        if(proprietaire == null){
            return new ResponseDTO("bad request","this user dont present");
        }else {
            return new ResponseDTO("success","user",proprietaire);
        }
    }

    public Image uploadImage(MultipartFile multipartFiles) throws IOException {
        Image image = new Image(multipartFiles.getOriginalFilename(),
                multipartFiles.getContentType(),
                multipartFiles.getBytes());
        return image;

    }
}
