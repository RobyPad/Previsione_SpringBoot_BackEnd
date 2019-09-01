package com.roberto.springboot.rest.service;

import java.util.List;
import java.util.Optional;

import com.roberto.springboot.rest.model.Partita;

public interface ServicePartita {

	public List<Partita> getPartite();
	public Optional<Partita> getPartitaById(int IdPartita);
	public Partita addNewPartita(Partita partita);
	public Partita updatePartita(Partita partita);
	public void deletePartitaById(int IdPartita);
	public void deleteAllPartite();

}