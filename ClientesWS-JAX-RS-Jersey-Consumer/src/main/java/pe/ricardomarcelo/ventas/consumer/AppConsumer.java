package pe.ricardomarcelo.ventas.consumer;

import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import pe.ricardomarcelo.ventas.entity.Cliente;

public class AppConsumer {

    public static void main(String[] args) {
        crearCliente();
        buscarPorNombreCliente();
    }
    
    public static void crearCliente(){
        String REST_URI= "http://localhost:8080/ClientesWS-JAX-RS-Jersey/rs"; 
        String OPERACION ="/clientes";       
        String URL = REST_URI + OPERACION;
        
        // Bean
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNombre("RICARDO MARCELO");
        cliente.setDireccion("Av. Brasil 788");
        cliente.setTelefono("1234567");
        
        //JAX-RS Client
        Client cliRS = ClientBuilder.newClient();
        Map response = cliRS.target(URL)
                                 .request(MediaType.APPLICATION_JSON)
                                 .post(Entity.entity(cliente, 
                                         MediaType.APPLICATION_JSON),
                                		 Map.class);
	       
        // Escribir el resultado
        System.out.println("Resultado: " + response.get("resultado"));
        System.out.println("===================");
    }
    
    public static void buscarPorNombreCliente(){        
        String REST_URI= "http://localhost:8080/ClientesWS-JAX-RS-Jersey/rs"; 
        String OPERACION ="/clientes";
        String URL = REST_URI + OPERACION;
        
        //JAX-RS Client
        Client cliRS = ClientBuilder.newClient();
        List<Cliente> listaCliente = cliRS.target(URL)
                                          .request(MediaType.APPLICATION_JSON)
                                          .get(new GenericType<List<Cliente>>() {});
        // Escribir el resultado
        for (Cliente cliente : listaCliente) {
            System.out.println(cliente.getId() + " - " +
                               cliente.getNombre());
        }        
    }
}
