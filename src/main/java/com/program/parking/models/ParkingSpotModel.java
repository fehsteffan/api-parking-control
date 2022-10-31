package com.program.parking.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_parking")
public class ParkingSpotModel implements Serializable {	
	private static final long serialVersionUID = 1L;
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(nullable= false)
		private String parkingSpotNumber;
		@Column(nullable= false)
		private String LicencePlateCar;
		@Column(nullable= false)
		private String brandCar;
		@Column(nullable= false)
		private String modelCar;
		@Column(nullable= false)
		private String colorCar;
		@Column(nullable= false)
		private LocalDateTime registrationDate;
		@Column(nullable= false)
		private String responsibleName;
		@Column(nullable= false)
		private String apartment;
		@Column(nullable= false)
		private String block;		
		
		public ParkingSpotModel() {
			
		}

		public ParkingSpotModel(Long id, String parkingSpotNumber, String licencePlateCar, String brandCar,
				String modelCar, String colorCar, LocalDateTime registrationDate, String responsibleName,
				String apartment, String block) {
			super();
			this.id = id;
			this.parkingSpotNumber = parkingSpotNumber;
			LicencePlateCar = licencePlateCar;
			this.brandCar = brandCar;
			this.modelCar = modelCar;
			this.colorCar = colorCar;
			this.registrationDate = registrationDate;
			this.responsibleName = responsibleName;
			this.apartment = apartment;
			this.block = block;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public LocalDateTime getRegistrationDate() {
			return registrationDate;
		}

		public void setRegistrationDate(LocalDateTime registrationDate) {
			this.registrationDate = registrationDate;
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

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ParkingSpotModel other = (ParkingSpotModel) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}	

}
