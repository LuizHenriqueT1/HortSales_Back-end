package br.com.hortsales.domain.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.hortsales.domain.Casher;

public class CasherDTO extends Casher{

	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	protected Double lucroDia;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataDoValor = LocalDate.now();
		
	public CasherDTO() {
		super();
	}
	
	public CasherDTO(Casher obj) {
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
