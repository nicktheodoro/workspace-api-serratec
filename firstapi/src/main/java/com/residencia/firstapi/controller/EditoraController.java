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

import com.residencia.firstapi.entity.Editora;
import com.residencia.firstapi.service.EditoraService;

@RestController
@RequestMapping("/editora")
public class EditoraController {
	@Autowired
	private EditoraService editoraService;

	@GetMapping
	public ResponseEntity<List<Editora>> findAll() {
		return new ResponseEntity<List<Editora>>(editoraService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Editora> findById(@PathVariable Integer id) {
		return new ResponseEntity<Editora>(editoraService.findById(id), HttpStatus.OK);
	}

	@GetMapping("/nome/{editoraNome}")
	public ResponseEntity<Editora> findByName(@PathVariable String editoraNome) {
		return new ResponseEntity<Editora>(editoraService.findByName(editoraNome), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Editora> save(@RequestBody Editora editora) {
		return new ResponseEntity<Editora>(editoraService.save(editora), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Editora> update(@PathVariable Integer id, @RequestBody Editora editora) {
		return new ResponseEntity<Editora>(editoraService.update(editora, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		editoraService.delete(id);
		return new ResponseEntity<String>("Editora com id " + id + " deletado com suceeso!",
				HttpStatus.NO_CONTENT);
	}
}