package br.edu.ifpb.pweb2.bitbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String showHomePage() {
        return "index";
    }

//    @RequestMapping("/list")
//    public String showCorrentistaList() { return "correntistas/list"; }
}
