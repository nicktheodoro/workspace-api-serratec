package com.residencia.firstapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "livro_id")
	private Integer livroId;

	@Column(name = "livro_nome")
	private String livroNome;

	@ManyToOne
	@JoinColumn(name = "editora_id", referencedColumnName = "editora_id")
	private Editora editora;

	@ManyToOne
	@JoinColumn(name = "autor_id", referencedColumnName = "autor_id")
	private Autor autor;

	public Livro() {

	}

	public Livro(Integer livroId, String livroNome, Editora editora, Autor autor) {
		this.livroId = livroId;
		this.livroNome = livroNome;
		this.editora = editora;
		this.autor = autor;
	}

	public Integer getLivroId() {
		return livroId;
	}

	public void setLivroId(Integer livroId) {
		this.livroId = livroId;
	}

	public String getLivroNome() {
		return livroNome;
	}

	public void setLivroNome(String livroNome) {
		this.livroNome = livroNome;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
