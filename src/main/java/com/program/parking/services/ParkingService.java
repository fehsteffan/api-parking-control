package com.program.parking.services;

import java.util.List;

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
	
	public boolean existsByLicensePlateCar(String LicensePlateCar) {
		return parkingRepository.existsByLicensePlateCar(LicensePlateCar);
	}


	public boolean existsByParkingSpotNumber(String parkingSpotNumber) {		
		return parkingRepository.existsByParkingSpotNumber(parkingSpotNumber);
	}


	public boolean existsByApartmentAndBlock(String apartment, String block) {		
		return parkingRepository.existsByApartmentAndBlock(apartment, block);
	}
	
	public List<ParkingSpotModel> findAll() {
		return parkingRepository.findAll();
	}	
	
}
