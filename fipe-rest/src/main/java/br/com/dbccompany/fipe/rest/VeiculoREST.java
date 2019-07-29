package br.com.dbccompany.fipe.rest;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.dbccompany.fipe.domain.Fipe;
import br.com.dbccompany.fipe.domain.Marca;
import br.com.dbccompany.fipe.domain.Preco;
import br.com.dbccompany.fipe.domain.Veiculo;

/**
 * Classe responsavel por realizar a consulta na API na FIPE e montar o REST 
 *  
 * http://localhost:8080/fipe/api/veiculo
 * @author Cleber
 *
 */
@Path("/veiculo")
public class VeiculoREST {

	private static final String URL_FIPE = "http://fipeapi.appspot.com/api/1/carros/";

	private List<Marca> marcas = new ArrayList<Marca>();

	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	private List<Fipe> fipeList = new ArrayList<Fipe>();


	/**
	 * M�todo para listar todas as marcas.
	 * result: http://localhost:8080/fipe/api/veiculo/marcas
	 * @return
	 */
	@GET
	@Path("/marcas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Marca> listarMarcas() {

		try {

			ObjectMapper mapper = new ObjectMapper();

			marcas = mapper.readValue(new URL(URL_FIPE + "marcas.json"), new TypeReference<List<Marca>>() {
			});

		} catch (Exception e) {

			e.printStackTrace();

		}
		return marcas;

	}

	/**
	 * Lista todos os veiculos de uma determinada marca
	 * 
	 * Ex.: http://localhost:8080/fipe/api/veiculos/21
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Veiculo> listarVeiculos(@PathParam("id") String id) {

		try {

			ObjectMapper mapper = new ObjectMapper();

			veiculos = mapper.readValue(new URL(URL_FIPE + "veiculos/" + id + ".json"),
					new TypeReference<List<Veiculo>>() {
					});

		} catch (Exception e) {

			e.printStackTrace();

		}
		return veiculos;

	}

	/**
	 * Obt�m a lista de veiculos por marca com seus respectivos precos
	 * 
	 * Ex: http://localhost:8080/fipe/api/veiculo/21/4826
	 * 
	 * @param id
	 * @param marca
	 * @return
	 */
	@GET
	@Path("/{id}/{marca}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fipe> listarVeiculoComPreco(@PathParam("id") String id, @PathParam("marca") String marca) {

		try {

			ObjectMapper mapper = new ObjectMapper();

			fipeList = mapper.readValue(new URL(URL_FIPE + "veiculo/" + id + "/" + marca + ".json"),
					new TypeReference<List<Fipe>>() {
					});

			/*
			 * Faz o mapeamento dos precos para o respectivo veiculo.
			 */
			for (Fipe veiculo : fipeList) {
				Preco preco = mapper.readValue(
						new URL(URL_FIPE + "veiculo/" + id + "/" + marca + "/" + veiculo.getId() + ".json"),
						Preco.class);
				preco.setPrecoFormatado(Util.converterPreco(preco.getPreco()));
				veiculo.setPreco(preco);
			}

			/*
			 * Percorre a lista de veiculos para calcular a diferenca entre os precos.
			 */
			for (int i = 1; i < fipeList.size(); i++) {
				Fipe atual = fipeList.get(i - 1);
				Fipe prox = fipeList.get(i);

				double diferenca = atual.getPreco().getPrecoFormatado() - prox.getPreco().getPrecoFormatado();
				double percentual = ((diferenca * 100) / atual.getPreco().getPrecoFormatado());

				DecimalFormat df2 = new DecimalFormat(" #,##0.00 %");
				df2.setMultiplier(1);

				prox.getPreco().setDiferenca(diferenca);
				prox.getPreco().setPercentual((Double) df2.parse(df2.format(percentual)));
				prox.getPreco().setAnoAnterior(atual.getPreco().getAno_modelo());
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return fipeList;

	}

	@GET
	@Path("/{id}/{marca}/{modelo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pesquisarVeiculo(@PathParam("marca") String marca, @PathParam("id") String id,
			@PathParam("modelo") String modelo) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			Preco preco = mapper.readValue(new URL(URL_FIPE + "veiculo/" + id + "/" + marca + "/" + modelo + ".json"),
					Preco.class);
			Status status = (preco != null ? Status.OK : Status.NOT_FOUND);
			return Response.status(status).entity(preco).build();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}
