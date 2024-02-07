package com.kike.colegio.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kike.colegio.dao.ICombosDAO;
import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.dtos.ComboDTO;
import com.kike.colegio.negocio.IAlumnosService;

@Controller
@RequestMapping("/alumnos/")
public class AlumnosController {
	
	@Autowired
	IAlumnosService alumnosService;
	@Autowired
	@Qualifier("combospringdatajpa")
	ICombosDAO combosDAO;
	
	@GetMapping("listaralumnos")
	public String getListadoAlumnos() {
		return "listadoAlumnos";
	}
	
	@PostMapping("listaralumnos")
	public String buscarAlumnos(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
								@RequestParam("apellido")String apellido, @RequestParam(value="famNumerosa", required= false) String famNumerosa,
								@RequestParam(value="activo", required = false)String activo, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		famNumerosa = (famNumerosa != null)? "1": "0";
		activo = (activo != null)? "1": "0";
		
		
		List<AlumnoDTO> listaAlumnos = alumnosService.buscarAlumnos(id, nombre, apellido, activo, famNumerosa);
		
		model.addAttribute("lista", listaAlumnos);
		
		return "listadoAlumnos";
		
	}
	
	@GetMapping("insertaralumnos")
	public String getFormularioInsertarAlumno(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		List<ComboDTO> listaMunicipios = combosDAO.recuperaCombosMunicipio();
		
		
		model.addAttribute("comboMunicipios", listaMunicipios);
		return "insertarAlumnos";
	}
	
	@PostMapping("insertaralumnos")
	public String insertarAlumno(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
								@RequestParam("apellido")String apellido, @RequestParam(value="famNumerosa", required= false) String famNumerosa,
								@RequestParam(value="activo", required = false)String activo, @RequestParam ("municipios") String municipios,
								ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		List<ComboDTO> listaMunicipios = combosDAO.recuperaCombosMunicipio();
		
		famNumerosa = (famNumerosa != null)? "1": "0";
		activo = (activo != null)? "1": "0";
		
		Integer resultado = alumnosService.insertarAlumno(id, nombre, apellido, activo, famNumerosa, municipios);
		model.addAttribute("resultado", resultado);
		
		model.addAttribute("comboMunicipios", listaMunicipios);
		
		
		return "insertarAlumnos";
	}
	
	@GetMapping("formularioactualizaralumno")
	public String getFormularioActualizarAlumno() {
		return "actualizarAlumnos";
	}
	
	@PostMapping("formularioactualizaralumno")
	public String getFormulariosActualizarAlumnos(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("apellido")String apellido, @RequestParam(value="famNumerosa", required= false) String famNumerosa,
			@RequestParam(value="activo", required = false)String activo, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		famNumerosa = (famNumerosa != null)? "1": "0";
		activo = (activo != null)? "1": "0";
		
		List<ComboDTO> listaMunicipios = combosDAO.recuperaCombosMunicipio();
		model.addAttribute("comboMunicipios", listaMunicipios);
		
		List<AlumnoDTO> listaAlumnos = alumnosService.buscarAlumnos(id, nombre, apellido, activo, famNumerosa);		
		model.addAttribute("lista", listaAlumnos);
		
		return "actualizarAlumnos";
	}
	
	@PostMapping("actualizaralumno")
	public String actualizarAlumno(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("apellido")String apellido, @RequestParam(value="famNumerosa", required= false) String famNumerosa,
			@RequestParam(value="activo", required = false)String activo, @RequestParam ("municipios") String municipios,
			ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		famNumerosa = (famNumerosa != null)? "1": "0";
		activo = (activo != null)? "1": "0";
		
		alumnosService.actualizarAlumno(id, nombre, apellido, activo, famNumerosa, municipios);
		
		return "actualizarAlumnos";
	}
	
	@GetMapping("formularioborraralumno")
		public String formularioBorrarAlumno() {
			
			return "borrarAlumnos";
			
		
	}
	
	@PostMapping("formularioborraralumno")
	public String getFormulariosBorrarAlumnos(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("apellido")String apellido, @RequestParam(value="famNumerosa", required= false) String famNumerosa,
			@RequestParam(value="activo", required = false)String activo, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		famNumerosa = (famNumerosa != null)? "1": "0";
		activo = (activo != null)? "1": "0";
		
		List<ComboDTO> listaMunicipios = combosDAO.recuperaCombosMunicipio();
		model.addAttribute("comboMunicipios", listaMunicipios);
		
		List<AlumnoDTO> listaAlumnos = alumnosService.buscarAlumnos(id, nombre, apellido, activo, famNumerosa);		
		model.addAttribute("lista", listaAlumnos);
		
		return "borrarAlumnos";
	}
	
	@PostMapping("borraralumno")
	public String borrarAlumno(@RequestParam("id") String id) throws ClassNotFoundException, SQLException, NamingException {
		alumnosService.borrarAlumno(id);
		
		return "borrarAlumnos";
	}

}
