package com.culture.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.culture.API.Models.*;
import java.util.List;


@Repository
public interface RessourceRepository extends JpaRepository<Ressource, Long> {
    Ressource save(Ressource ressource);
    List<Ressource> findAll();
}