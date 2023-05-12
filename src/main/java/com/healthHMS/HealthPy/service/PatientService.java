package com.healthHMS.HealthPy.service;

import java.util.List;

import com.healthHMS.HealthPy.entity.Patient;

public interface PatientService {

	public Patient addPatient(Patient patient);
	
	boolean deletePatientById(String id);
	
	List<Patient> getAllapatient();
	
	Patient getPatientById(String id);
	
	List<Patient> findByFirstName(String firstName);
	
	
	
	
}
