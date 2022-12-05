package com.diginamic.movie.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "FILM") // creation table
public class FilmEntity {

	// creation id
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// creation id_imdb
	@Column(name = "id_imdb")
	private String idImdb;

	// ... nom, url, plot
	@Column(name = "nom")
	private String nom;

	@Column(name = "url")
	private String url;

	@Column(name = "plot")
	private String plot;

	// langue
	@Column(name = "langue")
	private String langue;

	// ignore creation column lieu turnage
	@Transient
	private LieuTournageEntity lieuTournage;

	// relation many to many film-lieu tournage
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "FILM_LIEUTOURNAGE", joinColumns = { @JoinColumn(name = "id_film") }, inverseJoinColumns = {
			@JoinColumn(name = "id_lieutournage") })
	private Set<LieuTournageEntity> lstLieuTurnage = new HashSet<>();

	// relation many to one film-pays, parce que le ligne table est toujuors une
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "pays")
	private PaysEntity pays;

	// relation many to many film-genres
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "FILM_GENRE", joinColumns = { @JoinColumn(name = "id_film") }, inverseJoinColumns = {
			@JoinColumn(name = "id_genre") })
	private List<GenreEntity> lstGenres = new ArrayList<>();

	// relation many to many film-realisateurs
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "FILM_REAlISATEUR", joinColumns = { @JoinColumn(name = "id_film") }, inverseJoinColumns = {
			@JoinColumn(name = "id_realisateur") })
	private Set<Realisateur> realisateurs = new HashSet<>();

	// relation many to many film-caasting principal
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "FILM_CASTINGPRINCIPAL", joinColumns = { @JoinColumn(name = "id_film") }, inverseJoinColumns = {
			@JoinColumn(name = "id_acteur") })
	private Set<ActeurEntity> castingPrincipal = new HashSet<>();

	// column annee sortie
	@Column(name = "anne_sortie")
	private String anneeSortie;

//ignore column genres
	@JsonProperty("genres")
	@Transient
	private String[] genres;

//relation many to many film-roles
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "FILM_ROLE", joinColumns = { @JoinColumn(name = "id_film") }, inverseJoinColumns = {
			@JoinColumn(name = "id_role") })
	private Set<RoleEntity> roles = new HashSet<>();

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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public LieuTournageEntity getLieuTournage() {
		return lieuTournage;
	}

	public void setLieuTournage(LieuTournageEntity lieuTournage) {
		this.lieuTournage = lieuTournage;
	}

	public Set<LieuTournageEntity> getLstLieuTurnage() {
		return lstLieuTurnage;
	}

	public void setLstLieuTurnage(Set<LieuTournageEntity> lstLieuTurnage) {
		this.lstLieuTurnage = lstLieuTurnage;
	}

	public PaysEntity getPays() {
		return pays;
	}

	public void setPays(PaysEntity pays) {
		this.pays = pays;
	}

	public List<GenreEntity> getLstGenres() {
		return lstGenres;
	}

	public void setLstGenres(List<GenreEntity> lstGenres) {
		this.lstGenres = lstGenres;
	}

	public Set<Realisateur> getRealisateurs() {
		return realisateurs;
	}

	public void setRealisateurs(Set<Realisateur> realisateurs) {
		this.realisateurs = realisateurs;
	}

	public Set<ActeurEntity> getCastingPrincipal() {
		return castingPrincipal;
	}

	public void setCastingPrincipal(Set<ActeurEntity> castingPrincipal) {
		this.castingPrincipal = castingPrincipal;
	}

	public String getAnneeSortie() {
		return anneeSortie;
	}

	public void setAnneeSortie(String anneeSortie) {
		this.anneeSortie = anneeSortie;
	}

	public String[] getGenres() {
		return genres;
	}

	public void setGenres(String[] genres) {
		this.genres = genres;
	}

	public Set<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}

//setters et getters	


}