package br.com.projetoangular.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoangular.ws.model.Estado;
import br.com.projetoangular.ws.service.EstadoService;

@RestController
public class EstadoController {

	@Autowired
	EstadoService estadoService;
	
	// SALVAR
	@RequestMapping(method=RequestMethod.POST, value="/estados", consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> salvar(@RequestBody Estado estado){
		estadoService.salvar(estado);
		return new ResponseEntity<Estado>(estado,HttpStatus.OK);
	}
	
	// BUSCAR TODOS ESTADOS
	@RequestMapping(method=RequestMethod.GET, value="/estados", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Estado>> buscarTodos(){
		Collection<Estado> estados= estadoService.buscarTodos();
		return new ResponseEntity<>(estados, HttpStatus.OK);
	}
	
	// BUSCAR POR ID 
	@RequestMapping(method=RequestMethod.GET, value="/estados/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> buscarPorId(@PathVariable Integer id){
		Estado estado= estadoService.buscarPorId(id);
		return new ResponseEntity<Estado>(estado, HttpStatus.OK);
	}
	
	// EXLUIR ESTADO
	@RequestMapping(method=RequestMethod.DELETE, value="/estados/{id}")
	public ResponseEntity<Estado> excluir(@PathVariable Integer id) {
		Estado estado= estadoService.buscarPorId(id);
		if(estado==null) {
			return new ResponseEntity<Estado>(HttpStatus.NOT_FOUND);
		}
		estadoService.excluir(estado);
		return new ResponseEntity<>(HttpStatus.OK);

	}
}















