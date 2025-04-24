package ec.com.bank.repository;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface SecurityValidateTokenClient {

	@RequestLine("POST /validateToken")
	@Headers({ "Authorization: Bearer {token}", "clientSecret: {clientSecret}" })
	public void validateToken(@Param("token") String token, @Param("clientSecret") String clientSecret);

}