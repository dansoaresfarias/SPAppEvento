package edu.ieso.EventosFACIR.Repository;

import org.springframework.data.repository.CrudRepository;

import edu.ieso.EventosFACIR.Model.Evento;

public interface EventoRepository extends CrudRepository<Evento, String>{

	Evento findByCodigo(long codigo);

}
