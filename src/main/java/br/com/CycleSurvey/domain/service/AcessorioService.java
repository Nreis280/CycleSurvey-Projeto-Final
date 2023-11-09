package br.com.CycleSurvey.domain.service;

import br.com.CycleSurvey.domain.entity.Acessorio;
import br.com.CycleSurvey.domain.repository.AcessorioRepository;

import java.util.List;

public class AcessorioService implements Service <Acessorio, Long>{

    private AcessorioRepository repo = AcessorioRepository.build();

    @Override
    public List<Acessorio> findAll() {
        return repo.findAll();
    }

    @Override
    public Acessorio findById(Long id) {
        return repo.findById( id );
    }


    @Override
    public Acessorio persiste(Acessorio ac) {
        return repo.persiste( ac );
    }

}