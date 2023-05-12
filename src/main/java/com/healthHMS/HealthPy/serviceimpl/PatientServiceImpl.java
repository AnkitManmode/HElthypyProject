package com.healthHMS.HealthPy.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthHMS.HealthPy.dao.PatientDao;
import com.healthHMS.HealthPy.entity.Patient;
import com.healthHMS.HealthPy.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Patient addPatient(Patient patient) {
		Patient addedPatient = patientDao.addPatient(patient);
		return addedPatient;
	}

	@Override
	public boolean deletePatientById(String id) {
		boolean isdeleted = patientDao.deletePatientById(id);
		return isdeleted;
	}

	@Override
	public List<Patient> getAllapatient() {
		List<Patient> allapatient = patientDao.getAllapatient();
		return allapatient;
	}

	@Override
	public Patient getPatientById(String id) {
		Patient patient = patientDao.getPatientById(id);
		return patient;
	}

	@Override
	public List<Patient> findByFirstName(String firstName) {

	    // List<Patient> list =  new ArrayList<>();
		// List<Patient> list1 = list.stream().filter(s->s.getFirstName()).collect(Collectors.toList());
		// Function<Patient,String> list1 = Patient::getFirstName;
		// return (List<Patient>) list1;
		Session session = null;
		List<Patient> list  = new ArrayList<>();
		try {
		 session = sessionFactory.openSession();
		 Criteria criteria = session.createCriteria(Patient.class);
		 criteria.add(Restrictions.and(Restrictions.like("firstName","%"+firstName+ "%"),Restrictions.eq("firstName",firstName)));
		 list = criteria.list();
		} catch (Exception e) {
		e.printStackTrace();
	}
		return list;

	}


}
