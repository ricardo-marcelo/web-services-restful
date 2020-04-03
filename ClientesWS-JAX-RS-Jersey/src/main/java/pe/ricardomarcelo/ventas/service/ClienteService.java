package pe.ricardomarcelo.ventas.service;

import java.util.ArrayList;
import java.util.List;

import pe.ricardomarcelo.ventas.entity.Cliente;
import pe.ricardomarcelo.ventas.service.ClienteService;


public class ClienteService{
	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	
	public String crear(Cliente cliente) {
		listaCliente.add(cliente);
		return "Cliente creado";
	}
	
	public List<Cliente> consultarTodo() {
		return listaCliente;		
	}
}
