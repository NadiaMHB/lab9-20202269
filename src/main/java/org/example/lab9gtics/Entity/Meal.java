package org.example.lab9gtics.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Meal {

    private String idMeal;
    private String strMeal;
    private String strCategory;
    private String strInstructions;
    private String strMealThumb;
    private String strArea;
    private String strTags;
    private String strYoutube;
    private List<String> ingredients;

}