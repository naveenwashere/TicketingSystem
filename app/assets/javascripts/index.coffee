app = angular.module('myApp', [])
app.controller 'appCtrl', ($scope, $http) ->
  $http.get('/users').success (response) ->
    $scope.users = response
    return

  $scope.toggleAdd = ->
    $scope.showView = false
    $scope.assignView = false
    $scope.assignFields = false
    $scope.updateView = false
    $scope.status = 'New'
    $scope.addView = !$scope.addView
    return

  $scope.toggleShow = ->
    $scope.addView = false
    $scope.assignView = false
    $scope.assignFields = false
    $scope.updateView = false
    $scope.showView = !$scope.showView
    return

  $scope.toggleAssign = ->
    $scope.addView = false
    $scope.showView = false
    $scope.assignFields = false
    $scope.updateView = false
    $scope.assignView = !$scope.assignView
    return

  $scope.toggleAssignTicket = (id, custInfo, comment, originator) ->
    $scope.assignId = id
    $scope.assignCustomerInfo = custInfo
    $scope.assignComments = comment
    $scope.assignCreatedBy = originator
    $scope.assignStatus = 'Open'
    $scope.addView = false
    $scope.showView = false
    $scope.assignView = false
    $scope.updateView = false
    $scope.assignFields = !$scope.assignFields
    return

  $scope.toggleUpdateTicket = (id, custInfo, comment, originator, status, assignTo) ->
    $scope.updateId = id
    $scope.updateCustomerInfo = custInfo
    $scope.updateComments = comment
    $scope.updateCreatedBy = originator
    $scope.updateStatus = status
    $scope.updateAssignTo = assignTo
    $scope.editable = false
    if $scope.updateStatus == 'Close'
      $scope.editable = true
    $scope.addView = false
    $scope.showView = false
    $scope.assignView = false
    $scope.updateView = !$scope.updateView
    return

  $scope.closeAllViews = ->
    $scope.addView = false
    $scope.showView = false
    $scope.assignView = false
    $scope.updateView = false
    $scope.assignFields = false
    return

  $scope.toggleSearch = (id) ->
    if typeof id == 'undefined'
      alert 'Please enter a valid ticket ID.'
    $scope.closeAllViews()
    $http.get('/tickets/' + id + '/searchById').success (response) ->
      $scope.ticket = response
      obj = JSON.parse(JSON.stringify($scope.ticket))
      $scope.toggleUpdateTicket obj.id, obj.customerInfo, obj.comments, obj.createdBy, obj.status, obj.assignTo
      return
    return

  return