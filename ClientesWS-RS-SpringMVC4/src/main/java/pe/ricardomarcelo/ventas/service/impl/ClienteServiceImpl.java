package pe.ricardomarcelo.ventas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import pe.ricardomarcelo.ventas.model.Cliente;
import pe.ricardomarcelo.ventas.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	
	public String crear(Cliente cliente) {
		listaCliente.add(cliente);
		return "Cliente creado";
	}
	
	public List<Cliente> consultarTodo() {
		return listaCliente;		
	}
}
