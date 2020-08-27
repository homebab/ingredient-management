package com.homebab.server.repository;

import com.homebab.server.domain.RecipeItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeItemRepository extends JpaRepository<RecipeItem, Long> {

}
