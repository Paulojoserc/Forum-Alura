package com.br.alura.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.alura.domain.topico.DadosCadastroTopico;
import com.br.alura.domain.topico.Topico;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")

public class TopicoController {

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroTopico dados) {
		repository.save(new Topico(dados));
	}
}
