package br.com.hortsales.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.hortsales.domain.Casher;
import br.com.hortsales.domain.Funcionario;
import br.com.hortsales.domain.enums.Perfil;
import br.com.hortsales.repositories.CasherRepository;
import br.com.hortsales.repositories.FuncionarioRepository;

@Service
public class DBService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired 
	private CasherRepository casherRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() {
		Funcionario f1 = new Funcionario(null, "Luiz Henrique", "092.891.230-28", "luizh@gmail.com", encoder.encode("12345678"), "18/06/2002", "16996039420", "Avenida Paulista");
		f1.addPerfils(Perfil.FUNCIONARIO);
		f1.addPerfils(Perfil.ADMIN);
		Funcionario f2 = new Funcionario(null, "Maria Marta", "815.952.450-14", "mariaM@gmail.com", encoder.encode("12345678"), "08/03/1994", "1140028922", "Avenida Interlagos");
		f2.addPerfils(Perfil.FUNCIONARIO);
		Funcionario f3 = new Funcionario(null, "Jorge Matheus", "669.831.200-27", "jorgeM@gmail.com", encoder.encode("12345678"), "10/08/1988", "11956562323", "Avenida João Paulo");
		f3.addPerfils(Perfil.FUNCIONARIO);
		Funcionario f4 = new Funcionario(null, "Paula Fernandes", "691.523.890-57", "paulaF@gmail.com", encoder.encode("12345678"), "20/12/1999", "16936251478", "Rua Augusta");
		f4.addPerfils(Perfil.FUNCIONARIO);
		f4.addPerfils(Perfil.ADMIN);
		
		
		Casher c1 = new Casher(null, 1256.49);
		Casher c2 = new Casher(null, 1856.59);
		Casher c3 = new Casher(null, 1156.48);
		
		funcionarioRepository.saveAll(Arrays.asList(f1,f2,f3,f4));
		casherRepository.saveAll(Arrays.asList(c1,c2,c3));
	}

}
