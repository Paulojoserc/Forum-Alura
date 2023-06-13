package com.br.alura.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(

		@NotBlank(message = "Nome é obrigatório") String nome,

		@NotBlank(message = "Email é obrigatório") String email,

		@NotBlank(message = "Senha é obrigatorio") String senha

) {}