package com.potoware.crud.programmer.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name = "estudiantes")
public class Estudiante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Para generar el ID automatico
	private Long id;
	
	@NotEmpty
	@Size(min = 1,max = 20)
	private String apellidos;
	
	@NotEmpty
	@Size(min = 1,max = 20)
	private String nombres;
	
	@NotEmpty
	@Size(min = 1,max = 15)
	private String noIdentificacion;
	
	@NotEmpty
	@Size(min = 2, max= 2) 
	private String tipoIdentificacion;
	
	@Email
	private String email;
	
	@Column(name = "fecha_nacimiento")
	@NotNull
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column(name = "fecha_registro")
	@NotNull
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
	@PrePersist
	public void prePersist() {
		fechaRegistro = new Date();
	}
	
	@Size(min = 10, max = 10)
	private String contacto;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getNoIdentificacion() {
		return noIdentificacion;
	}
	
	public void setNoIdentificacion(String noIdentificacion) {
		this.noIdentificacion = noIdentificacion;
	}
	
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	
	
	
}
