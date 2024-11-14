package br.edu.ifpb.pweb2.bitbank;

import br.edu.ifpb.pweb2.bitbank.controller.CorrentistaController;
import br.edu.ifpb.pweb2.bitbank.model.Correntista;
import br.edu.ifpb.pweb2.bitbank.service.CorrentistaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BitbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitbankApplication.class, args);
	}

}
