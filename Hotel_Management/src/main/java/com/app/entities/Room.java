package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Room extends BaseEntity {
	@Column(name = "room_Id", length = 30)
	private Long roomId;
	@Column(name = "room_number", length = 30)
	private String roomNumber;
	@Column(name = "room_type", length = 50)
	@Enumerated(EnumType.STRING)
	private Type type;
	@Column(name = "room_price", length = 30)
	private double price;
	@Column(name = "availabity_status", length = 30)
	private boolean availability;
	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Reservation> reservations = new ArrayList<>();

}
