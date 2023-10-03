package com.organization.mvcproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.model.Game;
import com.organization.mvcproject.repository.GameDAO;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameDAO gameDAO;
	
	@Override
	public List<Game> retrieveAllGames(){
		return gameDAO.retrieveAllGames();
	}

	@Override
	public Game saveGame(Game game) {
		return gameDAO.saveGame(game);
	}
	
	@Override
	public Game updateGame(Game game)
	{
		return gameDAO.saveGame(game);
	}

	@Override
	public boolean deleteGame(Long id)
	{
		return gameDAO.deleteGame(id);
	}
	
	@Override
	public Optional<Game> findGameById(Long id)
	{
		Optional<Game> foundGame = gameDAO.findGameById(id);
		return (foundGame.isPresent()) ? foundGame: null;
	}
}