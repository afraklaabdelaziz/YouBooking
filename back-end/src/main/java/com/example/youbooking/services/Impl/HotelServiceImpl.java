package com.example.youbooking.services.Impl;

import com.example.youbooking.entities.*;
import com.example.youbooking.repositories.HotelRepository;
import com.example.youbooking.services.*;
import com.example.youbooking.services.dto.ResponseDTO;
import com.example.youbooking.utiles.SpecificationCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class HotelServiceImpl implements IHotelService {

    @Autowired
    public HotelRepository hotelRepository;
    @Autowired
    IAdresseService adresseService;
    @Autowired
    IUserService userService;
    @Autowired
    IAdminService adminService;
    @Autowired
    IProprietaireService proprietaireService;

    @Value("${project.image}")
    private String path;

    @Override
     public ResponseDTO addHotel(Hotel hotel, String email,MultipartFile file) {
        User user = (User) userService.getUserByEmail(email).getData();
        if (hotel == null || hotel == new Hotel()){
            return new ResponseDTO("bad request","hotel is requred");
        }else {
            if (user.getRole().getNom().equals("admin")){
                Admin admin = (Admin) userService.getUserByEmail(email).getData();
                hotel.setAdmin(admin);
            }else if (user.getRole().getNom().equals("proprietaire")){
                Proprietaire proprietaire = (Proprietaire) proprietaireService.getUserByEmail(email).getData();
                hotel.setProprietaire(proprietaire);
                System.out.println(proprietaire.getNom());
            }

            try {
                Image images = uploadImage(file);
                hotel.setImage(images);
            }catch (Exception e){

            }

            hotel.setStatus(Status.Desactive);
            adresseService.addAdressse(hotel.getAdresse());
            hotelRepository.save(hotel);
            return new ResponseDTO("success","your hotel is added",hotel);
        }

    }

    @Override
    public ResponseDTO updateHotel(Hotel hotel) {
        if(hotel == null || hotel == new Hotel()){
            return new ResponseDTO("bad request","hotel is required");
        }else {
            Hotel hotelFind = hotelRepository.findById(hotel.getId()).get();
            hotelFind.setNom(hotel.getNom());
            hotelFind.setTelephone(hotel.getTelephone());
            hotelRepository.save(hotelFind);
            return new ResponseDTO("success","your hotel is updated",hotelFind);
        }
    }

    @Override
    public ResponseDTO updateStatusHotel(Long idHotel) {
        Optional<Hotel> hotel = hotelRepository.findById(idHotel);
        if (!hotel.isPresent()){
            return new ResponseDTO("bad request","this hotel dont present");
        }else {
            if (hotel.get().getStatus().equals(Status.Active)){
                hotel.get().setStatus(Status.Desactive);
            }else {
                hotel.get().setStatus(Status.Active);
            }
            hotelRepository.save(hotel.get());
            return new ResponseDTO("success","hotel actived");
        }
    }

    @Override
    public ResponseDTO findOneHotel(Long idHotel) {
        Hotel hotel = hotelRepository.findById(idHotel).get();
        if(hotel == null){
            return new ResponseDTO("bad request","this hotel dont present");
        }
        return new ResponseDTO("success","your hotel ",hotel);
    }

    @Override
    public List<Hotel> findAllHotels() {
        return hotelRepository.findAll();
    }

    @Transactional
    @Override
    public ResponseDTO deleteHotel(Long idHotel) {
        Optional<Hotel> hotel = hotelRepository.findById(idHotel);
        if(!hotel.isPresent()){
            return new ResponseDTO("bad request","this hotel dont present");
        }else{
            hotelRepository.delete(hotel.get());
            return new ResponseDTO("success","hotel is delete",hotel);
        }
    }



    @Override
    public List<Hotel> findHotelsByStatus(Status status) {
        return hotelRepository.findHotelByStatus(status);
    }

    @Override
    public ResponseDTO findHotelByProprietaire(String email) {
        Proprietaire proprietaire = (Proprietaire) proprietaireService.getUserByEmail(email).getData();
     return new ResponseDTO("success","hotels Of Owner ",hotelRepository.findHotelByProprietaire(proprietaire));
    }

    @Override
    public List<Hotel> findByCriteria(String nom, String tele,String ville){
        Adresse adresse = new Adresse();
        adresse.setVille(ville);
        System.out.println(adresse.getVille());
        return hotelRepository.findAll(SpecificationCriteria.searchHotel(nom, tele,adresse));
    }



    public Image uploadImage(MultipartFile multipartFiles) throws IOException {
            Image image = new Image(multipartFiles.getOriginalFilename(),
                    multipartFiles.getContentType(),
                    multipartFiles.getBytes());
            return image;

    }

}
