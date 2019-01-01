package com.nelioalves.cursomc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repository.CategoriaRepository;
import com.nelioalves.cursomc.service.exception.DataIntegrityException;
import com.nelioalves.cursomc.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repository;

	public Categoria find(Integer id) throws ObjectNotFoundException {
		return repository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Categiria nao encontrada. Id: " + id ) ); 
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}

	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Page<Categoria> findPaged(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pagination = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pagination);
	}
	
}
