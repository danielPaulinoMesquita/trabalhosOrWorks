package br.com.projetoangular.ws.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoangular.ws.model.Cliente;
import br.com.projetoangular.ws.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	// NEGOCIOS
	public Cliente cadastrar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Collection<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	public void excluir(Cliente cliente) {
		clienteRepository.delete(cliente);
	}

	public Cliente buscarPorId(Integer id) {
		return clienteRepository.getOne(id);
	}
	
	public Cliente alterarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);

	}

}
