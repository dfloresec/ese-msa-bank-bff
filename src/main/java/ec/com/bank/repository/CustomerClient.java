package ec.com.bank.repository;

import java.util.List;

import ec.com.bank.service.dto.charactes.CustomerDto;
import feign.RequestLine;

public interface CustomerClient {

	@RequestLine("GET /clientes")
	public List<CustomerDto> getCustomers();

}