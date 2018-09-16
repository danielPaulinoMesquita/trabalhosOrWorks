package br.com.projetoangular.ws.controller;

import java.util.Date;

import javax.servlet.ServletException;

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
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(method=RequestMethod.POST, value="/autenticar", consumes=MediaType.APPLICATION_JSON_VALUE)
	public LoginAutenticar autenticar(@RequestBody Usuario usuario)throws ServletException {
		
		
		if(usuario.getNome()==null||usuario.getSenha()==null) {
			throw new ServletException("Nome e senha obrigatorios");
		}
		
		Usuario usuAutenticado= usuarioService.buscarUsuarioNome(usuario.getNome());

		
		if(usuAutenticado==null) {
			throw new ServletException("Usuário não Encontrado");
		}
		
		if(!usuAutenticado.getSenha().equals(usuario.getSenha())) {
			throw new ServletException("Senha ou Usuário inválido");
		}
		
		String token=Jwts.builder()// AQUI GERA O TOKEN
				.setSubject(usuAutenticado.getNome())
				.signWith(SignatureAlgorithm.HS512, "daniel")
				.setExpiration(new Date(System.currentTimeMillis()+3*(60*1000))).compact();
		
		return new LoginAutenticar(token);
		
	}
	
	
	
	private class LoginAutenticar{
		public String token;
		
		public LoginAutenticar(String token) {
			this.token= token;
		}

		

		
	}
}
