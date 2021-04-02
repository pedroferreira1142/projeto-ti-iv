package models;
import java.util.Date;


public class Movimento {
	
	//Atributes
	private String uid;
	private Date dataCricao;
	private String localStock;
	private String colaboradorNuc;
	private String uidTipoMovimento;
	
	
	///Getters and setters
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Date getDataCricao() {
		return dataCricao;
	}
	public void setDataCricao(Date dataCricao) {
		this.dataCricao = dataCricao;
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
	
	
}
