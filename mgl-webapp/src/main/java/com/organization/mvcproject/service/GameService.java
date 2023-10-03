package com.organization.mvcproject.service;

import java.util.List;
import java.util.Optional;

import com.organization.mvcproject.model.Game;

public interface GameService {

	List<com.organization.mvcproject.model.Game> retrieveAllGames();

	Game saveGame(Game game);
	
	Game updateGame(Game game);
	
	boolean deleteGame(Long id);
	
	Optional<Game> findGameById(Long id);

}