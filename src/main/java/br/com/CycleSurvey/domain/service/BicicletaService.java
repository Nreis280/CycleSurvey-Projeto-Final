package br.com.CycleSurvey.domain.service;

import br.com.CycleSurvey.domain.entity.Bicicleta;
import br.com.CycleSurvey.domain.repository.BicicletaRepository;

import java.util.List;

public class BicicletaService implements Service<Bicicleta, Long>{

    private BicicletaRepository repo = BicicletaRepository.build();

    @Override
    public List<Bicicleta> findAll() {
        return repo.findAll();
    }

    @Override
    public Bicicleta findById(Long id) {
        return repo.findById( id );
    }


    @Override
    public Bicicleta persiste(Bicicleta bc) {
        return repo.persiste( bc );
    }
}