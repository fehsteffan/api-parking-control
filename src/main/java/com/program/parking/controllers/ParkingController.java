package com.program.parking.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.program.parking.dto.ParkingDto;
import com.program.parking.models.ParkingSpotModel;
import com.program.parking.services.ParkingService;

@RestController
@RequestMapping("/parking")
public class ParkingController {
	
	
	final ParkingService parkingService;
	
	public ParkingController (ParkingService parkingService) {
		this.parkingService = parkingService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingDto parkingDto) {
		var parkingSpotModel = new ParkingSpotModel(); 
		BeanUtils.copyProperties(parkingDto, parkingSpotModel);
		parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(parkingService.save(parkingSpotModel));
				
	}

}
