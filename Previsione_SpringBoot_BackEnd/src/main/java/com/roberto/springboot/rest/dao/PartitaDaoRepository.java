package com.roberto.springboot.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roberto.springboot.rest.model.Partita;

@Repository
public interface PartitaDaoRepository extends JpaRepository<Partita, Integer> {

}