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
import br.com.projetoangular.ws.model.Cliente;
import br.com.projetoangular.ws.service.ClienteService;

@RestController
@RequestMapping(value="/admin")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	// -------------- END POINTS -----------------

	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	// consumes é para quando vai consumir ou adquirir algum dado ou informação da
	// requisição que está com JSON

	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		Cliente clienteCadastrado = clienteService.cadastrar(cliente);

		return new ResponseEntity<Cliente>(clienteCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	// produces é para quando vai produzir um corpo JSON e depois responder a
	// requisição
	public ResponseEntity<Collection<Cliente>> buscarClientes() {
		Collection<Cliente> clientesAchados = clienteService.buscarTodos();
		return new ResponseEntity<Collection<Cliente>>(clientesAchados, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/clientes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	// produces é para quando vai produzir um corpo JSON e depois responder a
	// requisição
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id) {
		Cliente clienteAchado = new Cliente();

		clienteAchado = clienteService.buscarPorId(id);
		if (clienteAchado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(clienteAchado, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}")
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id) {
		Cliente clienteEncontrado = clienteService.buscarPorId(id);

		if (clienteEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		clienteService.excluir(clienteEncontrado);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> alterar(@RequestBody Cliente cliente) {

		Cliente clienteAlterado = clienteService.alterarCliente(cliente);
		return new ResponseEntity<Cliente>(clienteAlterado, HttpStatus.CREATED);
	}

}
