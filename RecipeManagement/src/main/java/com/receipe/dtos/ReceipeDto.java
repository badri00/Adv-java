package com.receipe.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReceipeDto {
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	private String title;
	private String description;
	private String ingredients;
	private String instructions;
	private String difficultyLevel;
	private String cuisine;
	@JsonProperty(access =Access.READ_ONLY)
	private LocalDate creationDate;
	@JsonProperty(access =Access.READ_ONLY)
	private LocalDate updationDate;
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long authorId;
}
