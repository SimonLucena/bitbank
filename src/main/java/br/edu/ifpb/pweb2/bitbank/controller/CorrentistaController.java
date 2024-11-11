package br.edu.ifpb.pweb2.bitbank.controller;

import br.edu.ifpb.pweb2.bitbank.model.Correntista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import br.edu.ifpb.pweb2.bitbank.repository.CorrentistaRepository;

@Controller
@RequestMapping("/correntistas")
public class CorrentistaController {
    @Autowired
    private CorrentistaRepository correntistaRepository;

    @RequestMapping("/form")
    public String getForm(Correntista correntista, Model model) {
        model.addAttribute("correntista", correntista);
        return "correntistas/form";
    }

//    @RequestMapping("/form")
//    public String getForm(Correntista correntista, Model model) {
//        model.addAttribute("correntista", correntista);
//        return "correntistas/form";
//    }

    @RequestMapping("/lista")
    public String getList(Model model) {
        model.addAttribute("correntistas", correntistaRepository.findAll());
        return "correntistas/list";
    }

    @RequestMapping("/save")
    public String save(Correntista correntista, Model model) {
        if(correntista.getNome() == null || correntista.getNome().isEmpty()) {
            model.addAttribute("error", "Nome é obrigatório.");
            return "correntistas/form";
        }
        if(correntista.getEmail() == null || correntista.getEmail().isEmpty()) {
            model.addAttribute("error", "Email é obrigatório.");
            return "correntistas/form";
        }
        if(correntista.getSenha() == null || correntista.getSenha().isEmpty()) {
            model.addAttribute("error", "Senha é obrigatória.");
            return "correntistas/form";
        }
        if(correntista.getNome().length()>=50){
            model.addAttribute("error", "O nome deve ter menos de 50 caracteres");
            return "correntistas/form";
        }
        if(correntistaRepository.findByEmail(correntista.getEmail())){
            model.addAttribute("error", "Email já cadastrado");
            return "correntistas/form";
        }
        correntistaRepository.save(correntista);

        model.addAttribute("correntistas", correntistaRepository.findAll());
        return "correntistas/list";
    }
}