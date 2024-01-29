package com.culture.API.Models;

import java.util.List;

import com.culture.API.Repository.CategoryRepository;
import com.culture.API.Repository.CultureRepository;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategory;
    
    @Basic
    private String name;

    @OneToMany(mappedBy = "category", fetch=FetchType.EAGER)
    @Transient
    private List<Culture> cultures;

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Culture> getCultures() {
        return cultures;
    }

    public void setCultures(List<Culture> cultures) {
        this.cultures = cultures;
    }

    public Category(int idCategory, String name, List<Culture> cultures) {
        this.idCategory = idCategory;
        this.name = name;
        this.cultures = cultures;
    }

    public Category()
    {

    }

    public Category insert(CategoryRepository cr)
    {
        Category c = cr.save(this);
        return c;
    }

    public static List<Category> findAll(CategoryRepository cr) throws Exception
    {
        List<Category> c = cr.findAll();
        return c;
    }
}
