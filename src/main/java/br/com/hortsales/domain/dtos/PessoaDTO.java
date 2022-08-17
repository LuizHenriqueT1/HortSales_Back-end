package br.com.hortsales.domain.dtos;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.hortsales.domain.Pessoa;
import br.com.hortsales.domain.enums.Perfil;

public class PessoaDTO extends Pessoa {
	
	private static final long serialVersionUID = 1L;
	
	protected Integer id; 
	protected String nome; 
	protected String cpf; 
	protected String email; 
	protected String senha; 
	protected String dataNascimento; 
	protected String telefone;
	protected String endereco;
	protected Set<Integer> perfils = new HashSet<>();
	
	public PessoaDTO() {
		super();
	}
	
	public PessoaDTO(Pessoa obj) {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getdataNascimento() {
		return dataNascimento;
	}

	public void setdataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Set<Perfil> getPerfils() {
		return perfils.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void setPerfils(Set<Integer> perfils) {
		this.perfils = perfils;
	}
	
}