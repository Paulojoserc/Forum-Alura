package com.br.alura.domain.resposta;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoResposta(

		@NotNull Long id,

		String mensagem,

		String topico,

		LocalDateTime dataAtualizacao,

		String autor,

		Boolean solucao

) {}