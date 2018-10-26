package br.com.cameag.sistemas.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.cloudant.client.api.Database;

import br.com.cameag.sistemas.vo.ProtocoloVO;

public class CloudantServiceImpl implements Serializable{

	private static final long serialVersionUID = -7276078295467136265L;
	
	@SuppressWarnings("unchecked")
	public ProtocoloVO getProtocolo(Database db, String codigo) throws Exception{
		HashMap<String, Object> obj = (codigo == null) ? null : db.find(HashMap.class, codigo);
		return toJsonProtocolo(obj);
	}

	@SuppressWarnings("unchecked")
	public ProtocoloVO persist(Database db, String id, String date, String latitude, String longitude, 
														String celular, String assunto, String descricao) throws Exception {

		HashMap<String, Object> obj = null;
		try{
			obj = (id == null) ? null : db.find(HashMap.class, id);
		}catch (Exception e) {}
		

		if (obj == null) {
			
			//id = String.valueOf(System.currentTimeMillis());

			Map<String, Object> data = new HashMap<String, Object>();
			data.put("_id", id);
			data.put("data", date);
			data.put("celular", celular);
			data.put("latitude", latitude);
			data.put("longitude", longitude);
			data.put("assunto", null);
			data.put("descricao", null);
			db.save(data);
		} else {
			obj = db.find(HashMap.class, id);
			obj.put("data", date);
			obj.put("celular", celular);
			obj.put("assunto", assunto);
			obj.put("descricao", descricao);
			obj.put("latitude", latitude);
			obj.put("longitude", longitude);
			db.update(obj);
		}

		obj = db.find(HashMap.class, id);
		return toJsonProtocolo(obj);
	}
	
	private ProtocoloVO toJsonProtocolo(HashMap<String, Object> obj) throws Exception{
		if(obj == null)
			throw new Exception();
		
		return new ProtocoloVO(obj.get("_id").toString(),obj.get("data").toString()
				,obj.get("celular").toString(),obj.get("assunto")==null?"":obj.get("assunto").toString()
					,obj.get("descricao")==null?null:obj.get("descricao").toString(),obj.get("latitude").toString(),obj.get("longitude").toString());
	}
}
