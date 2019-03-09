var ngApp = angular.module('ngApp', [ 'ngRoute' ]);
var oAuthHost = "http://localhost:8080";


ngApp.config(function($routeProvider,  $httpProvider) {

	$routeProvider

	.when('/', {
		templateUrl : 'index.html',
		controller : 'mainController'
	})

	.when('/elachi/book', {
		templateUrl : 'booktable.html',
		controller : 'bookTableController'
	});
	
});


ngApp.controller('mainController', function($scope, $location, $window, $log, $http) {
	$scope.currentContr = 'mainController';

	$scope.navBook = function() {
		var url = "http://" + $window.location.host + "/elachi/book";
        $log.log(url);
        $window.location.href = url;
	}
});

ngApp.controller('bookTableController', function($scope, $http) {
	
	$scope.currentContr = 'bookTableController';
	$scope.oAuthResponse = null;
	$scope.userSuccess = false;
	
	$scope.loginUser = function(login, password) {
		alert(login);
		$http({
			method : 'POST',
			crossDomain: true,
			url : oAuthHost + '/oauth/token',
			data : {username : login, password : password, grant_type : 'password'},
			headers :  {
				'Authorization': 'Basic ZWxhY2hpLWNsaWVudDplbGFjaGktc2VjcmV0',
				'Content-Type' : undefined,
			}
		}).success(function(data, status, headers, config) {
			$scope.oAuthResponse = data;
			$scope.userSuccess = true;
		}).error(function(data, status, headers, config) {
			console.log("failure message: " + JSON.stringify({
				data : data
			}));
		});
	};

});
