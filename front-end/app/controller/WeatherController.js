app.controller("WeatherController", function($scope, $http) {
	
	/* API Key for OpenWeatherMap */
	var APPID = '6928b99d80c0bd419354f34afbcf616f';
	/* Default unit*/
	var UNIT = 'metric';
	
	/* Visibility properties*/
	$scope.showResponse = false;
	$scope.showError = false;
	
	$scope.submitCity = function() {
		if(validate()){
			$scope.showError = false;

			var url = 'http://api.openweathermap.org/data/2.5/weather';
			$http.jsonp(url, { params : {
				q : $scope.city,
				units : UNIT,
				APPID: APPID, 
				callback: 'JSON_CALLBACK'
	    	}, header : {'Content-Type' : 'application/json; charset=UTF-8'}}).
	    	success(function(data, status, headers, config) {
	    		$scope.showResponse = true;
	    		
	    		$scope.name = data.name;
	    		$scope.country = data.sys.country;
	    		$scope.humidity = data.main.humidity;
	    		$scope.pressure = data.main.pressure;
	    		$scope.temperature = data.main.temp;
	    		$scope.maxTemperature = data.main.temp_max;
	    		$scope.minTemperature = data.main.temp_min;
	    		$scope.wind = data.wind.speed;
	    	}).
	    	error(function(data, status, headers, config) {
	    		if(status == 404){
	    			$scope.showError = true;
	    			$scope.showResponse = false;
	    			$scope.errorMessage = 'Cidade não encontrada! Altere e tente novamente.';
	    		}
	    	});
		}
	};
	
	function validate(){
		if($scope.city === undefined || $scope.city === ''){
			$scope.showError = true;
			$scope.showResponse = false;
			$scope.errorMessage = 'Por favor, informe uma cidade!';
			return false;
		}
		
		return true;
	}
});