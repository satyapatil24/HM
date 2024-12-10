package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.cg.model.Doctor;
import com.cg.repository.DoctorRepository;

@Service
public class DoctorService implements IDoctorService {

	@Autowired
	DoctorRepository drepo;

	@Override
	public List<Doctor> findAllDoctors() {
		// TODO Auto-generated method stub
		return drepo.findAll();
	}

	@Override
	public Optional<Doctor> findDoctorById(int id) {
		// TODO Auto-generated method stub
		return drepo.findById(id);
	}

	@Override
	public Doctor createDoctor(Doctor dr) {
		// TODO Auto-generated method stub
		return drepo.save(dr);
	}

	
	@Override
	public void deleteDoctor(int id) {
		// TODO Auto-generated method stub
		drepo.deleteById(id);
	}

	@Override
	public Doctor updateDoctor(int id, Doctor dr) {
		// TODO Auto-generated method stub
		Optional<Doctor> doc = findDoctorById(id);
	    if (doc.isPresent()) {
	    	Doctor d=doc.get();
	    	d.setDname(dr.getDname());
	    	d.setQualification(dr.getQualification());
	    	return drepo.save(d);
	    }
	    return null;
	}

	
	
	
	
}
