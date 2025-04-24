package ec.com.bank.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import feign.FeignException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ControllerAdvice
public class ControlExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	private ResponseEntity<Object> handlerException(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString()).body("ERROR INTERNO");
	}

	@ExceptionHandler(FeignException.class)
	private ResponseEntity<Object> handlerFeignException(FeignException ex) {

		HttpStatus statusCode = HttpStatus.valueOf(ex.status());
		if (HttpStatus.NOT_FOUND.equals(statusCode)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND.value())
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
					.body("No existen favoritos encontrados");
		}
		if (HttpStatus.UNAUTHORIZED.equals(statusCode)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value())
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString()).body("No autorizado");

		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
				.body("Existe un error interno con los servicios externos");

	}

}
