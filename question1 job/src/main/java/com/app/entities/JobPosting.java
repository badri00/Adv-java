package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobPosting extends BaseEntity {
	@Column(name="job_title" ,length=50)
	private String title;
	@Column(name="company_name",length=50)
	private String name;
	@Column(name="location",length=50)
	private String location;
	@Column(name="descrption",length=50)
	private String description;
	@Column(name="salary", length=50)
	private double salary;
	@Column(name="posting_date",length=50)
	private LocalDate date;

}
