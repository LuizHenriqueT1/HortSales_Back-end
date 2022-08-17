package br.com.hortsales.domain.dtos;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.hortsales.domain.Funcionario;
import br.com.hortsales.domain.Pessoa;
import br.com.hortsales.domain.enums.Perfil;

public class FuncionarioDTO extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	protected Integer id; 
	@NotNull(message = "O campo NOME não pode ser nulo")
	protected String nome; 
	@NotNull(message = "O campo CPF não pode ser nulo")
	protected String cpf; 
	@NotNull(message = "O campo E-MAIL não pode ser nulo")
	protected String email; 
	@NotNull(message = "O campo de SENHA não pode ser nulo")
	protected String senha; 
	@NotNull(message = "O campo dataNascimento não pode ser nulo")
	protected String dataNascimento; 
	@NotNull(message = "O campo TELEFONE não pode ser nulo")
	protected String telefone;
	@NotNull(message = "O campo ENDEREÇO não pode ser nulo")
	protected String endereco;
	protected Set<Integer> perfils = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();
	
	public FuncionarioDTO() {
		super();
		addPerfils(Perfil.FUNCIONARIO);
	}

	public FuncionarioDTO(Funcionario obj) {
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
		addPerfils(Perfil.FUNCIONARIO);
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

	public void addPerfil(Perfil perfil) {
		this.perfils.add(perfil.getCodigo());
	}
	
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}
