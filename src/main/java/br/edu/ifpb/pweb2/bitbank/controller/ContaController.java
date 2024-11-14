package br.edu.ifpb.pweb2.bitbank.controller;

import br.edu.ifpb.pweb2.bitbank.model.Conta;
import br.edu.ifpb.pweb2.bitbank.model.Correntista;
import br.edu.ifpb.pweb2.bitbank.repository.CorrentistaRepository;
import br.edu.ifpb.pweb2.bitbank.service.ContaService;
import br.edu.ifpb.pweb2.bitbank.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    ContaService contaService;
    @Autowired
    private CorrentistaService correntistaService;

    @RequestMapping("/form")
    public ModelAndView getForm(ModelAndView modelAndView){
        modelAndView.setViewName("contas/form");
        modelAndView.addObject("conta", new Conta(new Correntista()));
        return modelAndView;
    }

    @RequestMapping("/list")
    public String listAll(Model model){
        model.addAttribute("conta", contaService.findAll());
        return "contas/list";
    }

    @ModelAttribute("correntistaItems")
    public List<Correntista> getCorrentistas(){
        return CorrentistaRepository.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView adicioneConta(Conta conta, ModelAndView modelAndView, Model model){
        contaService.save(conta);
        modelAndView.setViewName("contas/list");
        modelAndView.addObject("contas", contaService.findAll());
//        modelAndView.addObject("correntistas", correntistaService.findAll());
        return modelAndView;
    }
}
