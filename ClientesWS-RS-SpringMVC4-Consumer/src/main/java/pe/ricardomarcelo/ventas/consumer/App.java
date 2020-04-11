package pe.ricardomarcelo.ventas.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import pe.ricardomarcelo.ventas.model.Cliente;

public class App {

	private static UriComponents URI = UriComponentsBuilder.newInstance()
		      .scheme("http")
		      .host("localhost:8080")
		      .path("/ClientesWS-RS-SpringMVC4/rs/clientes").build();

	public static void main(String[] args) {
	
		clienteCrear();
		clienteConsultarTodo();
	}
	
	public static void clienteCrear() {			

		RestTemplate restTemplate = new RestTemplate();
		
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setNombre("Ricardo Marcelo");
		cliente.setDireccion("Lima");
		cliente.setTelefono("992222565");
		
		ResponseEntity<Map> response = restTemplate.postForEntity(URI.toUriString(), 
				cliente, Map.class);

		if (response.getStatusCode() == HttpStatus.CREATED) {
			System.out.println("Header - Cliente: " + response.getHeaders().get("Cliente"));
			System.out.println("Body - Resultado: " + response.getBody().get("resultado"));
		} else {
		    System.out.println("El Response a fallado");
		}
		
	    System.out.println("===========================");
	}
	
	
	public static void clienteConsultarTodo() {
		
		RestTemplate restTemplate = new RestTemplate();
	
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON_UTF8 }));
	  	
        HttpEntity<String> request = new HttpEntity<String>(headers);
		
	    ResponseEntity<List<Cliente>> response = restTemplate.exchange(URI.toUriString(), HttpMethod.GET,
	    		request, new ParameterizedTypeReference<List<Cliente>>() {});

	    if(response.getStatusCode() == HttpStatus.OK) {
	    	System.out.println("Header - NroRegistros " + response.getHeaders().get("NroRegistros"));
			for(Cliente cliente : response.getBody()) {
				System.out.println(cliente.getId() + " - " + cliente.getNombre());	
			}

	    } else {
	        System.out.println("No hay registros");
	    }		    
	    
	    System.out.println("===========================");
	}

}
