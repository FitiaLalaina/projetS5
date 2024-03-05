package com.culture.API.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.culture.API.Models.Action;
@Repository
public interface ActionRepository extends JpaRepository<Action , Integer>
{
    Action save(Action culture);
    List<Action> findAll();
}