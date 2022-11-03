package br.com.hortsales.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.hortsales.domain.dtos.CasherDTO;


@Entity
public class Casher implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	protected Double lucroDia;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataDoValor = LocalDate.now();
	
	public Casher() {
		super();
	}
	
	public Casher(Integer id, Double lucroDia) {
		super();
		this.id = id;
		this.lucroDia = lucroDia;
	}
	
	public Casher(CasherDTO obj) {
		super();
		this.id = obj.getId();
		this.lucroDia = obj.getLucroDia();
		this.dataDoValor = obj.getDataDoValor();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getLucroDia() {
		return lucroDia;
	}

	public void setLucroDia(Double lucroDia) {
		this.lucroDia = lucroDia;
	}

	public LocalDate getDataDoValor() {
		return dataDoValor;
	}

	public void setDataDoValor(LocalDate dataDoValor) {
		this.dataDoValor = dataDoValor;
	}

}
