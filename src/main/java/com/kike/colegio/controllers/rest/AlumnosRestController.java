package com.kike.colegio.controllers.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.repositories.AlumnosRepository;

@RestController
@RequestMapping("/v1")
public class AlumnosRestController {
	
	@Autowired
	private AlumnosRepository alumnosRepository;
	
	
	@PostMapping("/alumnos")
	public ResponseEntity insertarAlumno(@RequestBody AlumnoEntity alumno) {
		
		alumnosRepository.save(alumno);
		
		
		return new ResponseEntity<>("Alumno insertado con éxito", HttpStatus.OK);
		
	}
	
	
	@PutMapping("/alumnos")
	public ResponseEntity actualizarAlumno(@RequestBody AlumnoEntity alumno) {
		
		alumnosRepository.save(alumno);
		
		
		return new ResponseEntity<>("Alumno insertado con éxito", HttpStatus.OK);
		
	}
	
	@GetMapping(value= "/alumnos", params = {"id","nombre","apellido","famNumerosa","activo"})
	public List<AlumnoDTO> obtenerAlumnoConFiltros(@RequestParam(value= "id", required=false) Integer id,
												 @RequestParam (value= "nombre", required=false) String  nombre,
												 @RequestParam (value= "apellido", required=false) String  apellido,
												 @RequestParam (value= "famNumerosa", required=false) Integer  famNumerosa,
												 @RequestParam (value= "activo", required=false) String  activo){
//		Iterable<AlumnoEntity> alumnos =  alumnosRepository.findAll();
		
		Integer activoInteger = null;
		if (!activo.equals("")) {
			activoInteger = Integer.parseInt(activo);
		}
		
		List<AlumnoDTO> a =  alumnosRepository.buscaAlumnos(id.toString(), nombre, apellido, 
				activoInteger, famNumerosa);
		
		return a;
		
		
	}
//	@GetMapping(value="/alumnos")
//	public Iterable<AlumnoEntity> obtenerTodosAlumnos(){
//		Iterable<AlumnoEntity> alumnos =  alumnosRepository.findAll();
//		
//		return alumnos;
//	}
//	
	@GetMapping(value= "/alumnos/{id}")
	public ResponseEntity<AlumnoEntity> obtenerAlumnoPorID(@PathVariable("id") Integer id){
//		Iterable<AlumnoEntity> alumnos =  alumnosRepository.findAll();
		
		AlumnoEntity a =  alumnosRepository.findById(id).get();
		
		return new ResponseEntity<>(a, HttpStatus.OK);
		
		
	}
	

	

}
