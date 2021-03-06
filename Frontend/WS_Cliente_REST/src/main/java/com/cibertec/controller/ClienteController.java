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

import com.cibertec.entity.Distrito;
import com.cibertec.entity.Cliente;
import com.google.gson.Gson;
@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {
	private String REST_CLIENTE="http://localhost:8090/cliente/";
	private String REST_DISTRITO="http://localhost:8090/distrito/listaDistrito/";
	
	@RequestMapping(value = "/crudCliente")
	public String index() {
		return "crudCliente";
	}
	
	@RequestMapping(value = "/listaClientes")
	public @ResponseBody Map<String,Object> listaClientes() {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			RestTemplate rt=new RestTemplate();
			ResponseEntity<Cliente[]> response =rt.getForEntity(REST_CLIENTE+"listaCliente",Cliente[].class);
			Cliente[] lista=response.getBody();
			map.put("dataClientes", lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value = "/listaDistritos")
	public @ResponseBody Map<String,Object> listaDistritos() {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			RestTemplate rt=new RestTemplate();
			ResponseEntity<Distrito[]> response =rt.getForEntity(REST_DISTRITO,Distrito[].class);
			Distrito[] lista=response.getBody();
			map.put("dataDistritos", lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value="/saveClientes")
	public @ResponseBody Map<String,Object> save(@RequestBody Cliente bean) {
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
		    if(bean.getCod_cli()==0) {
		    	restTemplate.postForObject(REST_CLIENTE+"registraCliente", request, String.class);
		    	map.put("dataMensaje",1);
		    }
		    else {
		       	restTemplate.put(REST_CLIENTE+"actualizaCliente", request, String.class);
		    	map.put("dataMensaje",1);
		    }
		} catch (Exception e) {
			map.put("dataMensaje",-1);
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value="/deleteCliente")
	public @ResponseBody Map<String,Object> deleteCliente(@RequestParam("cod_cli") int cod) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
		    RestTemplate restTemplate = new RestTemplate();
		    restTemplate.delete(REST_CLIENTE+"eliminaCliente/"+cod);
			map.put("dataMensaje",1);	
		} catch (Exception e) {
			map.put("dataMensaje",-1);
			e.printStackTrace();
		}
		return map;
	}
}





