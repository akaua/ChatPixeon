chatApp.controller( 'chat', [ 'Messages', '$scope', '$http' , '$q' , 
	function( Messages, $scope, $http , $q) {
	    // Message Inbox

	    $scope.init = function (){
	    	//$http.get('http://localhost:9999/getUser')
	    	//.success(function(data){
	    	//	console.log(data);
	    	//}).error(function(){
	    	//	console.log("ERRO EM GET: http://localhost:9999/getUser")
	    	//});
			var deferred = $q.defer();
			$http({
				method: 'GET',
				url: 'http://localhost:9999/getUser',
				headers: {
				   'Content-Type': 'application/json'//,
				   //'Access-Control-Allow-Origin':'*',
				   //'Access-Control-Allow-Headers':'Origin, X-Requested-With, Content-Type, Accept'
				 }
			}).then(function successCallback(response) {
				console.log("SUCCESS CALLBACK");
				console.log(response);
				console.log(response.data.name);
				console.log(response.data.id);
				console.log(response.data.givenName);
				deferred.resolve(response.data);
				//$scope.name = response.data.name;
			    // this callback will be called asynchronously
			    // when the response is available
			}, function errorCallback(response) {
				console.log("ERROR CALLBACK");
				console.log(response);
			});

	    	
	    	console.log("INICIO PAGINA CHAT");
	    	return deferred.promise;
	    };
	  
	    $scope.init().then(function(json){
		    $scope.messages = [];
		    $scope.user = json.name;
		    $scope.givenName = json.givenName;
		    // Receive Messages
		    Messages.user({ name : json.givenName });
		    Messages.receive(function(message){
		        $scope.messages.push(message);
		    });

		    // Send Messages
		    $scope.send = function() {
		        Messages.send({ data : $scope.textbox });
		        $scope.textbox = "";
		        //$('#textBox').focus();
		    };
	    });
	    
//	    $scope.messages = [];

	    // Receive Messages
//	    Messages.user({ name : $scope.name });
//	    Messages.receive(function(message){
//	        $scope.messages.push(message);
//	    });

	    // Send Messages
//	    $scope.send = function() {
//	        Messages.send({ data : $scope.textbox });
//	        $scope.textbox = "";
	        //$('#textBox').focus();
//	    };



//	    $window.onload = function(e) {
//	    	$scope.alerta = "PAGINA INICIOU!!!!";
//  			console.log("INICIO PAGINA CHAT");
//		}

	    
	}
]);

