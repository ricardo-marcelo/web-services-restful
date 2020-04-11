package pe.ricardomarcelo.ventas.consumer;

import java.util.Map;


import org.springframework.web.client.RestTemplate;

import pe.ricardomarcelo.ventas.model.Cliente;

public class App {

	private static String SERVER = "http://localhost:8080";
	private static String CONTEXT = "/ClientesWS-RS-SpringMVC3";
	private static String URI = SERVER + CONTEXT + "/rs/clientes";
	
	public static void main(String[] args) {
		clienteCrear();
		clienteConsultarTodo();
	}
	
	public static void clienteCrear() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setNombre("Ricardo");
		cliente.setDireccion("Lima");
		cliente.setTelefono("1235665");
		
		Map<String, String> resultado = restTemplate.postForObject(URI, 
				cliente, Map.class);
		
		System.out.println("Resultado: " + resultado.get("resultado"));
		System.out.println("============================");
	}
	
	
	public static void clienteConsultarTodo() {
		
		RestTemplate restTemplate = new RestTemplate();
			
		Cliente[] listaCliente = restTemplate.getForObject(URI,Cliente[].class);
		
		for(Cliente cliente : listaCliente) {
			System.out.println(cliente.getId() + " - " + cliente.getNombre());	
		}		
	}
}
