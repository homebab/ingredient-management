package com.homebab.server.service;

import com.homebab.server.domain.Item;
import com.homebab.server.domain.Recipe;
import com.homebab.server.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeItemService {

    private final ItemService itemService;

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeItemService(ItemService itemService, RecipeRepository recipeRepository) {
        this.itemService = itemService;
        this.recipeRepository = recipeRepository;
    }

    public List<Item> findAllItemsById(List<Long> ids) { return itemService.findAllByIds(ids); }

    public Optional<Recipe> findRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }
}