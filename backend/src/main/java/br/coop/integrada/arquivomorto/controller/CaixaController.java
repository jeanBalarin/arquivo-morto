package br.coop.integrada.arquivomorto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/caixas")
public class CaixaController {
	
	@GetMapping
	public String listar() {
		return "All Caixas";
	}
}
