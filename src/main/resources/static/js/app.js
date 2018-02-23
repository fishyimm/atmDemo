var app = angular.module('atm', ['ui.router']);

app.config(function($stateProvider, $urlRouterProvider, $locationProvider) {
	
	$locationProvider.html5Mode(true);
	$urlRouterProvider.otherwise("/");
	
	var states = $stateProvider.state('note', {
		url: "/",
		controller : 'atmController',
		templateUrl : "/template/note"
	})
	.state('withdraw', {
		url: "/withdraw",
		controller : 'withdrawController',
		templateUrl : "/template/withdraw"
		
	});
});
app.service("baseService", function() {
	
	var notes = {
			note1000Qy: "",
			note500Qy: "",
			note100Qy: "",
			note50Qy: "",
			note20Qy: ""
		};
	
	this.setNote = function(data) {
		notes.note1000Qy = data.note1000Qy;
		notes.note500Qy = data.note500Qy;
		notes.note100Qy = data.note100Qy;
		notes.note50Qy = data.note50Qy;
		notes.note20Qy = data.note20Qy;
	};
	
	this.getNote = function() {
		return notes;
	};
	
});
app.controller("atmController", function($rootScope, $scope, $http, $state, baseService) {
	
	$scope.notes = {
		note1000Qy: "",
		note500Qy: "",
		note100Qy: "",
		note50Qy: "",
		note20Qy: ""
	};
	
	$scope.enableBtn = function() {
		return ($scope.notes.note1000Qy
				&& $scope.notes.note500Qy
				&& $scope.notes.note100Qy
				&& $scope.notes.note50Qy 
				&& $scope.notes.note20Qy);
	};
	
	$scope.addNote = function() {
		$http.post("addNote", $scope.notes).then(function(data) {
			if(data.status == 200) {
				$scope.notes.note1000Qy = data.data.note1000Qy;
				$scope.notes.note500Qy = data.data.note500Qy;
				$scope.notes.note100Qy = data.data.note100Qy;
				$scope.notes.note50Qy = data.data.note50Qy;
				$scope.notes.note20Qy = data.data.note20Qy;
				baseService.setNote($scope.notes);
				$state.go("withdraw");
			}
		}, function(data) {
			console.log("error" , data);
		});
	};
});

app.controller("withdrawController", function($rootScope, $scope, $state, $http, baseService) {
	
	$scope.amount;
	$scope.notes = baseService.getNote();

	$scope.withdraw = function() {
		$http.post("getmoney", {amount:$scope.amount}).then(function(data) {
			if(data.status == 200) {
				$scope.notes.note1000Qy = data.data.note1000Qy;
				$scope.notes.note500Qy = data.data.note500Qy;
				$scope.notes.note100Qy = data.data.note100Qy;
				$scope.notes.note50Qy = data.data.note50Qy;
				$scope.notes.note20Qy = data.data.note20Qy;	
				
				$scope.error = data.data.error;
				$scope.amount = "";
			}
			
		}, function(data) {
			console.log("error" , data);
		});
	};
	
});