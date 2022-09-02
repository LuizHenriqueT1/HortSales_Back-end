package br.com.hortsales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hortsales.domain.Casher;

public interface CasherRepository extends JpaRepository<Casher, Integer> {
	

}
