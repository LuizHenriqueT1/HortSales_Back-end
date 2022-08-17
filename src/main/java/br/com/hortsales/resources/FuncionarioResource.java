package br.com.hortsales.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.hortsales.domain.Funcionario;
import br.com.hortsales.domain.dtos.FuncionarioDTO;
import br.com.hortsales.services.FuncionarioService;

@RestController
@RequestMapping(value = "/service/funcionarios")
public class FuncionarioResource {
	
	@Autowired
	private FuncionarioService service;
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<FuncionarioDTO> findById(@PathVariable Integer id) {
		Funcionario obj = service.findById(id);
		return ResponseEntity.ok().body(new FuncionarioDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<FuncionarioDTO>> findAllFuncionarios() {
		List<Funcionario> list = service.findAllFuncionarios();
		List<FuncionarioDTO> listDto = list.stream()
				.map(fun -> new FuncionarioDTO(fun)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<FuncionarioDTO> createFuncionario(@Valid @RequestBody FuncionarioDTO objDto) {
		Funcionario newObj = service.create(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<FuncionarioDTO> updateFuncionario(@PathVariable Integer id, @RequestBody FuncionarioDTO objDto) {
		Funcionario obj = service.update(id, objDto);
		return ResponseEntity.ok().body(new FuncionarioDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<FuncionarioDTO> deleteFuncionario(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
