package br.com.simulaprefeitura.entidades;

import br.com.simulaprefeitura.dto.UsuarioDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Table(name = "tb_usuario",
uniqueConstraints = @UniqueConstraint(columnNames = "cns"))
@Entity(name = "Usuario")
public class Usuario {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String nome;
		private String cpf;
			
		@Column(unique = true) // Indica que cns deve ser único
		private Long cns;
		
		private String senha;
		private Integer idade;

		@ManyToOne
		@JoinColumn(name = "fk_hospital")
		private Hospital hospital;
		
		public Usuario() {
			// TODO Auto-generated constructor stub
		}
		
		public Usuario(UsuarioDto dados, Hospital hospital) {
			
			this.nome = dados.nome();
			this.cpf = dados.cpf();
			this.cns = dados.cns();
			this.senha = dados.senha();
			this.idade = dados.idade();
			this.hospital = hospital;
		}

		public Long getId() {
			return id;
		}

		public String getNome() {
			return nome;
		}

		public String getCpf() {
			return cpf;
		}

		public Long getCns() {
			return cns;
		}

		public String getSenha() {
			return senha;
		}

		public Integer getIdade() {
			return idade;
		}

		public Hospital getHospital() {
			return hospital;
		}

}
