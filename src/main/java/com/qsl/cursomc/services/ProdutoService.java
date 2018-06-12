package com.qsl.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsl.cursomc.domain.Categoria;
import com.qsl.cursomc.domain.Produto;
import com.qsl.cursomc.repositories.ProdutoRepository;
import com.qsl.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	public Produto buscar(Integer id) {
		Optional<Produto> obj = repo.findById(id);

//		return obj.orElse(null);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));

	}
	
	public List<Produto> listAll(){
		return repo.findAll();
	}

}
