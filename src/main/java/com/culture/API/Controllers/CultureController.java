package com.culture.API.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.culture.API.Models.Category;
import com.culture.API.Models.Culture;
import com.culture.API.Repository.CategoryRepository;
import com.culture.API.Repository.CultureRepository;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET})
@RestController
@RequestMapping("/api")
public class CultureController {
    @Autowired
	CultureRepository cultureRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping("/culture")
	public ResponseEntity<Culture> saveCulture(@RequestBody Culture culture) {
		try {
            Culture c = Culture.saveCulture(culture, cultureRepository);
            return new ResponseEntity<>(c, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
		
	}

    @GetMapping("/cultures")
    public ResponseEntity<List<Culture>> listCulture()
    {
        try {
            List<Culture> cultures = Culture.findAll(cultureRepository);
            return new ResponseEntity<>(cultures , HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/category")
    public ResponseEntity<Category> insertCategory(@RequestBody Category category)
    {
        try {
            Category c = category.insert(categoryRepository);
            return new ResponseEntity<>(c , HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategory()
    {
        try {
            List<Category> c = Category.findAll(categoryRepository);
            return new ResponseEntity<>(c , HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
