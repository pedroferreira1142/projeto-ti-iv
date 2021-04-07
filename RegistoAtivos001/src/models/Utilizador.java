package models;
import java.util.Date;

import models.DBConverter.DBTable;

public class Utilizador {
	
	// Construtor
	public Utilizador() 
	{
		// Convidado
		setUid("00000000-0000-0000-0000-000000000000");
		setPrimeiroNome("Convidado");
	}
	
	//Atributes
	@DBTable(nomeColuna ="id")
	private String uid;
	
	@DBTable(nomeColuna ="eMail")
	private String eMail;
	
	@DBTable(nomeColuna ="password")
	private byte[] password;
	
	@DBTable(nomeColuna ="passwordSalt")
	private byte[] passwordSalt;
	
	@DBTable(nomeColuna ="dataCriacao")
	private Date dataCriacao;
	
	@DBTable(nomeColuna ="primeiroNome")
	private String primeiroNome;
	
	@DBTable(nomeColuna ="ultimoNome")
	private String ultimoNome;
	
	@DBTable(nomeColuna ="nuc")
	private String nuc;
	
	@DBTable(nomeColuna ="tipo")
	private int tipo;
	
	// Getters and Setters
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) 
	{
			this.eMail = eMail;
	}
	
	public byte[] getPassword() {
		return password;
	}
	public void setPassword(byte[] password) {
		this.password = password;
	}
	
	public byte[] getPasswordSalt() {
		return passwordSalt;
	}
	public void setPasswordSalt(byte[] passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
	
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	
	public String getUltimoNome() {
		return ultimoNome;
	}
	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}
	
	public String getNuc() {
		return nuc;
	}
	public void setNuc(String nuc) {
		this.nuc = nuc;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	
}
