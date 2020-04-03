package pe.ricardomarcelo.ventas.rs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pe.ricardomarcelo.ventas.entity.Cliente;
import pe.ricardomarcelo.ventas.service.ClienteService;

@Singleton
@Path(value = "/clientes")
public class ClienteRS {
    
    private ClienteService clienteService = new ClienteService();
       
    @POST    
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response crear(Cliente cliente){
        clienteService.crear(cliente);
        Map<String, String> resultado = new HashMap<String, String>();
        resultado.put("resultado","Cliente creado");
     
        return Response
        	      .status(Response.Status.CREATED)
        	      .entity(resultado)
        	      .build();
    }
    
    @GET  
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> consultarTodo(){
    
        return clienteService.consultarTodo();
    }        
}