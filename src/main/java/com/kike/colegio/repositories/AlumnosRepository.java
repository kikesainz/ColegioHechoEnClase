package com.kike.colegio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.entities.AlumnoEntity;

@Repository
public interface AlumnosRepository extends CrudRepository<AlumnoEntity, Integer>{
	
	@Query(value="SELECT new com.kike.colegio.dtos.AlumnoDTO(a.id, a.nombre, a.apellidos, a.municipio.nombre, a.municipio.idMunicipio, a.famNumerosa, a.activo)"
				+ "FROM com.kike.colegio.entities.AlumnoEntity a "
				+ "WHERE CAST (a.id  as STRING ) LIKE CONCAT ('%', :id , '%') "
				+ "AND a.nombre LIKE CONCAT ('%', :nombre, '%') "
				+ "AND a.apellidos LIKE CONCAT ('%', :apellido, '%') "
				+ "AND a.activo = :activo "
				+ "AND a.famNumerosa = :famNumerosa")
	public List<AlumnoDTO> buscaAlumnos(@Param("id") String id,
										@Param("nombre") String nombre,
										@Param("apellido")String apellido,
										@Param("activo") Integer activo,
										@Param("famNumerosa") Integer familiaNumerosa);

}
