package edu.ieso.EventosFACIR.Repository;

import org.springframework.data.repository.CrudRepository;

import edu.ieso.EventosFACIR.Model.Convidado;
import edu.ieso.EventosFACIR.Model.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String>{
	
	Iterable<Convidado> findByEvento(Evento evento);

}
