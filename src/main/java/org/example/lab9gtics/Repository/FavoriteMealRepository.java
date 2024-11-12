package org.example.lab9gtics.Repository;

import org.example.lab9gtics.Entity.FavoriteMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteMealRepository extends JpaRepository<FavoriteMeal, Integer> {
    boolean existsByIdMeal(String idMeal);

}