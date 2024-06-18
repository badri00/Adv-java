package com.automobile.service;

import java.util.List;

import com.automobile.DTO.VehicleDTO;

public interface VehicleService {

	public List<VehicleDTO> getAllVehicles();
	
	public VehicleDTO getVehicle(Long id);
	
	public VehicleDTO addVehicle(VehicleDTO vehicleDTO);
	
	public String deleteVehicle(Long id);
}
