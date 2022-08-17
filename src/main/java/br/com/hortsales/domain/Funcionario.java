package br.com.hortsales.domain;

import java.util.stream.Collectors;

import javax.persistence.Entity;

import br.com.hortsales.domain.dtos.FuncionarioDTO;
import br.com.hortsales.domain.enums.Perfil;

@Entity
public class Funcionario extends Pessoa{
	
	private static final long serialVersionUID = 1L;
	
	public Funcionario() {
		super();
		addPerfils(Perfil.FUNCIONARIO);
	}
	
	public Funcionario(Integer id, String nome, String cpf, String email, String senha, String dataNascimento, String telefone, String endereco) {
		super(id, nome, cpf, email, senha, dataNascimento, telefone, endereco);
		addPerfils(Perfil.FUNCIONARIO);
	}
	
	public Funcionario(FuncionarioDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.dataNascimento = obj.getdataNascimento();
		this.telefone = obj.getTelefone();
		this.endereco = obj.getEndereco();
		this.perfils = obj.getPerfils().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}
}

