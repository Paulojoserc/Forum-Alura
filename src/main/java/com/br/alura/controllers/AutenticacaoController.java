package com.br.alura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.alura.domain.usuario.DadosAutenticacao;
import com.br.alura.domain.usuario.Usuario;
import com.br.alura.infra.security.DadosTokenJWT;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {

		var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
		var authentication = manager.authenticate(authenticationToken);
		var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

		return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));

	}

}