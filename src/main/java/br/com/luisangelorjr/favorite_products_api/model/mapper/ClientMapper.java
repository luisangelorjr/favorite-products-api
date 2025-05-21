package br.com.luisangelorjr.favorite_products_api.model.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import br.com.luisangelorjr.favorite_products_api.model.dto.request.ClientPatchRequestDTO;
import br.com.luisangelorjr.favorite_products_api.model.dto.request.ClientRequestDTO;
import br.com.luisangelorjr.favorite_products_api.model.dto.response.ClientResponseDTO;
import br.com.luisangelorjr.favorite_products_api.model.entity.Client;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper( ClientMapper.class );
    
    Client clientRequestToClient(ClientRequestDTO clientRequestDTO);
    ClientResponseDTO clientToClientResponse(Client client);
    Client clientPatchRequestToClient(ClientPatchRequestDTO clientPatchRequestDTO);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateClientFromDto(ClientPatchRequestDTO dto, @MappingTarget Client entity);
    
}

