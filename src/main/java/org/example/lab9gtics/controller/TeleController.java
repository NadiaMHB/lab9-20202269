package org.example.lab9gtics.controller;

import org.example.lab9gtics.Dao.CategoryDao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


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

}