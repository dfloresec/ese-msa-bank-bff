package ec.com.bank.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.com.bank.service.CustomerService;
import ec.com.bank.service.SecurityService;
import ec.com.bank.service.dto.charactes.CustomerDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SegCustomerController {

	private static final String TOKEN_PREFIX = "Bearer ";

	private final SecurityService securityService;

	private final CustomerService customerService;

	@GetMapping(value = "/v1/bank/customers")
	@ResponseStatus(HttpStatus.OK)
	public List<CustomerDto> getCustomers(@RequestHeader("Authorization") String bearerToken) {
		securityService.validateTolen(bearerToken.replace(TOKEN_PREFIX, ""));
		return customerService.getCustomers();
	}

}
