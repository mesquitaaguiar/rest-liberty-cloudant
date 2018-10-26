package br.com.cameag.sistemas.service;

import java.io.Serializable;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.org.lightcouch.CouchDbException;

import br.com.cameag.sistemas.enums.CloudantEnum;

public class CloudantService implements Serializable{
	
	private static final long serialVersionUID = -8547328628404996661L;
	
	private static CloudantClient cloudant = null;
	private static Database db = null;
	
	private static void initClient() {
		if (cloudant == null) {
			synchronized (CloudantService.class) {
				if (cloudant != null) {
					return;
				}
				cloudant = createClient();

			}
		}
	}

	private static CloudantClient createClient() {
		try {
			CloudantClient client = ClientBuilder.account(CloudantEnum.LOGIN.getDescricao())
										.username(CloudantEnum.LOGIN.getDescricao())
												.password(CloudantEnum.SENHA.getDescricao()).build();
			return client;
		} catch (CouchDbException e) {
			throw new RuntimeException("Impossivel conectar ao repositorio", e);
		}
	}

	public static Database getDB() {
		if (cloudant == null) {
			initClient();
		}

		if (db == null) {
			try {
				db = cloudant.database(CloudantEnum.BANCO.getDescricao(), true);
			} catch (Exception e) {
				throw new RuntimeException("DB não encontrado", e);
			}
		}
		return db;
	}

	private CloudantService() {}
	
}
