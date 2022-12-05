package com.diginamic.movie.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "LIEU_TOURNAGE")
public class LieuTournageEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore()
	private Long id;

	@Column(name = "ville")
	private String ville;

	@Column(name = "etat_dept")
	private String etatDept;

	@Column(name = "pays")
	private String pays;

	@ManyToMany(mappedBy = "lstLieuTurnage")
	private Set<FilmEntity> lstLieuTurnage = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getEtatDept() {
		return etatDept;
	}

	public void setEtatDept(String etatDept) {
		this.etatDept = etatDept;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Set<FilmEntity> getLstLieuTurnage() {
		return lstLieuTurnage;
	}

	public void setLstLieuTurnage(Set<FilmEntity> lstLieuTurnage) {
		this.lstLieuTurnage = lstLieuTurnage;
	}

}
