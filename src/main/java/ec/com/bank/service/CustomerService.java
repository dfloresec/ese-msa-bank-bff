package ec.com.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ec.com.bank.repository.CustomerRepository;
import ec.com.bank.service.dto.charactes.CustomerDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

	private final CustomerRepository repository;

	public List<CustomerDto> getCustomers() {
		return repository.getCustomers();
	}
	
	
}
