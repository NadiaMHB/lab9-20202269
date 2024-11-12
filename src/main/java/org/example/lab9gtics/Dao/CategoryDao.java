package org.example.lab9gtics.Dao;

import org.example.lab9gtics.Entity.Category;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CategoryDao {

    private final String categories_url = "https://www.themealdb.com/api/json/v1/1/categories.php";

    public List<Category> listar() {
        RestTemplate restTemplate = new RestTemplate();
        List<Category> lista = new ArrayList<>();

        Map<String, Object> response = restTemplate.getForObject(categories_url, Map.class);

        if (response != null && response.containsKey("categories")) {
            List<Map<String, Object>> categoriesData = (List<Map<String, Object>>) response.get("categories");
            for (Map<String, Object> categoryData : categoriesData) {
                Category category = new Category();
                category.setIdCategory((String) categoryData.get("idCategory"));
                category.setStrCategory((String) categoryData.get("strCategory"));
                category.setStrCategoryThumb((String) categoryData.get("strCategoryThumb"));
                category.setStrCategoryDescription((String) categoryData.get("strCategoryDescription"));
                lista.add(category);
            }
        }

        return lista;
    }



}
