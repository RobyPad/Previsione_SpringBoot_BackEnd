package com.roberto.springboot.rest.service;

import java.util.List;
import java.util.Optional;

import com.roberto.springboot.rest.model.Giocatore;

public interface ServiceGiocatore {

	public List<Giocatore> getGiocatori();
	public Optional<Giocatore> getGiocatoreById(int empid);
	public Giocatore addNewGiocatore(Giocatore emp);
	public Giocatore updateGiocatore(Giocatore emp);
	public void deleteGiocatoreById(int empid);
	public void deleteAllGiocatori();

}