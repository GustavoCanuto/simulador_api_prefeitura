package br.com.simulaprefeitura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.simulaprefeitura.entidades.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
