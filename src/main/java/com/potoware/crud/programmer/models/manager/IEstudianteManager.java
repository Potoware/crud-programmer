package com.potoware.crud.programmer.models.manager;

import java.util.List;

import com.potoware.crud.programmer.models.entity.Estudiante;

public interface IEstudianteManager {
	
	public List<Estudiante> findAll();
	
	public void save(Estudiante estudiante);
	
	public Estudiante find(Long id);
	
	public void delete(Long id);
}
