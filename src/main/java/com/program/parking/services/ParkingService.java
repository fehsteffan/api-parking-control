package com.program.parking.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	public Page<ParkingSpotModel> findAll(Pageable pageable) {
		return parkingRepository.findAll(pageable);
	}	
	
	
	public Optional<ParkingSpotModel> findById(Long id) {
		return parkingRepository.findById(id);
	}
	
	@Transactional
	public void delete(ParkingSpotModel parkingSpotModel ) {
		parkingRepository.delete(parkingSpotModel);
	}	
	
	public void uddateDate(ParkingSpotModel parkingSpotModel) {
		parkingRepository.save(parkingSpotModel);
	}	
}
