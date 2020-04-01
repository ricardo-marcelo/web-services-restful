package pe.ricardomarcelo.ventas.consumer;


import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import pe.ricardomarcelo.ventas.model.Cliente;

public class App {

	public static void main(String[] args) {
	
		//clienteCrear();
		clienteConsultarTodo();
	}
	
	public static void clienteCrear() {
		String url = "http://localhost:8080/ClientesWS-RS-SpringMVC4/rs/clientes";
		RestTemplate restTemplate = new RestTemplate();
		
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setNombre("Ricardo");
		cliente.setDireccion("Lima");
		cliente.setTelefono("1235665");
		
		ResponseEntity<Map> response = restTemplate.postForEntity(url, 
				cliente, Map.class);

		//System.out.println(resultado.get("resultado"));
		if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println(response.getBody().get("resultado"));
		} else {
		    System.out.println("El Response a fallado");
		}
	}
	
	
	public static void clienteConsultarTodo() {
		String url = "http://localhost:8080/ClientesWS-RS-SpringMVC4/rs/clientes";
		RestTemplate restTemplate = new RestTemplate();
	
		HttpHeaders headers = new HttpHeaders();
	    //headers.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
	    //headers.setAccept(Arrays.asList( MediaType.APPLICATION_JSON_UTF8_VALUE));
		 headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
	        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_UTF8_VALUE);
		ResponseEntity<Cliente[]> response = restTemplate.getForEntity(url,Cliente[].class,headers);
		
		
		for(Cliente cliente : response.getBody()) {
			System.out.println(cliente.getId() + " - " + cliente.getNombre());	
		}
		
		/*
		 * ParameterizedTypeReference<HashMap<String, String>> responseType = new
		 * ParameterizedTypeReference<HashMap<String, String>>() {};
		 * 
		 * RequestEntity<Cliente[]> request = RequestEntity.get(new
		 * URI(url)).accept(MediaType.APPLICATION_JSON).build();
		 * 
		 * Map<String, String> jsonDictionary = restTemplate.exchange(request,
		 * responseType);
		 * 
		 * System.out.println(response.getBody().toString());
		 */
		
		/*
		 * ResponseEntity<Cliente[]> response = restTemplate.exchange(url,
		 * HttpMethod.GET,null, Cliente[].class);
		 * 
		 * 
		 * 
		 * for(Cliente cliente : response.getBody()) {
		 * System.out.println(cliente.getId() + " - " + cliente.getNombre()); }
		 */
		    
	}

}
