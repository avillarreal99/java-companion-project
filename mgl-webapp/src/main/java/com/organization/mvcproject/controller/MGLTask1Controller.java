
package com.organization.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.service.GameService;

@Controller
public class MGLTask1Controller { // fixed

	@Autowired
	private GameService javaGameService; // fixed

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public ModelAndView review() {
		return new ModelAndView("reviewCreatePage", "command", new com.organization.mvcproject.model.Review());
	}

	@RequestMapping(value = "/addReview", method = RequestMethod.POST)
	public ModelAndView addReview(com.organization.mvcproject.model.Review review, ModelMap model) {
		if(review.getAuthor().equals("")) {
			review.setAuthor("anonymous");
		}
		return new ModelAndView("reviewDetailPage", "submittedReview", review);
	}

	
	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public ModelAndView game() {
		return new ModelAndView("gamesPage", "command", new com.organization.mvcproject.model.Game());
	}

	/**
	 * TODO 2.0 (Separation of concerns) consider moving all controller endpoints that return a ResponseEntity into a @RestController.
	 */
	
	@RequestMapping(value = "/game/gameLibrary", method = RequestMethod.GET)
	public ResponseEntity<List<com.organization.mvcproject.model.Game>> fetchAllGames() {
		return new ResponseEntity<List<com.organization.mvcproject.model.Game>>(javaGameService.retrieveAllGames(), HttpStatus.OK);
	}

	@RequestMapping(value = "game/gameDataForm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody com.organization.mvcproject.model.Game game) {
		javaGameService.saveGame(game);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}