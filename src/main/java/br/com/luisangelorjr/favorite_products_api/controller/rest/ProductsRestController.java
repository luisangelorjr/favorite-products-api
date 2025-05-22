package br.com.luisangelorjr.favorite_products_api.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luisangelorjr.favorite_products_api.client.rest.fakestoreapi.FakeStoreApiRestClient;
import br.com.luisangelorjr.favorite_products_api.client.rest.fakestoreapi.FakeStoreProductResponseDTO;

//TODO: Only testing the requests to FakeStore
@RestController
@RequestMapping("/v1/products")
public class ProductsRestController {
	
	@Autowired
	private FakeStoreApiRestClient restClient;
	
	@GetMapping
	public ResponseEntity<List<FakeStoreProductResponseDTO>> getAll(){
		return ResponseEntity.ok(restClient.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<FakeStoreProductResponseDTO> getById(@PathVariable(name = "id") Integer id){
		return ResponseEntity.ok(restClient.getById(id));
	}
	
}
