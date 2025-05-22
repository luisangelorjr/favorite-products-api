package br.com.luisangelorjr.favorite_products_api.client.rest.fakestoreapi;

import java.util.List;

import br.com.luisangelorjr.favorite_products_api.config.RestTemplateConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//FIX: A timeout error
@Service
public class FakeStoreApiRestClient {
	
	@Value("${external.api.fakestoreapi.url}")
	private String baseUrl;
	
    private final RestTemplate restTemplate;

	public FakeStoreApiRestClient(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	
	public List<FakeStoreProductResponseDTO> getAll(){
		String path = "/products";
		StringBuilder sb = new StringBuilder();
		sb.append(baseUrl);
		sb.append(path);
		
		ResponseEntity<List<FakeStoreProductResponseDTO>> response = restTemplate.exchange(sb.toString(), 
				HttpMethod.GET,
			    null,
			    new ParameterizedTypeReference<List<FakeStoreProductResponseDTO>>() {}
			);
		
		return response.getBody();		
	}
	
	public FakeStoreProductResponseDTO getById(Integer id){
		String path = "/products";
		StringBuilder sb = new StringBuilder();
		sb.append(baseUrl);
		sb.append(path);
		sb.append("/");
		sb.append(id);
		
		ResponseEntity<FakeStoreProductResponseDTO> response = restTemplate.getForEntity(sb.toString(), FakeStoreProductResponseDTO.class);
		
		return response.getBody();		
	}

}
