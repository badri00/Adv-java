package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.RoomDto;

public interface RoomService {

	List<RoomDto>getAllRooms();
	List<RoomDto>getAllAvailableRooms(Boolean available);
}
