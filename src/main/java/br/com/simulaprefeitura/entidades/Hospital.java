package br.com.simulaprefeitura.entidades;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.simulaprefeitura.dto.HospitalDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "tb_hospital")
@Entity(name = "Hospital")
public class Hospital {

	public Hospital(HospitalDto dados) {
		this.nome = dados.nome();
		this.cep = dados.cep();
		this.numero = dados.numero();
	}
	
	public Hospital() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cep;
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCep() {
		return cep;
	}

	public String getNumero() {
		return numero;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	private String numero;

	@OneToMany(mappedBy = "hospital")
	@JsonIgnore
	private List<Usuario> usuarios = new ArrayList<>();
	
}
