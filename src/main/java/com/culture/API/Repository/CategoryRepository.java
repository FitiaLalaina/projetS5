package com.culture.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.culture.API.Models.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category , Long>
{
    Category save(Category category);
}