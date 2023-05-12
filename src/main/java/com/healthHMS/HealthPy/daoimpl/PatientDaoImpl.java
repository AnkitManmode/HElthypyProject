package com.healthHMS.HealthPy.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthHMS.HealthPy.dao.PatientDao;
import com.healthHMS.HealthPy.entity.Patient;

@Repository
public class PatientDaoImpl implements PatientDao{


	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Patient addPatient(Patient patient) {

		Session session=null;
		Transaction tx=null;


		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(patient);

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

		}
		finally{
			if(session!=null){
				session.close();
			}
		}
		return patient;
	}

	@Override
	public boolean deletePatientById(String id) {
		Session session = null;
		boolean isdeleted = false;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Patient	presentPatient =  session.get(Patient.class, id);
			if(presentPatient!=null) {
				session.delete(presentPatient);
				isdeleted  = true;
				tx.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}

		return isdeleted;
	}

	@Override
	public List<Patient> getAllapatient() {
		Session session = null;
		List<Patient> list = new ArrayList<>();
		 try {
				session  = sessionFactory.openSession();
				Criteria criteria = session.createCriteria(Patient.class);
			 list = criteria.list();	
				
				}	catch(Exception e){
					e.printStackTrace();
				}
		return list;
	}

	@Override
	public Patient getPatientById(String id) {
		Session session = null;
		Patient patient = null;
		try {
		session = sessionFactory.openSession();
		patient  = session.get(Patient.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}	
		return patient;
	}

	

//	@Override
//	public List<Patient> findByFirstName(String firstName) {
//		Session session = null;
//		List<Patient> list  = new ArrayList<>();
//		try {
//		 session = sessionFactory.openSession();
//		 Criteria criteria = session.createCriteria(Patient.class);
//		 criteria.add(Restrictions.and(Restrictions.like("firstName","%"+firstName+ "%"),Restrictions.eq("firstName",firstName)));
//		 list = criteria.list();
//		} catch (Exception e) {
//		e.printStackTrace();
//	}
//		return list;
//	}

}
