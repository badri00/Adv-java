package com.automobile.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automobile.DTO.VehicleDTO;
import com.automobile.entities.User;
import com.automobile.entities.Vehicle;
import com.automobile.exception.VehicleException;
import com.automobile.repository.UserRepository;
import com.automobile.repository.VehicleRepository;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<VehicleDTO> getAllVehicles() {
		return vehicleRepository.findAll().stream().map(entity -> mapper.map(entity, VehicleDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public VehicleDTO getVehicle(Long id) {
		return mapper.map(vehicleRepository.findById(id).orElseThrow(() -> new VehicleException("Vehicle not Found")),
				VehicleDTO.class);
	}

	@Override
	public VehicleDTO addVehicle(VehicleDTO vehicleDTO) {
		System.out.println(vehicleDTO);
		User user = userRepository.findByUsername(vehicleDTO.getUser().getUsername());
		Vehicle vehicle = mapper.map(vehicleDTO, Vehicle.class);
		vehicle.setUser(user);
		return mapper.map(vehicleRepository.save(vehicle), VehicleDTO.class);
	}

	@Override
	public String deleteVehicle(Long id) {
		if(vehicleRepository.existsById(id)) {
			vehicleRepository.deleteById(id);
			return "Deleted Successfully";
		}
		throw new VehicleException("Vehicle Not Found");
	}

}
