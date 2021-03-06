var app = angular.module('myApp', []);

app.controller('appCtrl', function($scope, $http) {
  $http.get('/users').success(function(response) {
    $scope.users = response;
  });
  
  if(window.localStorage.getItem('userInSession') !== null)
  {
  $scope.loginState = true;
  $scope.loggedInUser = window.localStorage.getItem('userInSession');
  }
  else
  {
  $scope.loginState = false;
  $scope.loggedInUser = "";
  }
    
  $scope.toggleAdd = function() {
    $scope.showView = false;
    $scope.showAllView = false;
    $scope.assignFields = false;
    $scope.updateView = false;
    $scope.status = 'New';
    $scope.createdBy = $scope.loggedInUser;
    $scope.addView = !$scope.addView;
  };
  
  $scope.toggleShow = function() {
    $scope.addView = false;
    $scope.showAllView = false;
    $scope.assignFields = false;
    $scope.updateView = false;
    $scope.showView = !$scope.showView;
  };
  
  $scope.toggleAssign = function() {
    $scope.addView = false;
    $scope.showView = false;
    $scope.assignFields = false;
    $scope.updateView = false;
    $scope.showAllView = !$scope.showAllView;
  };
  
  $scope.toggleAssignTicket = function(id, custInfo, comment, originator) {
    $scope.assignId = id;
    $scope.assignCustomerInfo = custInfo;
    $scope.assignComments = comment;
    $scope.assignCreatedBy = originator;
    $scope.assignStatus = 'Open';
    $scope.addView = false;
    $scope.showView = false;
    $scope.showAllView = false;
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
    if ($scope.updateStatus === 'Close') {
      $scope.editable = true;
    }
    $scope.addView = false;
    $scope.showView = false;
    $scope.showAllView = false;
    $scope.updateView = !$scope.updateView;
  };
  
  $scope.closeAllViews = function() {
    $scope.addView = false;
    $scope.showView = false;
    $scope.showAllView = false;
    $scope.updateView = false;
    $scope.assignFields = false;
  };
  
  $scope.toggleSearch = function(id) {
    if (typeof id === 'undefined') {
      alert('Please enter a valid ticket ID.');
    }
    $scope.closeAllViews();
    $http.get('/tickets/' + id + '/searchById').success(function(response) {
      var obj;
      $scope.ticket = response;
      obj = JSON.parse(JSON.stringify($scope.ticket));
      $scope.toggleUpdateTicket(obj.id, obj.customerInfo, obj.comments, obj.createdBy, obj.status, obj.assignTo);
    });
  };
  
  $scope.deleteTicket = function(id) {
    $http.post('/tickets/' + id + '/delete').success(function(response) {
      $scope.ticket = response;
      location.reload(true);
    });
  };
  
  $scope.toggleLogin = function(username, password) {
    $http.get('/users/' + username + '/' + password + '/login').success(function(response) {
      
      if(response === true) {
      $scope.storeSessionInfo(username);
      location.reload(true);  
      }

      if(response === false) {
	$scope.loginState = false;
	alert('Invalid Username/Passowrd. Please try again!');
      }
      
    });
    
  $scope.storeSessionInfo = function(username) {
  window.localStorage.setItem('userInSession', username);
  };
  };
  
  $scope.toggleLogout = function() {
	window.localStorage.removeItem('userInSession');
	location.reload(true);  
  };
});

