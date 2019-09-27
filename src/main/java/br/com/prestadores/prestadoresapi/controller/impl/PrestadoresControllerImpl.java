package br.com.prestadores.prestadoresapi.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.prestadores.prestadoresapi.controller.PrestadoresController;
import br.com.prestadores.prestadoresapi.dto.PrestadorDTO;
import br.com.prestadores.prestadoresapi.service.PrestadoresService;

@RestController
public class PrestadoresControllerImpl implements PrestadoresController {

	@Autowired
	private PrestadoresService prestadoresService;

	@Override
	public List<PrestadorDTO> obterPrestadoresSaude(Double latitude, Double longitude, String especialidade) {
		List<PrestadorDTO> lista = prestadoresService.obterPrestadoresSaude(latitude, longitude, especialidade);
		
		return lista;
	}

}
