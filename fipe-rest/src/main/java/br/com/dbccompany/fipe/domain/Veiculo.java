package br.com.dbccompany.fipe.domain;

import java.io.Serializable;

/*
 * "fipe_marca": "Fiat",
	"fipe_codigo": "2014-1",
	"name": "2014 Gasolina",
	"marca": "FIAT",
	"key": "2014-1",
	"veiculo": "Palio 1.0 ECONOMY Fire Flex 8V 4p",
	"id": "2014-1"
 */
public class Veiculo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String id;

	private String fipe_marca;
	
	private String fipe_name;
	
	private String name;
	
	private String marca;
	
	private String key;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFipe_marca() {
		return fipe_marca;
	}

	public void setFipe_marca(String fipe_marca) {
		this.fipe_marca = fipe_marca;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFipe_name() {
		return fipe_name;
	}

	public void setFipe_name(String fipe_name) {
		this.fipe_name = fipe_name;
	}	
}
