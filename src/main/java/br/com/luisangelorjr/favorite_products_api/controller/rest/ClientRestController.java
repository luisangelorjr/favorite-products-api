package br.com.luisangelorjr.favorite_products_api.controller.rest;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.luisangelorjr.favorite_products_api.model.dto.request.ClientPatchRequestDTO;
import br.com.luisangelorjr.favorite_products_api.model.dto.request.ClientRequestDTO;
import br.com.luisangelorjr.favorite_products_api.model.dto.response.ClientResponseDTO;
import br.com.luisangelorjr.favorite_products_api.model.entity.Client;
import br.com.luisangelorjr.favorite_products_api.model.mapper.ClientMapper;
import br.com.luisangelorjr.favorite_products_api.service.ClientService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/clients")
public class ClientRestController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<Page<Client>> findAll(@RequestParam(name ="numberOfPage", required = false, defaultValue = "0") Integer numberOfPage, @RequestParam(name= "totalOfPage", required = false, defaultValue = "10") Integer totalOfPage ){
		return ResponseEntity.ok(service.findAll(numberOfPage, totalOfPage));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Client>> findById(@PathVariable(name ="id") Long id){
		Optional<Client> optional = service.findById(id);

		if(optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optional);
		}
		return ResponseEntity.ok(optional);
	}
	
	@PostMapping
	public ResponseEntity<ClientResponseDTO> create(@Valid @RequestBody ClientRequestDTO requestBody){
		ClientResponseDTO response = ClientMapper.INSTANCE.clientToClientResponse(service.save(requestBody));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable(name ="id") Long id){
		if(Boolean.FALSE.equals(service.existsById(id))) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		service.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClientResponseDTO> update(@PathVariable(name ="id") Long id, @Valid @RequestBody ClientRequestDTO requestBody){
		if(Boolean.FALSE.equals(service.existsById(id))) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ClientResponseDTO());
		}
		
		ClientResponseDTO response = ClientMapper.INSTANCE.clientToClientResponse(service.save(requestBody));
		return ResponseEntity.ok(response);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<ClientResponseDTO> patch(@PathVariable(name ="id") Long id, @Valid @RequestBody ClientPatchRequestDTO requestBody){
		if(Boolean.FALSE.equals(service.existsById(id))) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ClientResponseDTO());
		}
		
		ClientResponseDTO response = ClientMapper.INSTANCE.clientToClientResponse(service.patch(id, requestBody));
		return ResponseEntity.ok(response);
	}
		
}
