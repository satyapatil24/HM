package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.model.Doctor;

public interface IDoctorService {
	public List<Doctor> findAllDoctors() ;
	public Optional<Doctor>findDoctorById (int id);
	public Doctor createDoctor(Doctor dr);
	public void deleteDoctor(int id);
	Doctor updateDoctor(int id, Doctor dr);
	
}
