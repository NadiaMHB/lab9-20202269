package org.example.lab9gtics.controller;

import org.example.lab9gtics.Dao.CategoryDao;
import org.example.lab9gtics.Entity.Meal;
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

    @GetMapping("/search")
    public String buscarComida(@RequestParam("value") String value, Model model) {
        List<Meal> meals = categoryDao.buscarComidaPorNombre(value);
        model.addAttribute("meals", meals);
        model.addAttribute("isSearch", true);
        return "categories/list";
    }

    @GetMapping("/meal/detail")
    public String mostrarDetalleComida(@RequestParam("id") String idMeal, Model model) {
        Meal meal = categoryDao.obtenerDetalleComida(idMeal);

        // Verificar si el idMeal ya está en favoritos
        boolean isInFavorites = categoryDao.estaEnFavoritos(idMeal);

        model.addAttribute("meal", meal);
        model.addAttribute("inFavorites", isInFavorites);
        return "meal/details";
    }

    @PostMapping("/favorite/add")
    public ResponseEntity<?> agregarAFavoritos(@RequestParam("id") String idMeal) {
        // Verificar si el idMeal ya está en favoritos
        if (categoryDao.estaEnFavoritos(idMeal)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Already in favorites");
        }

        // Si no está en favoritos, lo añadimos con todos los detalles
        categoryDao.guardarEnFavoritos(idMeal);
        return ResponseEntity.ok("Added to favorites");
    }

}