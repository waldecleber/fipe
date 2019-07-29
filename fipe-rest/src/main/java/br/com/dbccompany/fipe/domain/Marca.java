package br.com.dbccompany.fipe.domain;

import java.io.Serializable;

/*
 *  {"key": "audi-6", "id": 6, "fipe_name": "Audi", "name": "AUDI"},
 *  
 *   
 */
public class Marca implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String key;
	
	private String id;
	
	private String fipe_name;
	
	private String name;
	
	private String order;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFipe_name() {
		return fipe_name;
	}

	public void setFipe_name(String fipe_name) {
		this.fipe_name = fipe_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marca other = (Marca) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}


	

}
