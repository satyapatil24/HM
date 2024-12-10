package com.cg.dto;

import com.cg.model.Doctor;

public class DoctorDTO {
	
	private int id;
	public String dname;
	public String qualification;
	public DoctorDTO(int id, String dname, String qualification) {
		super();
		this.id = id;
		this.dname = dname;
		this.qualification = qualification;
	}
	public DoctorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	@Override
	public String toString() {
		return "DoctorDTO [id=" + id + ", dname=" + dname + ", qualification=" + qualification + "]";
	}
	
	public static DoctorDTO fromEntity(Doctor dr) //to convert product to productDTO
	{
		return new DoctorDTO(dr.getId(),dr.getDname(),dr.getQualification());
	}
	
	public Doctor toEntity() // from DTO to product object
	{
		return new Doctor(this.id, this.dname, this.qualification);
	}

}
