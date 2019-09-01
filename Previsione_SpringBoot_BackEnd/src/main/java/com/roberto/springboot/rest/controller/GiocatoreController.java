package com.roberto.springboot.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.roberto.springboot.rest.model.Giocatore;
import com.roberto.springboot.rest.service.ServiceGiocatore;

@RestController
public class GiocatoreController {

	@Autowired
	ServiceGiocatore service;

	@RequestMapping(value= "/giocatore/all", method= RequestMethod.GET)
	public List<Giocatore> getGiocatori() {
		System.out.println(this.getClass().getSimpleName() + " - Get all giocatori service is invoked.");
		return service.getGiocatori();
	}

	@RequestMapping(value= "/giocatore/{id}", method= RequestMethod.GET)
	public Giocatore getGiocatoreById(@PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Get giocatore details by id is invoked.");

		Optional<Giocatore> emp =  service.getGiocatoreById(id);
		if(!emp.isPresent())
			throw new Exception("Could not find giocatore with id- " + id);

		return emp.get();
	}

	@RequestMapping(value= "/giocatore/add", method= RequestMethod.POST)
	public Giocatore createGiocatore(@RequestBody Giocatore newemp) {
		System.out.println(this.getClass().getSimpleName() + " - Create new giocatore method is invoked.");
		return service.addNewGiocatore(newemp);
	}

/*
	@RequestMapping(value= "/giocatore/update/{id}", method= RequestMethod.PUT)
	public Giocatore updateGiocatore(@RequestBody Giocatore updemp, @PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Update giocatore details by id is invoked.");

		Optional<Giocatore> emp =  service.getGiocatoreById(id);
		if (!emp.isPresent())
			throw new Exception("Could not find giocatore with id- " + id);
	
		if(updemp.getName() == null || updemp.getName().isEmpty())
			updemp.setName(emp.get().getName());
		if(updemp.getDepartment() == null || updemp.getDepartment().isEmpty())
			updemp.setDepartment(emp.get().getDepartment());
		if(updemp.getSalary() == 0)
			updemp.setSalary(emp.get().getSalary());

		// Required for the "where" clause in the sql query template.
		updemp.setId(id);
		return service.updateGiocatore(updemp);
	}

*/

	@RequestMapping(value= "/giocatore/delete/{id}", method= RequestMethod.DELETE)
	public void deleteGiocatoreById(@PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Delete giocatore by id is invoked.");

		Optional<Giocatore> emp =  service.getGiocatoreById(id);
		if(!emp.isPresent())
			throw new Exception("Could not find giocatore with id- " + id);

		service.deleteGiocatoreById(id);
	}

	@RequestMapping(value= "/giocatore/deleteall", method= RequestMethod.DELETE)
	public void deleteAll() {
		System.out.println(this.getClass().getSimpleName() + " - Delete all giocatores is invoked.");
		service.deleteAllGiocatori();
	}
}