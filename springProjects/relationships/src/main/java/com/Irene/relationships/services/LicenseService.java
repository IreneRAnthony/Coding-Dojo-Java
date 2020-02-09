package com.Irene.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Irene.relationships.models.License;
import com.Irene.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	private static int licenseNum;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> allLicense(){
		return licenseRepository.findAll();
	}
	
	public License createLicense(License b) {
		return licenseRepository.save(b);
	}
	
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if(optionalLicense.isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}
	}
	
	public void deleteLicense(Long id) {
		licenseRepository.deleteById(id);
	}
	public String generateLicense() {
		String lastLicense = licenseRepository.findTopByOrderByNumberDesc().getNumber();
		int lastLicenseInt = Integer.parseInt(lastLicense);
		lastLicenseInt++;
		String formatted = String.format("%05d", lastLicenseInt);
		return formatted;
	}
	
}
