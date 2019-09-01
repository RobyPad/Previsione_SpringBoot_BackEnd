package com.roberto.springboot.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.springboot.rest.dao.GiocatoreDaoRepository;
import com.roberto.springboot.rest.model.Giocatore;

@Service
public class ServiceGiocatoreImpl implements ServiceGiocatore {

	@Autowired
	GiocatoreDaoRepository dao;

	@Override
	public List<Giocatore> getGiocatori() {
		return dao.findAll();
	}
	@Override
	public Optional<Giocatore> getGiocatoreById(int empid) {
		return dao.findById(empid);
	}
	@Override
	public Giocatore addNewGiocatore(Giocatore emp) {
		return dao.save(emp);
	}
	@Override
	public Giocatore updateGiocatore(Giocatore emp) {
		return dao.save(emp);
	}
	@Override
	public void deleteGiocatoreById(int empid) {
		dao.deleteById(empid);
	}
	@Override
	public void deleteAllGiocatori() {
		dao.deleteAll();
	}
}