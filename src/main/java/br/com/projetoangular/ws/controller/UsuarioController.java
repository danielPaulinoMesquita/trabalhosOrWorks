package br.com.projetoangular.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoangular.ws.model.Usuario;
import br.com.projetoangular.ws.service.UsuarioService;

@RestController
public class UsuarioController {
		
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(method=RequestMethod.POST, value="/usuarios",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioSalvo= usuarioService.salvarUsuario(usuario);
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.CREATED);
	}
	
	@RequestMapping(method= RequestMethod.GET, value="/usuarios", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Usuario>> buscarTodos(){
		Collection<Usuario> lista= usuarioService.buscarTodos();
		return new ResponseEntity<Collection<Usuario>>(lista, HttpStatus.FOUND);
	}
}
