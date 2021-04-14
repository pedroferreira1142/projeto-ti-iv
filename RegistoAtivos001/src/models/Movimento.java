package models;
import java.util.Date;

import models.DBConverter.DBTable;


public class Movimento {
	
	//Atributes
	@DBTable(nomeColuna ="id")
	private String uid;
	
	@DBTable(nomeColuna ="dataMovimento")
	private Date dataCriacao;
	
	@DBTable(nomeColuna ="localMovimento")
	private String localStock;
	
	@DBTable(nomeColuna ="colaboradorNuc")
	private String colaboradorNuc;
	
	@DBTable(nomeColuna ="colaboradorNome")
	private String nomeColaborador;
	
	@DBTable(nomeColuna ="FK_IdTipoMovimento")
	private String uidTipoMovimento;
	
	@DBTable(nomeColuna ="FK_IdArtigo")
	private String uidArtigo;
	
	@DBTable(nomeColuna ="FK_IdUtilizador")
	private String uidUtilizador;
	
	@DBTable(nomeColuna ="obs")
	private String obs;
	
	
	
	///Getters and setters
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getLocalStock() {
		return localStock;
	}
	public void setLocalStock(String localStock) {
		this.localStock = localStock;
	}
	public String getColaboradorNuc() {
		return colaboradorNuc;
	}
	public void setColaboradorNuc(String colaboradorNuc) {
		this.colaboradorNuc = colaboradorNuc;
	}
	public String getUidTipoMovimento() {
		return uidTipoMovimento;
	}
	public void setUidTipoMovimento(String uidTipoMovimento) {
		this.uidTipoMovimento = uidTipoMovimento;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getNomeColaborador() {
		return nomeColaborador;
	}
	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}
	public String getUidUtilizador() {
		return uidUtilizador;
	}
	public void setUidUtilizador(String uidUtilizador) {
		this.uidUtilizador = uidUtilizador;
	}
	public String getUidArtigo() {
		return uidArtigo;
	}
	public void setUidArtigo(String uidArtigo) {
		this.uidArtigo = uidArtigo;
	}
	
	
}
