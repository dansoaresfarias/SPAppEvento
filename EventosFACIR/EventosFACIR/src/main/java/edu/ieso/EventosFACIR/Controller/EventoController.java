package edu.ieso.EventosFACIR.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.ieso.EventosFACIR.Model.Convidado;
import edu.ieso.EventosFACIR.Model.Evento;
import edu.ieso.EventosFACIR.Repository.ConvidadoRepository;
import edu.ieso.EventosFACIR.Repository.EventoRepository;

@Controller
public class EventoController {

	@Autowired
	EventoRepository er;
	
	@Autowired
	ConvidadoRepository cr;

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String form() {
		return "/evento/formEvento";
	}

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String form(Evento evento) {
		er.save(evento);
		return "redirect:/cadastrarEvento";
	}
	
	@RequestMapping(value = "/listarEventos")
	public ModelAndView listarEventos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = er.findAll();
		mv.addObject("eventos", eventos);
		return mv;

	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ModelAndView detalharEvento(@PathVariable("codigo") long codigo) {
		ModelAndView mv = new ModelAndView("evento/detalharEvento");
		Evento evento = er.findByCodigo(codigo);
		mv.addObject("evento", evento);
		Iterable<Convidado> convidados = cr.findByEvento(evento);
		mv.addObject("convidados", convidados);	
		return mv;		
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
	public String detalharEventoPost(@PathVariable("codigo") long codigo, Convidado convidado) {
		Evento evento = er.findByCodigo(codigo);
		convidado.setEvento(evento);
		cr.save(convidado);		
		return "redirect:/{codigo}";		
	}


}
