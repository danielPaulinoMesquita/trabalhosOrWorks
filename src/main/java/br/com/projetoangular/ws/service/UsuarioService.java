package br.com.projetoangular.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoangular.ws.model.Usuario;
import br.com.projetoangular.ws.repository.UsuarioRepository;

@Service
public class UsuarioService {

		@Autowired
		UsuarioRepository usuRepo;
		
		public Usuario salvarUsuario(Usuario usuario) {
			return usuRepo.save(usuario);
		}
		
		public Usuario buscarUsuarioNome(String nome) {
			return usuRepo.buscarPorEmail(nome);
		}
		
		public Collection<Usuario> buscarTodos(){
			return usuRepo.findAll();
		}

}
