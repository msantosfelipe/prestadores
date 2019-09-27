package br.com.prestadores.prestadoresapi.service;

import java.util.List;

import br.com.prestadores.prestadoresapi.dto.PrestadorDTO;

public interface PrestadoresService {

	public List<PrestadorDTO> obterPrestadoresSaude(Double latitude, Double longitude, String especialidade);
}
