package com.nelioalves.cursomc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.repository.ClienteRepository;
import com.nelioalves.cursomc.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repository;

	public Cliente find(Integer id) throws ObjectNotFoundException {
		return repository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Cliente nao encontrado. Id: " + id ) ); 
	}

}
