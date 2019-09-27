package br.com.prestadores.prestadoresapi.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.prestadores.prestadoresapi.model.Prestador;
import br.com.prestadores.prestadoresapi.repository.PrestadoresRepository;
import br.com.prestadores.prestadoresapi.repository.enums.EspecialidadeEnum;

public class PrestadoresRepositoryImpl implements PrestadoresRepository {
	
	private List<Prestador> prestadores;
	
	public PrestadoresRepositoryImpl() {
		popularPrestadores();
	}

	@Override
	public List<Prestador> obterPrestadoresSaude(String especialidade) {
		Stream<Prestador> stream = prestadores.stream().filter(p -> p.getEspecialidades().contains(especialidade));
		return stream.collect(Collectors.toList());
	}

	private void popularPrestadores() {
		prestadores = new ArrayList<Prestador>();
		
		for (int i = 0; i < 20; i++) {
			Prestador p = new Prestador();
			p.setNome("Nome " + i);
			p.setEndereco("Endereço " + i);
			p.setLatitude(30.1234 - (i * 2));
			p.setLongitude(-30.1234 + (i * 2));
			
			// Adidionando especialidades
			List<String> especialidades = new ArrayList<String>();
			especialidades.add(EspecialidadeEnum.randomEnum());
			if (i % 5 == 0) {
				especialidades.add(EspecialidadeEnum.randomEnum());
			}
			p.setEspecialidades(especialidades);
			prestadores.add(p);
		}
		
	}
}
