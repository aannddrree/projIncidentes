package com.ccbincidentes.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_responsavel")
public class Responsavel extends Pessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5819058386682238602L;

	@ManyToOne
	private Grupo grupo;

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	
}
