package ec.com.bank.repository;

import org.springframework.web.bind.annotation.RequestBody;

import ec.com.bank.service.dto.RequestDto;
import feign.Headers;
import feign.RequestLine;

public interface FavoritesUpdateClient {

	@RequestLine("POST /favorite")
	@Headers("Content-Type: application/json")
	public void changeStatus(@RequestBody RequestDto req);

}