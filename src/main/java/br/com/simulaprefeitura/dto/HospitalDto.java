package br.com.simulaprefeitura.dto;

import br.com.simulaprefeitura.entidades.Hospital;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HospitalDto( 
	
	
     Long id,
            
     @NotNull
     @NotBlank
     String nome,
     
     @NotNull
     @NotBlank
     String cep,
     
     @NotNull
     @NotBlank
     String numero
     
  
     ) {

	public HospitalDto(Hospital hospital) {
		this(hospital.getId(), hospital.getNome(), hospital.getCep(), hospital.getNumero());
	}
}
