package com.roberto.springboot.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.roberto.springboot.rest.model.Partita;
import com.roberto.springboot.rest.service.ServicePartita;

@RestController
public class PartitaController {

	@Autowired
	ServicePartita service;

	@RequestMapping(value= "/partita/all", method= RequestMethod.GET)
	public List<Partita> getPartite() {
		System.out.println(this.getClass().getSimpleName() + " - Get all partite service is invoked.");
		return service.getPartite();
	}

	@RequestMapping(value= "/partita/{id}", method= RequestMethod.GET)
	public Partita getPartitaById(@PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Get partita details by id is invoked.");

		Optional<Partita> emp =  service.getPartitaById(id);
		if(!emp.isPresent())
			throw new Exception("Could not find partita with id- " + id);

		return emp.get();
	}

	@RequestMapping(value= "/partita/add", method= RequestMethod.POST)
	public Partita createPartita(@RequestBody Partita newemp) {
		System.out.println(this.getClass().getSimpleName() + " - Create new partita method is invoked.");
		return service.addNewPartita(newemp);
	}
	

    public void insertPartite(List<Partita> partite) 
	{        

    	for (Partita p : partite) 
		{
    		service.addNewPartita(p);
		}
    	
    }


/*
	@RequestMapping(value= "/partita/update/{id}", method= RequestMethod.PUT)
	public Partita updatePartita(@RequestBody Partita updemp, @PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Update partita details by id is invoked.");

		Optional<Partita> emp =  service.getPartitaById(id);
		if (!emp.isPresent())
			throw new Exception("Could not find partita with id- " + id);
	
		if(updemp.getName() == null || updemp.getName().isEmpty())
			updemp.setName(emp.get().getName());
		if(updemp.getDepartment() == null || updemp.getDepartment().isEmpty())
			updemp.setDepartment(emp.get().getDepartment());
		if(updemp.getSalary() == 0)
			updemp.setSalary(emp.get().getSalary());

		// Required for the "where" clause in the sql query template.
		updemp.setId(id);
		return service.updatePartita(updemp);
	}

*/

	@RequestMapping(value= "/partita/delete/{id}", method= RequestMethod.DELETE)
	public void deletePartitaById(@PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Delete partita by id is invoked.");

		Optional<Partita> emp =  service.getPartitaById(id);
		if(!emp.isPresent())
			throw new Exception("Could not find partita with id- " + id);

		service.deletePartitaById(id);
	}

	@RequestMapping(value= "/partita/deleteall", method= RequestMethod.DELETE)
	public void deleteAll() {
		System.out.println(this.getClass().getSimpleName() + " - Delete all partite is invoked.");
		service.deleteAllPartite();
	}
}