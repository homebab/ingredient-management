package com.homebab.server.repository;

import com.homebab.server.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

//    @Query(value = "SELECT r.*"
//        + " FROM recipes r"
//        + " JOIN ("
//        + " SELECT recipe_id, COUNT(1) AS items"
//        + " FROM recipe_items"
//        + " WHERE item_id IN :itemIds"
//        + " GROUP BY recipe_id"
//        + " HAVING items = :itemCount"
//        + " ) t"
//        + " ON r.id = t.recipe_id"
//        , nativeQuery = true)
//    public Collection<Recipe> findByItems(@Param("itemIds") Collection<Integer> itemIds, @Param("itemCount") Integer itemCount);

}
