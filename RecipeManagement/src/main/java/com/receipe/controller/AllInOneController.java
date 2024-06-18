package com.receipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.receipe.dtos.ReceipeDto;
import com.receipe.service.RecipeService;

@RestController
@RequestMapping("/recipes")
public class AllInOneController {
	@Autowired
	private RecipeService service;

	@GetMapping("/{recipeID}")
	public ResponseEntity<?> getById(@PathVariable Long recipeID) {
		return ResponseEntity.ok(service.getById(recipeID));
	}

	@PostMapping
	public ResponseEntity<?> addRecipe(@RequestBody ReceipeDto recipeDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addNewRecipe(recipeDto));
	}

	@PutMapping("/{recipeID}")
	public ResponseEntity<?> updateRecipe(@PathVariable Long recipeID, @RequestBody ReceipeDto recipeDto) {
		return ResponseEntity.status(HttpStatus.OK).body(service.updateRecipe(recipeID, recipeDto));
	}

	@DeleteMapping("/{recipeID}")
	public ResponseEntity<?> deleteById(@PathVariable Long recipeID) {
		return ResponseEntity.ok(service.deleteRecipeById(recipeID));
	}
}
