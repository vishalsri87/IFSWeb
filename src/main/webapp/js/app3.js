var app = angular.module('dataLoggerApp',['ui.router','ngSanitize', 'ui.select','ngGrid','ngTable']);


app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    
	$urlRouterProvider.otherwise('/');
        
    $stateProvider
    .state('home', {url:'/', views: {'': {templateUrl: 'views/home.html'}}})
    .state('mapping', {url:'/mapping', views: {'': {templateUrl: 'views/mapping.html', controller: 'mappingCtrl'}}})
        
}]);


app.filter('propsFilter', function() {
	  return function(items, props) {
	    var out = [];

	    if (angular.isArray(items)) {
	      items.forEach(function(item) {
	        var itemMatches = false;

	        var keys = Object.keys(props);
	        for (var i = 0; i < keys.length; i++) {
	          var prop = keys[i];
	          var text = props[prop].toLowerCase();
	          if (item[prop].toString().toLowerCase().indexOf(text) !== -1) {
	            itemMatches = true;
	            break;
	          }
	        }

	        if (itemMatches) {
	          out.push(item);
	        }
	      });
	    } else {
	      out = items;
	    }

	    return out;
	  }
	});

app.controller('mappingCtrl', function($scope, $http) {
  var base_url = window.location.origin;
  
  var DestinationTable_URL = base_url + '/SD/getDestinationTableName';
  var SourceTable_URL = base_url + '/SD/getSourceTableName';
  var LoadSourceColumn_URL = base_url + '/SD/getSourceColumnName/';
  var LoadDestinationColumn_URL = base_url + '/SD/getDestinationColumnName/';
  
  $scope.mainObj = {};
  $scope.myData ={};
  $scope.clear = function() {
    $scope.destinations.selected = undefined;
    $scope.sources.selected = undefined;
   
  };
  
  $http.get(DestinationTable_URL).success(function(data, status, headers, config) {
	   $scope.destinations = data;
		
	}).error(function(data, status, headers, config) {
		alert('error');
	})
  
  $scope.loadDestinationColumns = function(){
		$http.get(LoadDestinationColumn_URL + $scope.mainObj.selectDestination).success(function(data, status, headers, config) {
			$scope.destinationColumns = data;
		}).error(function(data, status, headers, config) {
			alert('error');
		})
	}
  
  $http.get(SourceTable_URL).success(function(data, status, headers, config) {
	   $scope.sources = data;
		
	}).error(function(data, status, headers, config) {
		alert('error');
	})
	
	$scope.loadSourcesColumns = function(){
		$http.get(LoadSourceColumn_URL + $scope.mainObj.selectSource).success(function(data, status, headers, config) {
			$scope.sourceColumns = data;
		}).error(function(data, status, headers, config) {
			alert('error');
		})
	}
  
  $scope.loadGridData = function(){
	  var myData = $scope.mainObj;
	  $scope.gridData=angular.toJson(myData);
	  $scope.gridData = [{
			  "selectDestination": $scope.mainObj.selectDestination,
			  "selectDestinationColumns" :$scope.mainObj.selectDestinationColumns,
				  "selectSource":$scope.mainObj.selectSource,
				  "selectSourceColumns" : $scope.mainObj.selectSourceColumns
	  }];
  }
  
  
  $scope.gridOptions = {
	      data: 'gridData',
	      showFooter:false,
	      footerVisible: false,
 		 footerTemplate:false,
	      columnDefs: [
	          		    {field:'selectDestination', displayName:'Destination', width: "150"}, 
	          		    {field:'selectDestinationColumns', displayName:'Destination Column', width: "150"}, 
	          		    {field:'selectSource', displayName:'Source', width: "150"}, 
	          			{field:'selectSourceColumns', displayName:'Source Column', width: "150"}
	          		    ]
	    };
  });

