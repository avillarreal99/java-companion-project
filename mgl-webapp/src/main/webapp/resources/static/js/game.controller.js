'use strict';

angular.module('MGL_Task1_app').controller('GameController',
		[ 'GameService', function(GameService) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : ''
			};
			self.games = [];

			self.fetchAllGames = function(){
				GameService.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return GameService.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
			
			self.selectGame = function(game){
				self.game = angular.copy(game);
			}
			
			self.deleteGame = function(game){
				return GameService.deleteGame(game).then(function(){
				self.fetchAllGames();
				});
			}

			self.fetchAllGames();
		} ]);
