package com.automobile.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "user_id")
	private Long userId;
	
	@Column(length = 20)
	private String username;
	
	@Column(length = 20)
	private String email;
	
	@Column(length = 20)
	private String password;

	@Column(length = 20)
	private String city;
	
	@Column(length = 10)
	private String contactNumber;
}
