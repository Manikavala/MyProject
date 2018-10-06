var login = angular.module('formModule', []);

login.controller('FormController', ['$http','$scope',function($http, $scope) {

			// here login is a method from html button
			$scope.login = function(logindata) {
				console.log(logindata);
				$http.post('login/user', logindata).then(function(response) {
					console.log(response);
					$scope.data = response.data;
					if($scope.data.successful){
						alert("sucsessful login");
						console.log($scope.data.responseObject);
						Andromeda.setSessionValue("userName", $scope.data.responseObject.userName);
						Andromeda.setSessionValue("password", $scope.data.responseObject.password);
						Andromeda.setSessionValue("role", 	  $scope.data.responseObject.role);
						
						console.log(Andromeda.getSessionValue("userName"));
						console.log(Andromeda.getSessionValue("password"));
						console.log(Andromeda.getSessionValue("role"));
						if($scope.data.responseObject.role==1){
							Andromeda.showPage('html/adminLogin.html','loginChange');	
						}else{
							Andromeda.showMainPage();
							
						}					
					}else{
						alert("not logedin");
					}
					});
			}
		} ]);
