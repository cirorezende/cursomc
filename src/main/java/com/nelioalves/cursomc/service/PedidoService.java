package com.nelioalves.cursomc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.repository.PedidoRepository;
import com.nelioalves.cursomc.service.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository repository;

	public Pedido find(Integer id) throws ObjectNotFoundException {
		return repository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Pedido nao encontrado. Id: " + id ) ); 
	}

}
