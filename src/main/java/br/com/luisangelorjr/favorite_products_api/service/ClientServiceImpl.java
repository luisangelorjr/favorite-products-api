package br.com.luisangelorjr.favorite_products_api.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.luisangelorjr.favorite_products_api.model.dto.request.ClientPatchRequestDTO;
import br.com.luisangelorjr.favorite_products_api.model.dto.request.ClientRequestDTO;
import br.com.luisangelorjr.favorite_products_api.model.entity.Client;
import br.com.luisangelorjr.favorite_products_api.model.mapper.ClientMapper;
import br.com.luisangelorjr.favorite_products_api.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ClientRepository repository;
	
	@Override
	public Page<Client> findAll(Integer numberOfPage, Integer totalOfPage){
		Pageable pageable = PageRequest.of(numberOfPage, totalOfPage);
		return repository.findAll(pageable);
	}

	@Override
	public Optional<Client> findById(Long id) {
		Optional<Client> optional = repository.findById(id);
		return optional;
	}

	@Override
	public Client save(ClientRequestDTO requestBody) {
		Client entity = ClientMapper.INSTANCE.clientRequestToClient(requestBody);
	
		return repository.save(entity);
	}
	
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Boolean existsById(Long id) {
		return repository.existsById(id);
	}

	@Override
	public Client patch(Long id, ClientPatchRequestDTO requestBody) {
		Optional<Client> optional = findById(id);
		
		if(Boolean.TRUE.equals(optional.isEmpty())){
			logger.warn("Client with id={} not finded");
			//TODO: Implements a better returns
		}
		
		Client entity = optional.get();
	    ClientMapper.INSTANCE.updateClientFromDto(requestBody, entity);
		
		return repository.save(entity); 	
	}

}
