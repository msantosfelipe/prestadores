package br.com.prestadores.prestadoresapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.prestadores.prestadoresapi.dto.PrestadorDTO;

@RequestMapping(value = "/api/v1/prestadores")
public interface PrestadoresController {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PrestadorDTO>> obterPrestadoresSaude(
			@RequestParam("latitude") Double latitude,
			@RequestParam("longitude") Double longitude,
			@RequestParam("especialidade") String especialidade);

}
