package pe.ricardomarcelo.ventas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.ricardomarcelo.ventas.model.Cliente;
import pe.ricardomarcelo.ventas.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/crear", method = RequestMethod.POST, 
			produces =  MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String,String> crear(@RequestBody Cliente cliente) {
		
		String resultado = null;
				
		resultado = clienteService.crear(cliente);
		
		Map<String, String> map =new HashMap<String, String>();
		map.put("resultado", resultado);
		
		return map;
	}

	@RequestMapping(value = "/consultartodo", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Cliente> consultarTodo() {
		
		List<Cliente> listaCliente = null;
				
		listaCliente = clienteService.consultarTodo();
		
		return listaCliente;
	}
}
