var app = angular.module('myApp', []);

app.controller('appCtrl', function($scope, $http) {
	
$http.get("/users").success(function(response) {
	$scope.users = response;
});
$scope.toggleAdd = function() {
	$scope.showView = false;
	$scope.assignView = false;
	$scope.assignFields = false;
	$scope.updateView = false;
	$scope.status = "New";
    $scope.addView = !$scope.addView;
};

$scope.toggleShow = function() {
	$scope.addView = false;
	$scope.assignView = false;
	$scope.assignFields = false;
	$scope.updateView = false;
    $scope.showView = !$scope.showView;
};

$scope.toggleAssign = function() {
	$scope.addView = false;
	$scope.showView = false;
	$scope.assignFields = false;
	$scope.updateView = false;
    $scope.assignView = !$scope.assignView;
};

$scope.toggleAssignTicket = function(id, custInfo, comment, originator) {
	$scope.assignId = id;
	$scope.assignCustomerInfo = custInfo;
	$scope.assignComments = comment;
	$scope.assignCreatedBy = originator;
	$scope.assignStatus = "Open";
	$scope.addView = false;
	$scope.showView = false;
	$scope.assignView = false;
	$scope.updateView = false;
	$scope.assignFields = !$scope.assignFields;
};

$scope.toggleUpdateTicket = function(id, custInfo, comment, originator, status, assignTo) {
	$scope.updateId = id;
	$scope.updateCustomerInfo = custInfo;
	$scope.updateComments = comment;
	$scope.updateCreatedBy = originator;
	$scope.updateStatus = status;
	$scope.updateAssignTo = assignTo;
	$scope.editable = false;
	if($scope.updateStatus == "Close")
	{
		$scope.editable = true;
	}
	$scope.addView = false;
	$scope.showView = false;
	$scope.assignView = false;
	$scope.updateView = !$scope.updateView;
	};
	
$scope.closeAllViews = function() {
	$scope.addView = false;
	$scope.showView = false;
	$scope.assignView = false;
	$scope.updateView = false;
	$scope.assignFields = false;
	};
});
