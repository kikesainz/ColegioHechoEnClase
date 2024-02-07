package com.kike.colegio.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kike.colegio.entities.MunicipiosEntity;

@Repository
public interface MunicipioRepository extends CrudRepository<MunicipiosEntity, Integer>{

}
