package br.com.hortsales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hortsales.domain.Funcionario;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
	
}
