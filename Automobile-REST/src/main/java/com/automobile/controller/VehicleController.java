package com.automobile.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automobile.DTO.VehicleDTO;
import com.automobile.service.VehicleService;



@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping
	public ResponseEntity<?> getAllvehicles() {
		return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllVehicles());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getVehicle(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehicle(id));
	}
	
	@PostMapping
	public ResponseEntity<?> addVehicle(@RequestBody VehicleDTO vehicleDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.addVehicle(vehicleDTO));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteVehicle(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(vehicleService.deleteVehicle(id));
	}
}
