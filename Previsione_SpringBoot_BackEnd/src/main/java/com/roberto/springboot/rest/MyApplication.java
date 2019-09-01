package com.roberto.springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.roberto.caricamento.dati.CaricaPartite;
import com.roberto.springboot.rest.dao.PartitaDaoRepository;
import com.roberto.springboot.rest.model.Partita;

@SpringBootApplication
public class MyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}
	
	
}


@Component
class DemoCommandLineRunner implements CommandLineRunner
{

	@Autowired
	private PartitaDaoRepository repository;

	@Override
	public void run(String... args) throws Exception 
	{

		/*
		 * Italia
		 */
		String url_italia = "https://www.diretta.it/serie-a-2016-2017/";
		String href_italia = "//a[@href='/serie-a-2016-2017/risultati/']";
		
		CaricaPartite o = new CaricaPartite();

		List<Partita> lista = o.caricaCampionato3(url_italia, href_italia);
		
		for (Partita p : lista) 
		{
			repository.save(p);
		}

	}
}
