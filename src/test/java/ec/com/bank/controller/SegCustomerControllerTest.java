package ec.com.bank.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import ec.com.bank.service.CustomerService;
import ec.com.bank.service.SecurityService;
import ec.com.bank.service.dto.charactes.CustomerDto;

@ExtendWith(SpringExtension.class)
class SegCustomerControllerTest {

	@InjectMocks
	private SegCustomerController segCustomerController;

	@Mock
	private SecurityService securityService;

	@Mock
	private CustomerService customerService;

	@Test
	void testGetCustomers() {
		String bearerToken = "Bearer abc123";
		List<CustomerDto> mockCustomers = Arrays.asList(new CustomerDto(), new CustomerDto());

		doNothing().when(securityService).validateTolen("abc123");
		when(customerService.getCustomers()).thenReturn(mockCustomers);

		List<CustomerDto> result = segCustomerController.getCustomers(bearerToken);

		assertNotNull(result);
		assertEquals(2, result.size());
		verify(securityService, times(1)).validateTolen("abc123");
		verify(customerService, times(1)).getCustomers();
	}

	@Test
	void testGetCustomersThrowsUnauthorizedException() {
		String bearerToken = "Bearer invalidToken";

		doThrow(new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid token")).when(securityService)
				.validateTolen("invalidToken");

		ResponseStatusException exception = assertThrows(ResponseStatusException.class,
				() -> segCustomerController.getCustomers(bearerToken));

		assertEquals(HttpStatus.UNAUTHORIZED, exception.getStatusCode());
		assertEquals("Invalid token", exception.getReason());
		verify(securityService, times(1)).validateTolen("invalidToken");
		verify(customerService, never()).getCustomers();
	}
}