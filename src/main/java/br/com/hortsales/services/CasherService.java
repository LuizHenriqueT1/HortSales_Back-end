package br.com.hortsales.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.hortsales.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hortsales.domain.Casher;
import br.com.hortsales.domain.dtos.CasherDTO;
import br.com.hortsales.repositories.CasherRepository;



@Service
public class CasherService {

	@Autowired
	private CasherRepository repository;

	public List<Casher> findAllCasher() {
		return repository.findAll();
	}

	public Casher create(@Valid CasherDTO objDto) {
		objDto.setId(null);
		Casher newObj = new Casher(objDto);
		return repository.save(newObj);
	}
    public List findLucroMesEAno(Integer mes, Integer ano) {
		Optional<List> obj = repository.findSomaLucroByMesAno(mes, ano);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Nenhum valor encontrado nessa data"));
    }
	public List findMediaLucroMesEAno(Integer mes, Integer ano) {
		Optional<List> obj = repository.findMediaLucroMesByMesAno(mes, ano);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Nenhum valor encontrado nessa data"));
	}
	public List findSomaLucrosUltimosSeteDias() {
	    Optional<List> obj = repository.findSomaLucrosUltimosSeteDias();
	    return obj.orElseThrow(() -> new ObjectNotFoundException("Nenhum valor encontrado nos ultimos 7 dias"));
	}
	public List findSomaLucrosUltimosTrintaDias() {
		Optional<List> obj = repository.findSomaLucrosUltimosTrintaDias();
		return obj.orElseThrow(() -> new ObjectNotFoundException("Nenhum valor encontrado nos ultimos 7 dias"));
	}
	public List findMediaDiariaLucrosUltimoMes() {
		Optional<List> obj = repository.findMediaDiariaLucrosUltimoMes();
		return obj.orElseThrow(() -> new ObjectNotFoundException("Nenhum valor encontrado no mês anterior"));
	}
}
