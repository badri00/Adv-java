package com.receipe.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="recipe")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private String ingredients;
	private String instructions;
	@Enumerated(EnumType.STRING)
	private Difficulty difficultyLevel;
	@Enumerated(EnumType.STRING)
	private Cuisine cuisine;
	@Column(name="creation_date")
	@CreationTimestamp
	private LocalDate creationDate;
	@Column(name="updation_date")
	@UpdateTimestamp
	private LocalDate updationDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="author_id")
	private Author author;

}
