var login = angular.module('reportModule', ['ui.directives', 'ui.filters']);

login.controller('reportcotroller', ['$http','$scope',function($http, $scope) {

	$http.post('report/getData').then(function(response){
		$scope.data=response.data;
		if ($scope.data.successful) {
			// here tableData is nothing but it having entire object data 
			$scope.tableData=$scope.data.responseObject;
			console.log($scope.tableData);
		} else {
			alert("Error while getting data");
		}
		
	});
			
		} ]);
