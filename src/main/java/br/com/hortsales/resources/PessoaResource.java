package br.com.hortsales.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hortsales.domain.Pessoa;
import br.com.hortsales.domain.dtos.PessoaDTO;
import br.com.hortsales.services.PessoaService;

@RestController
@RequestMapping(value = "/service/pessoa")
public class PessoaResource {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping(value = "/{email}")
	public ResponseEntity<Pessoa> findByEmail(@PathVariable String email) {
		Pessoa obj = pessoaService.findByEmail(email);
		return ResponseEntity.ok().body(new PessoaDTO(obj));
	}
}
