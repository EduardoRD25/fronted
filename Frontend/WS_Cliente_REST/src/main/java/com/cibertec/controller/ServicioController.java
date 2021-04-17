package com.cibertec.controller;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.cibertec.entity.Servicio;
import com.google.gson.Gson;
@Controller
@RequestMapping(value = "/servicio")
public class ServicioController {
	private String REST_SERVICIO="http://localhost:8090/servicio/";
	//private String REST_DISTRITO="http://localhost:8090/distrito/listaDistrito/";
	
	@RequestMapping(value = "/crudServicio")
	public String index() {
		return "crudServicio";
	}
	
	@RequestMapping(value = "/listaServicio")
	public @ResponseBody Map<String,Object> listaServicios() {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			RestTemplate rt=new RestTemplate();
			ResponseEntity<Servicio[]> response =rt.getForEntity(REST_SERVICIO+"listaServicio",Servicio[].class);
			Servicio[] lista=response.getBody();
			map.put("dataServicios", lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value="/saveServicio")
	public @ResponseBody Map<String,Object> save(@RequestBody Servicio bean) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
		    RestTemplate restTemplate = new RestTemplate();
		    //Se trasnforma a json
			Gson gson = new Gson();
			String dataJson=  gson.toJson(bean);
			//
			HttpHeaders headers = new HttpHeaders();
			MediaType mediaType = new MediaType("application", "json", StandardCharsets.UTF_8);
			headers.setContentType(mediaType);
	    	HttpEntity<String> request = new HttpEntity<String>(dataJson.toString(), headers);
	    	//
		    if(bean.getCod_ser()==0) {
		    	restTemplate.postForObject(REST_SERVICIO+"registraServicio", request, String.class);
		    	map.put("dataMensaje",1);
		    }
		    else {
		       	restTemplate.put(REST_SERVICIO+"actualizaServicio", request, String.class);
		    	map.put("dataMensaje",1);
		    }
		} catch (Exception e) {
			map.put("dataMensaje",-1);
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value="/deleteServicio")
	public @ResponseBody Map<String,Object> deleteServicio(@RequestParam("cod_ser") int cod) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
		    RestTemplate restTemplate = new RestTemplate();
		    restTemplate.delete(REST_SERVICIO+"eliminaServicio/"+cod);
			map.put("dataMensaje",1);	
		} catch (Exception e) {
			map.put("dataMensaje",-1);
			e.printStackTrace();
		}
		return map;
	}
}





