package com.cibertec.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
public class Cliente implements Serializable {
	
	private int cod_cli;
	private String nom_cli;
	private String ape_cli;
	private String dni_cli;
	private String sexo_cli;
	private Distrito distrito;
	
	public int getCod_cli() {
		return cod_cli;
	}
	public void setCod_cli(int cod_cli) {
		this.cod_cli = cod_cli;
	}
	public String getNom_cli() {
		return nom_cli;
	}
	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
	}
	public String getApe_cli() {
		return ape_cli;
	}
	public void setApe_cli(String ape_cli) {
		this.ape_cli = ape_cli;
	}
	public String getDni_cli() {
		return dni_cli;
	}
	public void setDni_cli(String dni_cli) {
		this.dni_cli = dni_cli;
	}
	public String getSexo_cli() {
		return sexo_cli;
	}
	public void setSexo_cli(String sexo_cli) {
		this.sexo_cli = sexo_cli;
	}
	public Distrito getDistrito() {
		return distrito;
	}
	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}	
}
