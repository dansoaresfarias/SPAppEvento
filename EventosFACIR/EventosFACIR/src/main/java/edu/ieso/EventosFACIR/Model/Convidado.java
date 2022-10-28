package edu.ieso.EventosFACIR.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Convidado {

	@Id
	private String rg;
	private String nomeConvidado;

	@ManyToOne
	private Evento evento;

	public String getNomeConvidado() {
		return nomeConvidado;
	}

	public String getRg() {
		return rg;
	}

	public void setNomeConvidado(String nomeConvidado) {
		this.nomeConvidado = nomeConvidado;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
