package br.com.simulaprefeitura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.simulaprefeitura.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByCns(Long cns);

}
