package com.cg.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Doctor")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@NotNull(message = "id cannot be null")
	@Column(name="dId")

	private int id;
	
	@NotBlank(message = "name cannot be null")
	@Column(name="dName")
	public String dname;
	
	@Column(name="qualification")
	public String qualification;
	
}