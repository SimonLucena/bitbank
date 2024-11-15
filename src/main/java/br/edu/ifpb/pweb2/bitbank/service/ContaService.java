package br.edu.ifpb.pweb2.bitbank.service;

import br.edu.ifpb.pweb2.bitbank.model.Conta;
import br.edu.ifpb.pweb2.bitbank.model.Correntista;
import br.edu.ifpb.pweb2.bitbank.repository.ContaRepository;
import br.edu.ifpb.pweb2.bitbank.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContaService implements Service<Conta, Integer> {
    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    @Override
    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

    @Override
    public Conta findById(Integer integer) {
        return contaRepository.findById(integer);
    }

    @Override
    public Conta save(Conta conta) {
        if(conta.getCorrentista() != null){
            Correntista correntista = correntistaRepository.findById(conta.getCorrentista().getId());
            conta.setCorrentista(correntista);
        }else{
            conta.setCorrentista(null);
        }
        return contaRepository.save(conta);
    }
}
