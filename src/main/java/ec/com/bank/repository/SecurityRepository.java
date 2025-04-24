package ec.com.bank.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Repository
public class SecurityRepository {
	
	@Value("${url.security.validateToken}")
	private String url;
	
	@Value("${client_secret}")
	private String clientSecret;
	
	public void validateToken(String token) {
		SecurityValidateTokenClient client = Feign.builder()
				.encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
				.target(SecurityValidateTokenClient.class, url);
		client.validateToken(token, clientSecret);
	}
}
