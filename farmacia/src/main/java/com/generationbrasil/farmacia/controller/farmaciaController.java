package com.generationbrasil.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.postagem;
import com.generation.blogpessoal.repository.postagemRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class farmaciaController {

			@Autowired
			private produtoRepository repository;
			
			@GetMapping
			public ResponseEntity<List<produto>> GetAll(){
				return ResponseEntity.ok(repository.findAll());
			}
			
			@GetMapping("/{id}")
			public ResponseEntity<produto> GetById(@PathVariable long id){
				return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
			}
			
			@GetMapping("/titulo/{titulo}")
			public ResponseEntity<List<produto> GetByTitulo(@PathVariable String titulo) {
				return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
			}
			
			@PostMapping
			public ResponseEntity<postagem> post (@RequestBody postagem Postagem) {
				return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(Postagem));
			}
			
			
			@PutMapping
			public ResponseEntity<postagem> put (@RequestBody postagem Postagem) {
				return ResponseEntity.status(HttpStatus.OK).body(repository.save(Postagem));
			}
			
			@DeleteMapping("/{id}")
			public void delete(@PathVariable long id) {
				repository.deleteById(id);
			}
			
			
			
	}

}
