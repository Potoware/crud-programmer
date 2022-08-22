package com.potoware.crud.programmer.models.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.potoware.crud.programmer.models.dao.IEstudianteDao;
import com.potoware.crud.programmer.models.entity.Estudiante;

@Service
public class EstudianteManager implements IEstudianteManager{

	@Autowired
	private IEstudianteDao estudianteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Estudiante> findAll() {
		
		return (List<Estudiante>) estudianteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Estudiante estudiante) {
		estudianteDao.save(estudiante);
	}

	@Override
	@Transactional(readOnly = true)
	public Estudiante find(Long id) {
		
		return estudianteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {

		estudianteDao.deleteById(id);
		
	}

}
