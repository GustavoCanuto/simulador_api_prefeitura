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

import br.com.simulaprefeitura.dto.UsuarioDetalharDto;
import br.com.simulaprefeitura.dto.UsuarioDto;
import br.com.simulaprefeitura.entidades.Hospital;
import br.com.simulaprefeitura.entidades.Usuario;
import br.com.simulaprefeitura.repository.HospitalRepository;
import br.com.simulaprefeitura.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private HospitalRepository hospitalRepository;
	

	@GetMapping
	public ResponseEntity<List<UsuarioDetalharDto>> listar() {
		
		return ResponseEntity.ok(usuarioRepository.findAll().stream().map(UsuarioDetalharDto::new).toList());
		
	}
	
	@GetMapping("/{cns}")
	public ResponseEntity<UsuarioDetalharDto> detalhar(@PathVariable Long cns) {

		 return ResponseEntity.ok(new UsuarioDetalharDto(usuarioRepository.findByCns(cns)));
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid UsuarioDto dados,
			UriComponentsBuilder uriBuilder) {
		
		Hospital hospital = hospitalRepository.findById(dados.idHospital())
				.orElseThrow(() -> new RuntimeException("Id do hospital informado não existe!"));
		
		var usuario = new Usuario(dados, hospital);

		usuarioRepository.save(usuario);


		var uri = uriBuilder.path("/usuario/{cns}").buildAndExpand(usuario.getCns()).toUri();

		return ResponseEntity.created(uri).body(usuario);

	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> excluir(@PathVariable Long id) {

		usuarioRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

}
