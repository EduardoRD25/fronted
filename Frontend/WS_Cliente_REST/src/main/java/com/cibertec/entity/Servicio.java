package com.cibertec.entity;
import java.io.Serializable;

public class Servicio implements Serializable {
	
	private int cod_ser;
	private String nom_ser;
	private String pre_ser;
	private String desc_ser;
	private String horio_ser;
	private String fec_ser;
	
	public int getCod_ser() {
		return cod_ser;
	}
	public void setCod_ser(int cod_ser) {
		this.cod_ser = cod_ser;
	}
	public String getNom_ser() {
		return nom_ser;
	}
	public void setNom_ser(String nom_ser) {
		this.nom_ser = nom_ser;
	}
	public String getPre_ser() {
		return pre_ser;
	}
	public void setPre_ser(String pre_ser) {
		this.pre_ser = pre_ser;
	}
	public String getDesc_ser() {
		return desc_ser;
	}
	public void setDesc_ser(String desc_ser) {
		this.desc_ser = desc_ser;
	}
	public String getHorio_ser() {
		return horio_ser;
	}
	public void setHorio_ser(String horio_ser) {
		this.horio_ser = horio_ser;
	}
	public String getFec_ser() {
		return fec_ser;
	}
	public void setFec_ser(String fec_ser) {
		this.fec_ser = fec_ser;
	}	
}
