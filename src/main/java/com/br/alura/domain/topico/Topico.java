package com.br.alura.domain.topico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.br.alura.domain.curso.Curso;
import com.br.alura.modelo.Resposta;
import com.br.alura.modelo.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String titulo;
	@Column(unique = true)
	private String mensagem;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
	@ManyToOne
    @JoinColumn(name = "autor_id")
	private Usuario autor;
	@ManyToOne
    @JoinColumn(name = "curso_id")
	private Curso curso;
	@JsonIgnore
	@OneToMany(mappedBy = "topico", fetch = FetchType.LAZY)
	private List<Resposta> respostas = new ArrayList<>();

	public Topico(String titulo, String mensagem, Usuario autor, Curso curso) {
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.autor = autor;
		this.curso = curso;
	}
	
	public void atualizarInformacoes(DadosAtualizacaoTopico dados, Usuario autor, Curso curso) {

		if (dados.titulo() != null) {

			this.titulo = dados.titulo();

		}

		if (dados.mensagem() != null) {

			this.mensagem = dados.mensagem();

		}

		if (dados.dataAtualizacao() != null) {

			this.dataCriacao = dados.dataAtualizacao();

		}

		if (autor != null) {

			this.autor = autor;

		}

		if (curso != null) {

			this.curso = curso;

		}

	}

	

	public void adicionarResposta(Resposta resposta) {

		resposta.setTopico(this);
		this.respostas.add(resposta);

	}

}
