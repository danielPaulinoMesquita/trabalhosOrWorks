package br.com.projetoangular.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoangular.ws.model.Estado;
import br.com.projetoangular.ws.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	EstadoRepository estadoRepo;

	public Estado salvar(Estado estado) {
		return estadoRepo.save(estado);
	}

	public List<Estado> buscarTodos() {
		return estadoRepo.findAll();
	}
	
	public Estado buscarPorId(Integer id) {
		return estadoRepo.getOne(id);
	}
	
	public void excluir(Estado estado) {
		 estadoRepo.delete(estado);
	}
	
	public Estado alterar(Estado estadoAlterar) {
		return estadoRepo.save(estadoAlterar);
	}

}
