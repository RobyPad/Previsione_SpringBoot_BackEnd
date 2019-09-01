package com.roberto.springboot.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.springboot.rest.dao.PartitaDaoRepository;
import com.roberto.springboot.rest.model.Partita;

@Service
public class ServicePartitaImpl implements ServicePartita{

	@Autowired
	PartitaDaoRepository dao;

	@Override
	public List<Partita> getPartite() {
		return dao.findAll();
	}
	@Override
	public Optional<Partita> getPartitaById(int IdPartita) {
		return dao.findById(IdPartita);
	}
	@Override
	public Partita addNewPartita(Partita partita) {
		return dao.save(partita);
	}
	@Override
	public Partita updatePartita(Partita partita) {
		return dao.save(partita);
	}
	@Override
	public void deletePartitaById(int IdPartita) {
		dao.deleteById(IdPartita);
	}
	@Override
	public void deleteAllPartite() {
		dao.deleteAll();
	}
}