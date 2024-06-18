package com.receipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.receipe.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {

}
