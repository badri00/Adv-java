package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JobPostingDto extends BaseEntityDto{
	private String title;
	private String name;
	private String location;
	private String description;
	private double salary;
	private LocalDate date;
	

}
