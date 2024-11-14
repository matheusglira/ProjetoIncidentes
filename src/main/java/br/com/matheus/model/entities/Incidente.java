package br.com.matheus.model.entities;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Incidente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIncident;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String description;
	
	
	@CreatedDate
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date updatedAt;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date closedAt;

	public Incidente() {
		
	}
	
	public Incidente(String name, String description, Date createdAt, Date updatedAt, Date closedAt) {
		super();
		this.name = name;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.closedAt = closedAt;
	}

	public int getIdIncident() {
		return idIncident;
	}

	public void setIdIncident(int idIncident) {
		this.idIncident = idIncident;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getClosedAt() {
		return closedAt;
	}

	public void setClosedAt(Date closedAt) {
		this.closedAt = closedAt;
	}

}
