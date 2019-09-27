package br.com.prestadores.prestadoresapi.repository;

import java.util.List;

import br.com.prestadores.prestadoresapi.model.Prestador;

public interface PrestadoresRepository {

	public List<Prestador> obterPrestadoresSaude(String especialidade);

}
