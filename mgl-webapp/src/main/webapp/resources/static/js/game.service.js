'use strict';

angular.module('MGL_Task1_app').service('GameService', ['$http', function($http) {

		var REST_SERVICE_URI = 'game/';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame,
			updateGame : updateGame,
			deleteGame : deleteGame
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI + 'gameLibrary').then(function(response) {
					return response.data;
				}
			);
		}

		function createGame(game) {
			return $http.post(REST_SERVICE_URI + 'gameDataForm', game).then(function(response) {
					return response.data;
				}
			);
		}
		
		function updateGame(game){
			return $http.put(REST_SERVICE_URI, game).then(function(response){
				return response.data;
			});
		}
		
		function deleteGame(game){
			return $http.delete(REST_SERVICE_URI + game.id).then(function(response){
				return response.data;
			});
		}

}]);
