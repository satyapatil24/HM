package com.cg.__SpringRest_Hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.util.Arrays;
import java.util.Optional;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.controller.DoctorController;
import com.cg.model.Doctor;
import com.cg.service.IDoctorService;

@ExtendWith(MockitoExtension.class)
public class DoctorControllerTest {
	@Mock
	private IDoctorService doctorService;
	@InjectMocks
	private DoctorController doctorController;
	private Doctor doctor;
 
	@BeforeEach
    void setUp() {
        doctor = new Doctor(1, "Yasho", "Cardiologist");
    }
	   @Test
	    void testGetAllDoctors() {
	        when(doctorService.findAllDoctors()).thenReturn(Arrays.asList(doctor));
 
	        var doctors = doctorController.getAllDoctors();
	        assertFalse(doctors.isEmpty());
	        assertEquals(1, doctors.size());
	        assertEquals("Yasho", doctors.get(0).getDname());
	    }
	   @Test
	    void testGetByDoctorId() {
	        when(doctorService.findDoctorById(1)).thenReturn(Optional.of(doctor));
 
	        var result = doctorController.findByDoctorId(1);
	        assertTrue(result.isPresent());
	        assertEquals("Yasho", result.get().getDname());
	    }

	   @Test
	    void testCreateMyDoctor() {
	        when(doctorService.createDoctor(doctor)).thenReturn(doctor);
 
	        Doctor createdDoctor = doctorController.createDoctor(doctor);
	        assertNotNull(createdDoctor);
	        assertEquals("Yasho", createdDoctor.getDname());
	    }
//	   @Test
//	    void testDeleteMyDoctor() {
//	        doNothing().when(doctorService).deleteDoctor(1);
//
//	        doctorController.deleteMyDoctor(1);
//
//	        verify(doctorService, times(1)).deleteDoctor(1);
//	    }

//	   @Test
//	   void testDeleteMyDoctor() {
//	       // Mocking the deleteDoctor method to return true
//	       when(doctorService.deleteDoctor(1)).thenReturn(true);
// 
//	       // Call the controller method
//	       doctorController.deleteDoctor(1);
// 
//	       // Verify that deleteDoctor was called exactly once with ID 1
//	       verify(doctorService, times(1)).deleteDoctor(1);
//	   }
// 
//	   @Test
//	    void testUpdateMyProduct()  {
//	        when(doctorService.updateDoctor(doctor)).thenReturn(doctor);
// 
//	        Doctor updatedDoctor = doctorController.updateDoctor(doctor);
//	        assertNotNull(updatedDoctor);
//	        assertEquals("Yasho", updatedDoctor.getDname());
//	    }
}