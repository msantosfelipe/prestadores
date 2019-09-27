package br.com.prestadores.prestadoresapi.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.prestadores.prestadoresapi.controller.PrestadoresController;
import br.com.prestadores.prestadoresapi.dto.PrestadorDTO;
import br.com.prestadores.prestadoresapi.service.PrestadoresService;

@RestController
public class PrestadoresControllerImpl implements PrestadoresController {

	@Autowired
	private PrestadoresService prestadoresService;

	@Override
	public ResponseEntity<List<PrestadorDTO>> obterPrestadoresSaude(Double latitude, Double longitude,
			String especialidade) {
		List<PrestadorDTO> lista = prestadoresService.obterPrestadoresSaude(latitude, longitude, especialidade);

		if (lista == null || lista.isEmpty()) {
			return new ResponseEntity<List<PrestadorDTO>>(lista, HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<PrestadorDTO>>(lista, HttpStatus.OK);
	}

}
