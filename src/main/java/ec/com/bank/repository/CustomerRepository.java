package ec.com.bank.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ec.com.bank.service.dto.charactes.CustomerDto;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Repository
public class CustomerRepository {

	public List<CustomerDto> getCustomers() {
		CustomerClient client = Feign.builder().encoder(new JacksonEncoder()).decoder(new JacksonDecoder())
				.target(CustomerClient.class, "http://localhost:8082");
		return client.getCustomers();
	}

}
