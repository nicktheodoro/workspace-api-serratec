package com.residencia.firstapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.firstapi.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
	Livro findByLivroNome(String livroNome);
}