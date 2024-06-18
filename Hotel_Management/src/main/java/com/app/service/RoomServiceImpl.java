package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.RoomDto;
import com.app.entities.Room;
import com.app.repository.RoomRepo;
@Service
@Transactional
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepo roomRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<RoomDto> getAllRooms() {
		List<Room> rooms = roomRepo.findAll();
		List<RoomDto> roomDtos = new ArrayList<>();
		for (Room room : rooms) {
			RoomDto roomDto = modelMapper.map(room, RoomDto.class);
			roomDtos.add(roomDto);
		}

		return roomDtos;
	}

	@Override
	public List<RoomDto> getAllAvailableRooms(Boolean available) {
	List<Room>rooms=roomRepo.getAllAvailableRooms(available);
	List<RoomDto>roomDtos=new ArrayList<>();
	for(Room room:rooms)
	{
		RoomDto roomDto=modelMapper.map(room, RoomDto.class);
		roomDtos.add(roomDto);
	}
	return roomDtos;
	}
}


