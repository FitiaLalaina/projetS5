package com.culture.API.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.culture.API.Models.Culture;
@Repository
public interface CultureRepository extends JpaRepository<Culture , Long>
{
    Culture save(Culture culture);
    List<Culture> findAll();
}
