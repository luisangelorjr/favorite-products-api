package br.com.luisangelorjr.favorite_products_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luisangelorjr.favorite_products_api.model.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
