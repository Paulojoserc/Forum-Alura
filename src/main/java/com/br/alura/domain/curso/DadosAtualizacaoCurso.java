package com.br.alura.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCurso(

		@NotNull Long id,

		String nome,

		String categoria

) {}