package br.com.matheus.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.matheus.model.entities.Incidente;

public interface IncidenteRepository extends CrudRepository<Incidente, Integer>, PagingAndSortingRepository<Incidente, Integer>{

}
