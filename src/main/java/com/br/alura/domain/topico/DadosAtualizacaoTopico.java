package com.br.alura.domain.topico;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(@NotNull Long id,

		String titulo,

		String mensagem,

		LocalDateTime dataAtualizacao,

		String autor,

		String curso

) {}