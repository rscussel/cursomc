package com.qsl.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qsl.cursomc.domain.Produto;
import com.qsl.cursomc.services.ProdutoService;

@RestController
@RequestMapping(value="/cursomc/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Produto obj = service.buscar(id);
		
		System.out.println(obj==null ? "não encontrei nada" : obj.toString());
		
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method=RequestMethod.GET)
	public List<Produto> listar() {
		
//		Produto cat1 = new Produto(1, "Informatica");
//		Produto cat2= new Produto(2, "Escritorio");
//
//		List<Produto> lista = new ArrayList<>();
//		
//		lista.add(cat1);
//		lista.add(cat2);
//		
//		System.out.println("numero cate : " + lista.size());
//		
//		Produto obj = service.buscar(1);
//		
//		System.out.println(obj==null ? "não encontrei nada" : obj.toString());
//		
//		
//		return lista;
		
//		return "REST está funfando!";
		
		return service.listAll();
	}

}
