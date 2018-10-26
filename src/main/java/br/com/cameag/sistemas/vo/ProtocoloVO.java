package br.com.cameag.sistemas.vo;

import java.io.Serializable;

public class ProtocoloVO implements Serializable {

	private static final long serialVersionUID = 92380384574864415L;
	
	private String _id;
	private String _rev;
	private String data;
	private String celular;
	private String assunto;
	private String descricao;
	private String latitude;
	private String longitude;
	
	public ProtocoloVO(String _id, String data, String celular, String assunto, String descricao, String latitude,
			String longitude) {
		super();
		this._id = _id;
		this.data = data;
		this.celular = celular;
		this.assunto = assunto;
		this.descricao = descricao;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	
	
	public String get_rev() {
		return _rev;
	}

	public void set_rev(String _rev) {
		this._rev = _rev;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
}
