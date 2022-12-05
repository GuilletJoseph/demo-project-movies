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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

//faux json responsable java class )))
public class CastingPrincipalEntity {

	@JsonIgnore()
	private Long id;

	@JsonIgnore
	private String idimdb;

	@JsonIgnore
	private String identite;

	@JsonIgnore
	private NaissanceEntity naissance;

	@JsonIgnore
	private String url;

	@JsonIgnore
	private String height;

	@JsonIgnore
	private Set<RoleEntity> roles = new HashSet<>();
	// pas de setters et getters
}