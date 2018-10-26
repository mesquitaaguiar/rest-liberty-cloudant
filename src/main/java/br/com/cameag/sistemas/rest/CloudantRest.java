package br.com.cameag.sistemas.rest;

import java.io.Serializable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.cloudant.client.api.Database;
import com.google.gson.Gson;

import br.com.cameag.sistemas.service.CloudantService;
import br.com.cameag.sistemas.service.impl.CloudantServiceImpl;

@Path("/webservice")
public class CloudantRest implements Serializable{

	private static final long serialVersionUID = -5525044913020014359L;
	
	@GET
	@Path("/protocolo/{codigo}")
	@Produces("application/json")
	public String getDialog(@PathParam("codigo") String codigo){
		
		Database db = null;
		try {
			db = CloudantService.getDB();
			CloudantServiceImpl cloudantServiceImpl = new CloudantServiceImpl();
			return new Gson().toJson(cloudantServiceImpl.getProtocolo(db, codigo));
		} catch (Exception re) {}
		
		return "{}";
	}
	
	@GET
	@Path("/protocolo/persist/{codigo}/{date}/{celular}/{latitude}/{longitude}/{assunto}/{descricao}")
	@Produces("application/json")
	public String persist(@PathParam("codigo") String codigo,@PathParam("date") String date,@PathParam("celular") String celular,@PathParam("latitude") String latitude
								,@PathParam("longitude") String longitude,@PathParam("assunto") String assunto,@PathParam("descricao") String descricao){
		
		Database db = null;
		try {
			db = CloudantService.getDB();
			CloudantServiceImpl cloudantServiceImpl = new CloudantServiceImpl();
			return new Gson().toJson(cloudantServiceImpl.persist(db, codigo, date, latitude, longitude, celular, assunto, descricao));
		} catch (Exception re) { re.printStackTrace();}
		
		return "{}";
	}
}
