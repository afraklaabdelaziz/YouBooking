package com.example.youbooking.controllers;

import com.example.youbooking.config.JwtUtils;
import com.example.youbooking.dto.LoginDto;
import com.example.youbooking.dto.UserDto;
import com.example.youbooking.entities.*;
import com.example.youbooking.repositories.RoleRepository;
import com.example.youbooking.services.IClientService;
import com.example.youbooking.services.IProprietaireService;
import com.example.youbooking.services.IUserService;
import com.example.youbooking.services.dto.ResponseDTO;
import com.example.youbooking.utiles.DtoToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:62250")
public class UserController {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    IUserService userService;
    @Autowired
   IClientService clientService;
    @Autowired
    IProprietaireService proprietaireService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/all")
    public ResponseDTO allUsers(){
        return new ResponseDTO("sucesss","users users",userService.findAllUsers());
    }


    @GetMapping("/usersBan")
    public List<User> findHotelsByStatusDesactive(){
        return userService.findUserByStatus(Status.Desactive);
    }


    @GetMapping("/oneUser/{email}")
    public ResponseDTO findUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @PutMapping("/bannUser/{id}")
    public ResponseDTO bannUser(@PathVariable Long id){
        return userService.bannerUser(id);
    }

    @PostMapping(value = {"/add"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseDTO register(@Valid @RequestPart("user") UserDto userDto, @RequestPart(value = "imageFile",required = false)MultipartFile file){
        User user = DtoToEntity.userDtoToUser(userDto);

        Optional<Role> role = roleRepository.findById(user.getRole().getId());

        if (role.get().getNom().equals("client")){
            Client client = DtoToEntity.clientDtoToUser(userDto);
             clientService.addClient(client,file);
             return new ResponseDTO("success","success",client);

        }else if(role.get().getNom().equals("proprietaire")){
            Proprietaire proprietaire = DtoToEntity.propritaireDtoToUser(userDto);
            proprietaire.setStatus(Status.Desactive);
            return proprietaireService.addPropritaire(proprietaire,file);
        }

        return userService.addUser(user);
    }

    @PostMapping("/login")
    public ResponseDTO auth(@RequestBody LoginDto login){
        User userFound = (User) userService.getUserByEmail(login.getEmail()).getData();
        UserDetails user = userService.findUserByEmail(login.getEmail());
        if (userFound != null){
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(),login.getPassword()));
            if (userFound.getStatus().equals(Status.Desactive)){
                return new ResponseDTO("bad request","this user is ban plaise contact admin");
            }
        }
        if (user != null){
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(),login.getPassword()));
            return new ResponseDTO("success","token",jwtUtils.generateToken(user));
        }
        return new ResponseDTO("bad request","user not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDTO deleteUser(@PathVariable Long id){
    return userService.delete(id);
    }

    @PutMapping("/update/{id}")
    public ResponseDTO updateUser(@RequestBody UserDto userDto, @PathVariable Long id){
        userDto.setId(id);
        System.out.println(userDto.getId());
       User user = DtoToEntity.userDtoToUser(userDto);
        return userService.updateUser(user);
    }

    @GetMapping("/search")
    public ResponseDTO searchUsers(@RequestParam(value = "nom",required = false) String nom
                                   ,@RequestParam(value = "telephone",required = false) String telephone,
                                   @RequestParam(value = "email",required = false) String email){
        return userService.searchUser(nom,telephone,email);
    }

    @PostMapping("/logout")
    public ResponseDTO logout() {
        return new ResponseDTO("success","you are logout");
    }


}
