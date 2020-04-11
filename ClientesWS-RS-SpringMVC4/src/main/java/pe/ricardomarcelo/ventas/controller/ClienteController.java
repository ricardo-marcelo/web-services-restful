package pe.ricardomarcelo.ventas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pe.ricardomarcelo.ventas.model.Cliente;
import pe.ricardomarcelo.ventas.service.ClienteService;

@RestController(value = "/rs/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
    @PostMapping
	public ResponseEntity<Map<String,String>> crear(@RequestBody Cliente cliente) {
		
		String resultado = null;
				
		resultado = clienteService.crear(cliente);
		
		Map<String, String> map =new HashMap<String, String>();
		map.put("resultado", resultado);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cliente", "OK");
		return new ResponseEntity<Map<String,String>>(map, headers, HttpStatus.CREATED);		
	}

	@GetMapping
	public ResponseEntity<List<Cliente>> consultarTodo() {
		ResponseEntity<List<Cliente>> responseListaCliente = null;
		HttpHeaders headers = new HttpHeaders();
		
		List<Cliente> listaCliente = null;
				
		listaCliente = clienteService.consultarTodo();
		if (listaCliente == null) {
			responseListaCliente = new ResponseEntity<List<Cliente>>(HttpStatus.NOT_FOUND);
		}else {
			headers.add("NroRegistros", String.valueOf(listaCliente.size()));
			responseListaCliente = new ResponseEntity<List<Cliente>>(listaCliente, 
					headers,HttpStatus.OK);
		}
		return responseListaCliente;
	}
}
