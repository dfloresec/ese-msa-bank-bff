package ec.com.bank.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.okhttp.OkHttpClient;

@Configuration
public class FeignConfiguration {
	@Bean
	OkHttpClient client() {
		return new OkHttpClient();
	}
}
