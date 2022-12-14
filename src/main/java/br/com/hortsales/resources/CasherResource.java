package br.com.hortsales.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.hortsales.domain.Casher;
import br.com.hortsales.domain.dtos.CasherDTO;
import br.com.hortsales.services.CasherService;

@RestController
@RequestMapping(value = "/service/casher")
public class CasherResource { 
	
	@Autowired
	private CasherService service;
	
	@GetMapping
	public ResponseEntity<List<CasherDTO>> findAllCasher() {
		List<Casher> list = service.findAllCasher();
		List<CasherDTO> listDto = list.stream()
				.map(cas -> new CasherDTO(cas)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<CasherDTO> createCasher(@Valid @RequestBody CasherDTO objDto) {
		Casher newObj = service.create(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping(value = "/lucro")
	public ResponseEntity findVendasMesEAno(@RequestParam Integer mes, @RequestParam Integer ano ) {
		List obj = service.findLucroMesEAno(mes, ano);
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping(value = "/media-de-lucro")
	public ResponseEntity findMediaLucroMesEAno(@RequestParam Integer mes, @RequestParam Integer ano ) {
		List obj = service.findMediaLucroMesEAno(mes, ano);
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping(value = "/lucros-semana")
	public ResponseEntity findLucrosUltimosSeteDias() {
	    List obj = service.findSomaLucrosUltimosSeteDias();
	    return ResponseEntity.ok().body(obj);
	}
	@GetMapping(value = "/lucros-ultimo-mes")
	public ResponseEntity findSomaLucrosUltimosTrintaDias() {
		List obj = service.findSomaLucrosUltimosTrintaDias();
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping(value = "/media-diaria-mes-anterior")
	public ResponseEntity findMediaDiariaLucrosUltimoMes() {
		List obj = service.findMediaDiariaLucrosUltimoMes();
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/faturamentos-ultimos-doze-meses")
		public ResponseEntity findFaturamentoUltimosDozeMeses() {
		List obj = service.findFaturamentoUltimosDozeMeses();
		return ResponseEntity.ok().body(obj);
		}
}
