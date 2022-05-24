package com.residencia.firstapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.firstapi.entity.Livro;
import com.residencia.firstapi.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {
	@Autowired
	private LivroService livroService;

	@GetMapping
	public ResponseEntity<List<Livro>> findAll() {
		return new ResponseEntity<List<Livro>>(livroService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) {
		return new ResponseEntity<Livro>(livroService.findById(id), HttpStatus.OK);
	}

	@GetMapping("/nome/{livroNome}")
	public ResponseEntity<Livro> findByName(@PathVariable String livroNome) {
		return new ResponseEntity<Livro>(livroService.findByName(livroNome), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Livro> save(@RequestBody Livro livro) {
		return new ResponseEntity<Livro>(livroService.save(livro), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro livro) {
		return new ResponseEntity<Livro>(livroService.update(livro, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		livroService.delete(id);
		return new ResponseEntity<String>("Livro com id " + id + " deletado com suceeso!",
				HttpStatus.NO_CONTENT);
	}
}