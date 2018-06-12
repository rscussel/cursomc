package com.qsl.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qsl.cursomc.domain.Categoria;
import com.qsl.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/cursomc/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		
		System.out.println(obj==null ? "não encontrei nada" : obj.toString());
		
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		
		Categoria cat1 = new Categoria(1, "Informatica");
		Categoria cat2= new Categoria(2, "Escritorio");

		List<Categoria> lista = new ArrayList<>();
		
		lista.add(cat1);
		lista.add(cat2);
		
		System.out.println("numero cate : " + lista.size());
		
		Categoria obj = service.buscar(1);
		
		System.out.println(obj==null ? "não encontrei nada" : obj.toString());
		
		
		return lista;
		
//		return "REST está funfando!";
	}

}
