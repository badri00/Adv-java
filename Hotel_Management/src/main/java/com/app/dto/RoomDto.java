package com.app.dto;

import com.app.entities.Type;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDto extends BaseEntityDto {
	
	@JsonProperty(access=Access.WRITE_ONLY)
	private Long roomId;
	private String roomNumber;
	private Type type;
	private double price;
	private boolean availability;

}
