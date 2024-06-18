package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseEntityDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
}
