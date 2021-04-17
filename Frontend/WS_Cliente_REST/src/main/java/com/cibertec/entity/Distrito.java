package com.cibertec.entity;
import java.io.Serializable;
public class Distrito implements Serializable{
	
	private int cod_dis;
	private String nom_dis;
	
	public int getCod_dis() {
		return cod_dis;
	}
	public void setCod_dis(int cod_dis) {
		this.cod_dis = cod_dis;
	}
	public String getNom_dis() {
		return nom_dis;
	}
	public void setNom_dis(String nom_dis) {
		this.nom_dis = nom_dis;
	}
	
}



