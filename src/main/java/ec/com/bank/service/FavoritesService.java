package ec.com.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ec.com.bank.repository.FavoritesRepository;
import ec.com.bank.service.dto.RequestDto;
import ec.com.bank.service.dto.charactes.GaleryDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FavoritesService {

	private final FavoritesRepository favoritesRepository;

	public List<GaleryDto> getFavorites(String user) {
		return favoritesRepository.getFavorites(user);
	}
	
	public List<GaleryDto> allWithFavorites(String user) {
		return favoritesRepository.allWithFavorites(user);
	}
	
	public void changeStatus(RequestDto req) {
		favoritesRepository.changeStatus(req);
	}
}
