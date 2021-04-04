package models;

import java.util.Date;

import models.DBConverter.DBTable;

public class Artigo 
{
	@DBTable(nomeColuna ="id")
	private String uid;
	
	@DBTable(nomeColuna ="descricao")
	private String descricao;
	
	@DBTable(nomeColuna ="marca")
	private String marca;
	
	@DBTable(nomeColuna ="modelo")
	private String modelo;
	
	@DBTable(nomeColuna ="numImobilizado")
	private String numImobilizado;
	
	@DBTable(nomeColuna ="numSerie")
	private String numSerie;
	
	@DBTable(nomeColuna ="localStock")
	private String localStock;
	
	@DBTable(nomeColuna ="obs")
	private String obs;
	
	@DBTable(nomeColuna ="dataCriacao")
	private Date dataCriacao;
	
	@DBTable(nomeColuna ="FK_IdUtilizador")
	private String fkIdUtilizador;
	
	@DBTable(nomeColuna ="FK_IdTipoArtigo")
	private String fkIdTipoArtigo;
	
	@DBTable(nomeColuna ="FK_IdEstado")
	private String fkIdEstado;
	
	
	//Getters and setters
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getNumImobilizado() {
		return numImobilizado;
	}
	public void setNumImobilizado(String numImobilizado) {
		this.numImobilizado = numImobilizado;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public String getLocalStock() {
		return localStock;
	}
	public void setLocalStock(String localStock) {
		this.localStock = localStock;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getFkIdUtilizador() {
		return fkIdUtilizador;
	}
	public void setFkIdUtilizador(String fkIdUtilizador) {
		this.fkIdUtilizador = fkIdUtilizador;
	}
	public String getFkIdTipoArtigo() {
		return fkIdTipoArtigo;
	}
	public void setFkIdTipoArtigo(String fkIdTipoArtigo) {
		this.fkIdTipoArtigo = fkIdTipoArtigo;
	}
	public String getFkIdEstado() {
		return fkIdEstado;
	}
	public void setFkIdEstado(String fkIdEstado) {
		this.fkIdEstado = fkIdEstado;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	
}
