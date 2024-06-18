package com.receipe.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.receipe.dtos.ApiResponse;
import com.receipe.dtos.ReceipeDto;
import com.receipe.entities.Author;
import com.receipe.entities.Recipe;
import com.receipe.exception.RecipeException;
import com.receipe.repository.AuthorRepository;
import com.receipe.repository.RecipeRepository;

@Service
@Transactional
public class RecipeService {
	@Autowired
	private RecipeRepository recipeRepository;

	@Autowired
	private AuthorRepository authorRepo;

	@Autowired
	private ModelMapper mapper;

	public ReceipeDto getById(Long id) {
		return mapper.map(recipeRepository.findById(id).orElseThrow(() -> new RecipeException("Recipe Not Found")),
				ReceipeDto.class);
	}

	public ApiResponse addNewRecipe(ReceipeDto recipeDto) {
		Author author = authorRepo.findById(recipeDto.getAuthorId())
				.orElseThrow(() -> new RecipeException("Author Id Not Found"));
		Recipe recipe = mapper.map(recipeDto, Recipe.class);
		recipe.setAuthor(author);
		recipeRepository.save(recipe);
		return new ApiResponse("Recipe Added Successfully");
	}

	public ApiResponse updateRecipe(Long id, ReceipeDto recipeDto) {
		Recipe recipe = recipeRepository.findById(id)
				.orElseThrow(() -> new RecipeException("No Recipe Found For Given Id"));
		mapper.map(recipeDto, recipe);
		return new ApiResponse("Recipe Updated Successfully");
	}

	public ApiResponse deleteRecipeById(Long id) throws RecipeException {
		if (recipeRepository.existsById(id)) {
			recipeRepository.deleteById(id);
			return new ApiResponse("Recipe Deleted Successfully");
		}
		throw new RecipeException("No Recipe found for Given Id");
	}
}
