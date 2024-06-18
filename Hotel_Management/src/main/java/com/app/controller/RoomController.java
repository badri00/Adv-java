package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Room;
import com.app.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private RoomService roomService;

	@GetMapping
	public ResponseEntity<?> getAllRooms() {
		System.out.println("in gel all rooms controller!!");
		return ResponseEntity.status(HttpStatus.OK).body(roomService.getAllRooms());

	}
   @GetMapping("/{available}")
   public ResponseEntity<?>getAllAvailbleRooms(@PathVariable Boolean available){
	 System.out.println("in get all available rooms!!");
//	 Room r=new Room();
//	 r.setAvailability(available);
	 return ResponseEntity.status(HttpStatus.OK).body(roomService.getAllAvailableRooms(available));
	   
	   
   }
	
}
