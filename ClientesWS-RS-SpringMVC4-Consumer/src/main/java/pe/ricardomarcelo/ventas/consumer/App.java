package pe.ricardomarcelo.ventas.consumer;


import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
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
	
		clienteCrear();
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
		if (response.getStatusCode() == HttpStatus.CREATED) {
			System.out.println("Header - Cliente: " + response.getHeaders().get("Cliente"));
			System.out.println("Body - Resultado: " + response.getBody().get("resultado"));
		} else {
		    System.out.println("El Response a fallado");
		}
		
	    System.out.println("===========================");
	}
	
	
	public static void clienteConsultarTodo() {
		String url = "http://localhost:8080/ClientesWS-RS-SpringMVC4/rs/clientes";
		RestTemplate restTemplate = new RestTemplate();
	
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON_UTF8 }));
	  	
        HttpEntity<String> request = new HttpEntity<String>(headers);
		
	    ResponseEntity<List<Cliente>> response = restTemplate.exchange(url, HttpMethod.GET,
	    		request, new ParameterizedTypeReference<List<Cliente>>() {});

	    if(response.getStatusCode() == HttpStatus.OK) {
	    	System.out.println("Header: " + response.getHeaders());
			for(Cliente cliente : response.getBody()) {
				System.out.println(cliente.getId() + " - " + cliente.getNombre());	
			}

	    } else {
	        System.out.println("No hay registros");
	    }		    
	    
	    System.out.println("===========================");
	}

}
