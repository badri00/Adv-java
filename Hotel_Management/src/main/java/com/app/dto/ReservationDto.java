package com.app.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ReservationDto extends BaseEntityDto {
     
	private String guestName;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	@JsonProperty(access=Access.WRITE_ONLY)
	private Long roomId;

}
