package br.com.prestadores.prestadoresapi.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.prestadores.prestadoresapi.dto.PrestadorDTO;
import br.com.prestadores.prestadoresapi.model.Prestador;
import br.com.prestadores.prestadoresapi.repository.PrestadoresRepository;
import br.com.prestadores.prestadoresapi.repository.impl.PrestadoresRepositoryImpl;
import br.com.prestadores.prestadoresapi.service.PrestadoresService;
import br.com.prestadores.prestadoresapi.service.util.Utils;

@Service
public class PrestadoresServiceImpl implements PrestadoresService {

	PrestadoresRepository restadoresRepository;

	public PrestadoresServiceImpl() {
		this.restadoresRepository = new PrestadoresRepositoryImpl();
	}

	@Override
	public List<PrestadorDTO> obterPrestadoresSaude(Double latitude, Double longitude, String especialidade) {
		List<Prestador> prestadores = restadoresRepository.obterPrestadoresSaude(especialidade);
		List<PrestadorDTO> prestadoresDto = new ArrayList<PrestadorDTO>();
		
		prestadores.forEach(p -> {
			PrestadorDTO pDto = new PrestadorDTO();
			pDto.setNome(p.getNome());
			pDto.setEndereco(p.getEndereco());
			pDto.setLatitude(p.getLatitude());
			pDto.setLongitude(p.getLongitude());
			pDto.setDistanciaEmKm(Utils.calcularDistancia(latitude, longitude, p.getLatitude(), p.getLongitude()));
			prestadoresDto.add(pDto);
		});
		
		// Ordenando a lista
		prestadoresDto.sort(new Comparator<PrestadorDTO>() {
		    @Override
		    public int compare(PrestadorDTO p1, PrestadorDTO p2) {
		        if(p1.getDistanciaEmKm() == p2.getDistanciaEmKm()){
		            return 0;
		        }
		        return p1.getDistanciaEmKm() > p2.getDistanciaEmKm() ? 1 : -1;
		     }
		});
		
		return prestadoresDto;
	}
}
