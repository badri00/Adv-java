package com.receipe;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RecipeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeManagementApplication.class, args);
	}

	@Bean // equivalent to <bean id ..../> in xml file
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		/*
		 * Meaning - Configuring ModelMapper , to transfer
		 * MATCHING n NOT NULL props from src --> dest
		 */
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.STRICT)
				.setPropertyCondition(Conditions.isNotNull());
		return modelMapper;
	}
}
