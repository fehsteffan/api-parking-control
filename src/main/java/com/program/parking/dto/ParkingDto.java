package com.program.parking.dto;

import javax.validation.constraints.NotBlank;

public class ParkingDto {
	
	@NotBlank
	private String parkingSpotNumber;
	@NotBlank
	private String LicencePlateCar;
	@NotBlank
	private String brandCar;
	@NotBlank
	private String modelCar;
	@NotBlank
	private String colorCar;
	@NotBlank
	private String responsibleName;
	@NotBlank
	private String apartment;
	@NotBlank
	private String block;
	
	
	public ParkingDto() {
		
	}

	public ParkingDto(@NotBlank String parkingSpotNumber, @NotBlank String licencePlateCar, @NotBlank String brandCar,
			@NotBlank String modelCar, @NotBlank String colorCar, @NotBlank String responsibleName,
			@NotBlank String apartment, @NotBlank String block) {
		super();
		this.parkingSpotNumber = parkingSpotNumber;
		LicencePlateCar = licencePlateCar;
		this.brandCar = brandCar;
		this.modelCar = modelCar;
		this.colorCar = colorCar;
		this.responsibleName = responsibleName;
		this.apartment = apartment;
		this.block = block;
	}

	public String getParkingSpotNumber() {
		return parkingSpotNumber;
	}

	public void setParkingSpotNumber(String parkingSpotNumber) {
		this.parkingSpotNumber = parkingSpotNumber;
	}

	public String getLicencePlateCar() {
		return LicencePlateCar;
	}

	public void setLicencePlateCar(String licencePlateCar) {
		LicencePlateCar = licencePlateCar;
	}

	public String getBrandCar() {
		return brandCar;
	}

	public void setBrandCar(String brandCar) {
		this.brandCar = brandCar;
	}

	public String getModelCar() {
		return modelCar;
	}

	public void setModelCar(String modelCar) {
		this.modelCar = modelCar;
	}

	public String getColorCar() {
		return colorCar;
	}

	public void setColorCar(String colorCar) {
		this.colorCar = colorCar;
	}

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}	

}
