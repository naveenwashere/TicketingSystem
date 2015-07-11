var app = angular.module('myApp', []);
app.controller('appCtrl', function($scope) {
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
	$scope.id = id;
	$scope.customerInfo = custInfo;
	$scope.comments = comment;
	$scope.createdBy = originator;
	$scope.status = "Open";
	$scope.addView = false;
	$scope.showView = false;
	$scope.assignView = false;
	$scope.updateView = false;
	$scope.assignFields = !$scope.assignFields;
};

$scope.validate = function(assignTo) {
	if(assignTo == '? undefined:undefined ?')
{
alert('You cannot leave this field blank');
}
};

$scope.toggleUpdateTicket = function(id, custInfo, comment, originator, status, assignTo) {
	$scope.id = id;
	$scope.customerInfo = custInfo;
	$scope.comments = comment;
	$scope.createdBy = originator;
	$scope.status = status;
	$scope.assignTo = assignTo;
	$scope.editable = false;
	if($scope.status == "Close")
	{
		$scope.editable = true;
	}
	$scope.addView = false;
	$scope.showView = false;
	$scope.assignView = false;
	$scope.updateView = !$scope.updateView;
	};
});
