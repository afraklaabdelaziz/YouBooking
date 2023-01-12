package com.example.youbooking.utiles;

import com.example.youbooking.entities.Adresse;
import com.example.youbooking.entities.Hotel;
import com.example.youbooking.entities.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SpecificationCriteria {

    public static Specification<Hotel> searchHotel(String nom, String tele, Adresse adresse){
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (nom!=null && !(nom.isEmpty())){
                predicates.add(criteriaBuilder.like(root.get("nom"),nom));
            }

            if (tele!=null && !(tele.isEmpty())){
                predicates.add(criteriaBuilder.like(root.get("telephone"),tele));
            }

            if (adresse.getVille()!=null && !(adresse.getVille().isEmpty())){
                predicates.add(criteriaBuilder.like(root.get("adresse"), adresse.getVille()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    public static Specification<Hotel> searchReservation(LocalDate dateDebut, LocalDate dateFin){
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (dateDebut!=null){
                predicates.add(criteriaBuilder.equal(root.get("dateDebut"),dateDebut));
            }

            if (dateFin!=null){
                predicates.add(criteriaBuilder.equal(root.get("dateFin"),dateFin));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }


    public static Specification<Hotel> searchRoom(String nom, String tele, Adresse adresse){
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (nom!=null && !(nom.isEmpty())){
                predicates.add(criteriaBuilder.like(root.get("nom"),nom));
            }

            if (tele!=null && !(tele.isEmpty())){
                predicates.add(criteriaBuilder.like(root.get("telephone"),tele));
            }

            if (adresse.getVille()!=null && !(adresse.getVille().isEmpty())){
                predicates.add(criteriaBuilder.like(root.get("adresse"), adresse.getVille()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }


    public static Specification<User> searchUser(String nom, String tele, String email){
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (nom!=null && !(nom.isEmpty())){
                predicates.add(criteriaBuilder.like(root.get("nom"),nom));
            }

            if (tele!=null && !(tele.isEmpty())){
                predicates.add(criteriaBuilder.like(root.get("telephone"),tele));
            }

            if (email!=null && !(email.isEmpty())){
                predicates.add(criteriaBuilder.like(root.get("email"), email));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
