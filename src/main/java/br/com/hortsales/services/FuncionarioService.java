package br.com.hortsales.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.hortsales.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.hortsales.domain.Funcionario;
import br.com.hortsales.domain.Pessoa;
import br.com.hortsales.domain.dtos.FuncionarioDTO;
import br.com.hortsales.repositories.FuncionarioRepository;
import br.com.hortsales.repositories.PessoaRepository;

@Service
public class FuncionarioService {
		
	@Autowired
	private FuncionarioRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	

	public Funcionario findById(Integer id) {
		Optional<Funcionario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não foi encontrado: " + id));
	}


	public List<Funcionario> findAllFuncionarios() {
		return repository.findAll();
	}


	public Funcionario create(@Valid FuncionarioDTO objDto) {
		objDto.setId(null);
		validaCpfEEmail(objDto);
		Funcionario newObj = new Funcionario(objDto);
		return repository.save(newObj);
	}


	public Funcionario update(Integer id, FuncionarioDTO objDto) {
		objDto.setId(id);
		objDto.setSenha(encoder.encode(objDto.getSenha()));
		Funcionario oldObj = findById(id);
		validaCpfEEmail(objDto);
		oldObj = new Funcionario(objDto);
		return repository.save(oldObj);
	}
	
	private void validaCpfEEmail(FuncionarioDTO objDto) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDto.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema! ");
		}
		
		obj = pessoaRepository.findByEmail(objDto.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
			throw new DataIntegrityViolationException("E-MAIL já cadastrado no sistema! ");
		}
	}


	public void delete(Integer id) {
		repository.deleteById(id);
	}
}