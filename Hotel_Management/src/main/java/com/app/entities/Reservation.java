package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservation extends BaseEntity{
    @Column(name="reservation_id",length=50)
	private Long reservationId;
    @Column(name="guest_name",length=50)
	private String guestName;
    @Column(name="check_in_date",length=50)
	private LocalDate checkInDate;
    @Column(name="check_out_date",length=50)
	private LocalDate checkOutDate;
    @Column(name="total_price",length=50)
	private double totalPrice;
    @ManyToOne
    @JoinColumn(name="room_id",nullable=false)
    private Room room;
	
}
