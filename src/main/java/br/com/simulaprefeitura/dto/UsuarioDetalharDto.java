package br.com.simulaprefeitura.dto;

import br.com.simulaprefeitura.entidades.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioDetalharDto(
		
		 @NotNull
	     Long id,
	     
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
	     @NotBlank
	     Integer idade
		
		) {

	public UsuarioDetalharDto(Usuario usuario) {
		this(usuario.getId() ,usuario.getCns(), usuario.getCpf(), usuario.getNome(),  usuario.getSenha(),usuario.getIdade());
	}
}
