package com.program.parking.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.program.parking.models.ParkingSpotModel;
import com.program.parking.repositories.ParkingSpotRepository;

@Service
public class ParkingService {
	
	
	final ParkingSpotRepository parkingRepository;

	public ParkingService(ParkingSpotRepository parkingRepository) {		
		this.parkingRepository = parkingRepository;
	}
	

	@Transactional
	public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {		
		return parkingRepository.save(parkingSpotModel);
	}		
	
}
