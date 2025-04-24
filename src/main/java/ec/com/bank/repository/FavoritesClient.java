package ec.com.bank.repository;

import java.util.List;

import ec.com.bank.service.dto.charactes.GaleryDto;
import feign.Param;
import feign.RequestLine;

public interface FavoritesClient {

	@RequestLine("GET /favorites/{user}")
	public List<GaleryDto> getFavorites(@Param("user") String user);

	@RequestLine("GET /allWithFavorites/{user}")
	public List<GaleryDto> allWithFavorites(@Param("user") String user);

}