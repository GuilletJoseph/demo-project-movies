package com.diginamic.movie.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ACTEUR") // creation table
public class ActeurEntity {
//column id
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore()
	private Long id;

	// column id_imdb
	@Column(name = "id_imdb")
	@JsonProperty("id")
	private String idImdb;
//column identite
	@Column(name = "identite")
	private String identite;

	// relation acteur-naissance, parce que il ya plusieurs champs
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "naissance_id", referencedColumnName = "id")
	private NaissanceEntity naissance;
	// url, height qui toujours null
	@Column(name = "url")
	private String url;

	@Column(name = "height")
	private String height;

	// relation one to many acteur-roles
	@OneToMany(mappedBy = "acteur", cascade = { CascadeType.ALL })
	private Set<RoleEntity> roles = new HashSet<>();

	// relation many to many acteur-film
	@ManyToMany(mappedBy = "castingPrincipal")
	private Set<FilmEntity> films = new HashSet<>();

	// setters et getters

	public Set<FilmEntity> getFilms() {
		return films;
	}

	public void setFilms(Set<FilmEntity> films) {
		this.films = films;
	}

	public String getIdentite() {
		return identite;
	}

	public void setIdentite(String identite) {
		this.identite = identite;
	}

	public NaissanceEntity getNaissance() {
		return naissance;
	}

	public void setNaissance(NaissanceEntity naissance) {
		this.naissance = naissance;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public Set<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdImdb() {
		return idImdb;
	}

	public void setIdImdb(String idImdb) {
		this.idImdb = idImdb;
	}

}