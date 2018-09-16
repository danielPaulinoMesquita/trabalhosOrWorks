package br.com.projetoangular.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.projetoangular.ws.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query("SELECT U FROM Usuario U where U.nome= :pnome")
	public Usuario buscarPorEmail(@Param("pnome") String nome);
	
}
