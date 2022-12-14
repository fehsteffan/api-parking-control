package com.program.parking.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.program.parking.dto.ParkingDto;
import com.program.parking.models.ParkingSpotModel;
import com.program.parking.services.ParkingService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")  
public class ParkingController {
	
	
	final ParkingService parkingService;
	
	public ParkingController (ParkingService parkingService) {
		this.parkingService = parkingService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingDto parkingDto) {
		if(parkingService.existsByLicensePlateCar(parkingDto.getLicencePlateCar())){
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use");
		}
		
		if(parkingService.existsByParkingSpotNumber(parkingDto.getParkingSpotNumber())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use!");
		}
		
		if(parkingService.existsByApartmentAndBlock(parkingDto.getApartment(), parkingDto.getBlock())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registered");
		}
		
		
		var parkingSpotModel = new ParkingSpotModel(); 
		BeanUtils.copyProperties(parkingDto, parkingSpotModel);
		parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(parkingService.save(parkingSpotModel));
				
	}	
	
	@GetMapping
	public ResponseEntity<Page<ParkingSpotModel>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		Page<ParkingSpotModel> page = parkingService.findAll(pageable);
		return ResponseEntity.ok().body(page);
   }	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Object>  findById(@PathVariable Long id) {
		Optional<ParkingSpotModel> parkingSpotModelOptional = parkingService.findById(id);
		if(!parkingSpotModelOptional.isPresent()) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
	}
	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Object> findByDelete(@PathVariable Long id) {
		Optional<ParkingSpotModel> parkingSpotModelOptional = parkingService.findById(id);
		if(!parkingSpotModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
		}	
		
		parkingService.delete(parkingSpotModelOptional.get());	
		return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfully ");
	}	
	
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Object> updateDate (@PathVariable Long id, @RequestBody @Valid ParkingDto parkingDto) {
		Optional<ParkingSpotModel> parkingSpotModelOptional = parkingService.findById(id);
		if(!parkingSpotModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot Model found");
		}
		
		var parkingSpotModel = new ParkingSpotModel();
		BeanUtils.copyProperties(parkingDto, parkingSpotModel);
		parkingSpotModel.setId(parkingSpotModelOptional.get().getId());
		parkingSpotModel.setRegistrationDate(parkingSpotModelOptional.get().getRegistrationDate());	
		return ResponseEntity.status(HttpStatus.OK).body(parkingService.save(parkingSpotModel));
	}
}
