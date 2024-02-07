package com.kike.colegio.dao.jdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.kike.colegio.dao.ICombosDAO;
import com.kike.colegio.dtos.ComboDTO;
import com.kike.colegio.utils.DBUtils;

@Component("combojdbc")
public class CombosDAOImpl implements ICombosDAO{

	@Override
	public List<ComboDTO> recuperaCombosMunicipio() throws ClassNotFoundException, SQLException, NamingException {
		String sql = "SELECT id_municipio, nombre FROM municipios ORDER BY nombre";
		
		List<ComboDTO> listaMunicipios = new ArrayList<>();
		
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
	
		while(rs.next()) {
			listaMunicipios.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		connection.close();
		
		return listaMunicipios;
	}

}
