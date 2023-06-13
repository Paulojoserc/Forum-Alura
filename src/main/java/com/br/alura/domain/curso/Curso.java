package com.br.alura.domain.curso;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String categoria;


	public Curso(String nome, String categoria) {
		this.nome = nome;
		this.categoria = categoria;
	}
	
	public void atualizarInformacoes(@Valid DadosAtualizacaoCurso dados) {

		if (dados.nome() != null) {

			this.nome = dados.nome();

		}

		if (dados.categoria() != null) {

			this.categoria = dados.categoria();

		}
	

}
}