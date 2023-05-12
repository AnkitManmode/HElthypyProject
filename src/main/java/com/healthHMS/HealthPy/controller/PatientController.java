package com.healthHMS.HealthPy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthHMS.HealthPy.dao.PatientDao;
import com.healthHMS.HealthPy.entity.Patient;
import com.healthHMS.HealthPy.exception.ResourceAlreadyExistException;
import com.healthHMS.HealthPy.exception.ResourseNotFoundException;
import com.healthHMS.HealthPy.service.PatientService;


@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@PostMapping(path="/addPatient")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) throws ResourceAlreadyExistException {
		Patient addedPatient = patientService.addPatient(patient);
		
		if(addedPatient!=null){
			return new ResponseEntity<>(addedPatient,HttpStatus.CREATED);
		}
		else{
			throw new ResourceAlreadyExistException("patient Alredy Exists with >ID: " +patient.getId());
		}
	}
	@DeleteMapping(path= "/deletePatient/{id}")
public ResponseEntity<String>deletePatientById(@PathVariable String id) throws Exception{
	
	boolean deletePatient = patientService.deletePatientById(id);
	if(deletePatient) {
		return new ResponseEntity<String>("Patient deleted succesully", HttpStatus.OK);
	}else {
		throw new ResourseNotFoundException("Patient not found with  id"+id);
	}
}
	
	@GetMapping(path = "/getAllPatient")
	public ResponseEntity<List<Patient>> getAllapatient() throws ResourseNotFoundException{
		 List<Patient> list = patientService.getAllapatient();
		if(list.isEmpty()) {
			throw new ResourseNotFoundException("patient not found");
		}else {
			return new ResponseEntity<List<Patient>>(list,HttpStatus.OK);
		}
	}	
	
	@GetMapping(value="/getpatientById/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable String id) throws ResourseNotFoundException{
		 Patient patient = patientService.getPatientById(id);
		 if(patient!=null) {
			 return new ResponseEntity<Patient>(patient,HttpStatus.OK);
		 }else {
			throw new ResourseNotFoundException("patient not found with id"+id);
		 }
	}	
	
	@GetMapping(value="/getPatientByName/{firstName}")
	public ResponseEntity<List<Patient>> findbyFirstName(@PathVariable String firstName) throws ResourseNotFoundException{
		List<Patient> listpatient = patientService.findByFirstName(firstName);
		if(listpatient.isEmpty()) {
			throw new ResourseNotFoundException("Patient not found with name "+ firstName);
		}else {
			return new ResponseEntity<List<Patient>>(listpatient, HttpStatus.OK);
		}
	}
}
