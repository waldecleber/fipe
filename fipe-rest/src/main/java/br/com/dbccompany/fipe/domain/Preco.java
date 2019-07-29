package br.com.dbccompany.fipe.domain;

import java.io.Serializable;

/**
 * {
    "id": "2013",
    "ano_modelo": "2013",
    "marca": "Fiat",
    "name": "Palio 1.0 ECONOMY Fire Flex 8V 4p",
    "veiculo": "Palio 1.0 ECONOMY Fire Flex 8V 4p",
    "preco": "R$ 23.055,00",
    "combustivel": "Gasolina",
    "referencia": "agosto de 2015",
    "fipe_codigo": "001267-0",
    "key": "palio-2013"
}
 * @author Cleber
 *
 */
public class Preco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String ano_modelo;
	
	private String name;
	
	private String preco;
	
	private String combustivel;
	
	private String referencia;
	
	private String fipe_codigo;
	
	private String key;
	
	private String marca;
	
	private String veiculo;
	
	private Long time;
	
	private double precoFormatado;
	
	private double diferenca;
	
	private double percentual;
	
	private String anoAnterior;

	public double getPercentual() {
		return percentual;
	}

	public void setPercentual(double percentual) {
		this.percentual = percentual;
	}

	public double getDiferenca() {
		return diferenca;
	}

	public void setDiferenca(double diferenca) {
		this.diferenca = diferenca;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAno_modelo() {
		return ano_modelo;
	}

	public void setAno_modelo(String ano_modelo) {
		this.ano_modelo = ano_modelo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getFipe_codigo() {
		return fipe_codigo;
	}

	public void setFipe_codigo(String fipe_codigo) {
		this.fipe_codigo = fipe_codigo;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
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
		Preco other = (Preco) obj;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public double getPrecoFormatado() {
		return precoFormatado;
	}

	public void setPrecoFormatado(double precoFormatado) {
		this.precoFormatado = precoFormatado;
	}

	public String getAnoAnterior() {
		return anoAnterior;
	}

	public void setAnoAnterior(String anoAnterior) {
		this.anoAnterior = anoAnterior;
	}
	
	
}
