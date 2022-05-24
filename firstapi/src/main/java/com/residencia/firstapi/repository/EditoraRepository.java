package com.residencia.firstapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.firstapi.entity.Editora;

public interface EditoraRepository extends JpaRepository<Editora, Integer> {
	Editora findByEditoraNome(String editoraNome);
}