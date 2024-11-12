package org.example.lab9gtics.controller;

import org.example.lab9gtics.Dao.CategoryDao;
import org.example.lab9gtics.Entity.FavoriteMeal;
import org.example.lab9gtics.Entity.Meal;
import org.example.lab9gtics.Repository.FavoriteMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/TeleDrink")
public class TeleController {

    private final CategoryDao categoryDao;

    @Autowired
    public TeleController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/categories")
    public String listarCategorias(Model model) {

        model.addAttribute("categories", categoryDao.listar());
        model.addAttribute("isSearch", false);
        return "categories/list";
    }


    @Autowired
    private FavoriteMealRepository favoriteMealRepository;
    @GetMapping("/favorites")
    public String mostrarFavoritos(Model model) {
        List<FavoriteMeal> favoriteMeals = favoriteMealRepository.findAll();
        model.addAttribute("favoriteMeals", favoriteMeals);
        return "meal/favorites";
    }

}