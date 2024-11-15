package br.edu.ifpb.pweb2.bitbank.service;

import br.edu.ifpb.pweb2.bitbank.model.Correntista;
import br.edu.ifpb.pweb2.bitbank.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CorrentistaService  implements Service<Correntista, Integer>{

    @Autowired
    private CorrentistaRepository correntistaRepository;

    @Override
    public List<Correntista> findAll() {
        return CorrentistaRepository.findAll();
    }

    @Override
    public Correntista findById(Integer integer) {
        return correntistaRepository.findById(integer);
    }

    @Override
    public Correntista save(Correntista correntista) {
        return correntistaRepository.save(correntista);
    }
}
