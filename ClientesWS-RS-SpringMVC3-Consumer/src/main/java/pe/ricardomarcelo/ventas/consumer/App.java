package pe.ricardomarcelo.ventas.consumer;


import java.util.Map;


import org.springframework.web.client.RestTemplate;

import pe.ricardomarcelo.ventas.model.Cliente;

public class App {

	public static void main(String[] args) {
	
		//clienteCrear();
		clienteConsultarTodo();
	}
	
	public static void clienteCrear() {
		String url = "http://localhost:8080/ClientesWS-RS-SpringMVC3/rs/cliente/crear";
		RestTemplate restTemplate = new RestTemplate();
		
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setNombre("Ricardo");
		cliente.setDireccion("Lima");
		cliente.setTelefono("1235665");
		
		Map<String, String> resultado = restTemplate.postForObject(url, 
				cliente, Map.class);
		
		
		
		System.out.println(resultado.get("resultado"));
	}
	
	
	public static void clienteConsultarTodo() {
		String url = "http://localhost:8080/ClientesWS-RS-SpringMVC3/rs/cliente/consultartodo";
		RestTemplate restTemplate = new RestTemplate();
		
		
		Cliente[] listaCliente = restTemplate.getForObject(url,Cliente[].class);
		
		for(Cliente cliente : listaCliente) {
			System.out.println(cliente.getId() + " - " + cliente.getNombre());	
		}
		
	}

}
