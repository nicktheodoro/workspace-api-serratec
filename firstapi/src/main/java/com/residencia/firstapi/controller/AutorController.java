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

import com.residencia.firstapi.entity.Autor;
import com.residencia.firstapi.service.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorService autorService;

	@GetMapping
	public ResponseEntity<List<Autor>> findAll() {
		return new ResponseEntity<List<Autor>>(autorService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Autor> findById(@PathVariable Integer id) {
		return new ResponseEntity<Autor>(autorService.findById(id), HttpStatus.OK);
	}

	@GetMapping("/nome/{nomeAutor}")
	public ResponseEntity<Autor> findByName(@PathVariable String nomeAutor) {
		return new ResponseEntity<Autor>(autorService.findByName(nomeAutor), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Autor> save(@RequestBody Autor autor) {
		return new ResponseEntity<Autor>(autorService.save(autor), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Autor> update(@PathVariable Integer id, @RequestBody Autor autor) {
		return new ResponseEntity<Autor>(autorService.update(autor, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		autorService.delete(id);
		return new ResponseEntity<String>("Autor com id " + id + " deletado com suceeso!",
				HttpStatus.NO_CONTENT);
	}
}
