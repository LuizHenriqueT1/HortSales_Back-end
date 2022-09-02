package br.com.hortsales.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hortsales.domain.Casher;
import br.com.hortsales.domain.dtos.CasherDTO;
import br.com.hortsales.repositories.CasherRepository;



@Service
public class CasherService {

	@Autowired
	private CasherRepository repository;

	public List<Casher> findAllCasher() {
		return repository.findAll();
	}

	public Casher create(@Valid CasherDTO objDto) {
		objDto.setId(null);
		Casher newObj = new Casher(objDto);
		return repository.save(newObj);
	}

	
}
