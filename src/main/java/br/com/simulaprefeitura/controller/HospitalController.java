package br.com.simulaprefeitura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.simulaprefeitura.dto.HospitalDto;
import br.com.simulaprefeitura.entidades.Hospital;
import br.com.simulaprefeitura.repository.HospitalRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("hospital")
public class HospitalController {
	
	@Autowired
	private HospitalRepository hospitalRepository;
	

	@GetMapping
	public ResponseEntity<List<HospitalDto>> listar() {
		
		return ResponseEntity.ok(hospitalRepository.findAll().stream().map(HospitalDto::new).toList());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HospitalDto> detalhar(@PathVariable Long id) {

		 return ResponseEntity.ok(new HospitalDto(hospitalRepository.getReferenceById(id)));
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<Hospital> cadastrar(@RequestBody @Valid HospitalDto dados,
			UriComponentsBuilder uriBuilder) {
		
		var hospital = new Hospital(dados);

		hospitalRepository.save(hospital);


		var uri = uriBuilder.path("/hospital/{id}").buildAndExpand(hospital.getId()).toUri();

		return ResponseEntity.created(uri).body(hospital);

	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> excluir(@PathVariable Long id) {

		hospitalRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
	

}

