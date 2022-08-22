package com.potoware.crud.programmer.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.potoware.crud.programmer.models.entity.Estudiante;
import com.potoware.crud.programmer.models.manager.IEstudianteManager;

@Controller
@SessionAttributes("estudiante")
public class EstudianteController {
	
	@Autowired
	public IEstudianteManager estudianteManager;
	
	@GetMapping(value= {"listar",""})
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de estudiantes");
		model.addAttribute("estudiantes", estudianteManager.findAll());
		
		return "listar";
		
	}
	
	@RequestMapping(value="/form")
	public String crear(Map <String, Object> model) {
		model.put("titulo", "Formulario Estudiante");
		Estudiante estudiante = new Estudiante();
		model.put("estudiante", estudiante);
		return "form";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(@Valid Estudiante estudiante, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo","Formulario Estudiante");
			return "form";
		}
		
		estudianteManager.save(estudiante);
		status.setComplete();
		
		return "redirect:listar";
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map <String, Object> model) {
		Estudiante estudiante = null;
		if(id>0) {
			estudiante = estudianteManager.find(id);
		}
		else {
			return "redirect:/listar";
		}
		model.put("estudiante", estudiante);
		model.put("titulo", "Editar Estudiante");
		return "form";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		if(id>0) {
			estudianteManager.delete(id);
		}
			return "redirect:/listar";
		
	}
}
