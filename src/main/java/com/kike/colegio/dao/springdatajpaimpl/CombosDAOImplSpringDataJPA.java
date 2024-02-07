package com.kike.colegio.dao.springdatajpaimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.ICombosDAO;
import com.kike.colegio.dtos.ComboDTO;
import com.kike.colegio.entities.MunicipiosEntity;
import com.kike.colegio.repositories.MunicipioRepository;

@Component("combospringdatajpa")
public class CombosDAOImplSpringDataJPA implements ICombosDAO{
	
	@Autowired
	private MunicipioRepository municipioRepository;

	@Override
	public List<ComboDTO> recuperaCombosMunicipio() throws ClassNotFoundException, SQLException, NamingException {
		Iterable <MunicipiosEntity> listaEntidadesMunicipio = municipioRepository.findAll();
		return mapeoMunicipiosEntityComboDTO(listaEntidadesMunicipio);
	}
	
	private List<ComboDTO> mapeoMunicipiosEntityComboDTO (Iterable <MunicipiosEntity> listaEntidadesMunicipio){
		
		List<ComboDTO> comboMunicipio = new ArrayList<>();
		
		for (MunicipiosEntity m : listaEntidadesMunicipio) {
			comboMunicipio.add(new ComboDTO(m.getIdMunicipio(), m.getNombre()));
		}
		
	
		return comboMunicipio;
	}

}
