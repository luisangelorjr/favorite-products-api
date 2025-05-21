package br.com.luisangelorjr.favorite_products_api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import br.com.luisangelorjr.favorite_products_api.model.dto.request.ClientPatchRequestDTO;
import br.com.luisangelorjr.favorite_products_api.model.dto.request.ClientRequestDTO;
import br.com.luisangelorjr.favorite_products_api.model.entity.Client;
import jakarta.validation.Valid;

public interface ClientService {
	
	public Page<Client> findAll(Integer numberOfPage, Integer totalOfPage);
	public Optional<Client> findById(Long id);
	public Client save(ClientRequestDTO requestBody);
	public void deleteById(Long id);
	public Boolean existsById(Long id);
	public Client patch(Long id, ClientPatchRequestDTO requestBody);

}
