package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Room;

public interface RoomRepo extends JpaRepository<Room, Long> {
	
@Query(value="select u from Room u where u.availability=:available")
List<Room>getAllAvailableRooms(Boolean available);	
}
