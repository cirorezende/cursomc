package com.nelioalves.cursomc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repository.CategoriaRepository;
import com.nelioalves.cursomc.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repository;

	public Categoria get(Integer id) throws ObjectNotFoundException {
		return repository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Categiria nao encontrada. Id: " + id ) ); 
	}

	public Categoria insert(Categoria obj) {
		return repository.save(obj);
	}

}
