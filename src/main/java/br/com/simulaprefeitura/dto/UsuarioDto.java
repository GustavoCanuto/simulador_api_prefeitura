package br.com.simulaprefeitura.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioDto(
		
		
		 @NotNull
	     Long cns,
	            
	     @NotNull
	     @NotBlank
	     String cpf,
	     
	     @NotNull
	     @NotBlank
	     String nome,
	     
	     @NotNull
	     @NotBlank
	     String senha,
	     
	     @NotNull
	     Integer idade,
	     

		 @NotNull
	     Long idHospital
	     
	     
		) {
	

}
