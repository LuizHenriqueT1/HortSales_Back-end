package br.com.hortsales.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hortsales.domain.Pessoa;
import br.com.hortsales.repositories.PessoaRepository;
import br.com.hortsales.services.exception.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa findByEmail(String email) {
		Optional<Pessoa> obj = pessoaRepository.findByEmail(email);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não foi encontrado: " + email));
	}
}
