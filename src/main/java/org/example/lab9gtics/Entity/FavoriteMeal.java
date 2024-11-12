package org.example.lab9gtics.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "favoritemeals")
public class FavoriteMeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idfavoriteMeals;

    private String idMeal;
    private String strMeal;
    private String strCategory;
    private String strMealThumb;
}
