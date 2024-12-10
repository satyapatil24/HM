package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.DoctorDTO;
import com.cg.exception.InvalidProductException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Doctor;
import com.cg.service.IDoctorService;

@RequestMapping("/api")
@RestController
public class DoctorController {
	
	@Autowired
	IDoctorService doctorService;
    
	
	
	// Inject error messages from properties file
//  @Value("${error.doctorNotFound}")
//  private String doctorNotFoundMessage;
//
//  @Value("${error.doctorDeletionFailed}")
//  private String doctorDeletionFailedMessage;
//
  @Value("${error.doctorAlreadyExists}")
  private String doctorAlreadyExistsMessage;
  
  
	@GetMapping(path = "/doctors", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Doctor> getAllDoctors(){
		return doctorService.findAllDoctors();
		
	}
	
	@GetMapping(path="/doctor/{id}")
	 public DoctorDTO getDoctorById(@PathVariable int id) throws ResourceNotFoundException {
       return doctorService.findDoctorById(id)
                           .map(DoctorDTO::fromEntity)  
                           .orElseThrow(() -> new ResourceNotFoundException("Doctor not found for this id :: " + id));
   }
	
	@GetMapping("/doctors/{id}")
	public
	Optional<Doctor>findByDoctorId(@PathVariable int id)
	{	
		return doctorService.findDoctorById(id);	
	}
	
	@PostMapping("/addDoctor")
	public Doctor createDoctor(	@RequestBody Doctor d) {
		return doctorService.createDoctor(d);
	}
	
//	@Value("${error.notfound}")
//    private String productNotFoundMessage;
	
	
	@DeleteMapping("/doctor/delete/{id}")
	public void deleteDoctor(@PathVariable int id)
	{
	    doctorService.deleteDoctor(id);
	}
	

	
	@PutMapping("/update/{id}")
	public Doctor updateDoctor(@PathVariable int id, @RequestBody Doctor d) 
	{
	    return doctorService.updateDoctor(id, d);
	}

	

	
	
	
	
}
