var registration = angular.module("RegistrationModule", []);
registration.controller("RegistrationController", [	'$http','$scope',function($http, $scope) {
			$scope.registration = function(registerData) {
				console.log(registerData);
				$http.post('register/user', registerData).then(function(response) {
							$scope.data = response.data;
							console.log($scope.data);
							if ($scope.data.successful) {
								alert("inserted successfully");
								$scope.getAllUsers();
							} else {
								//alert("Data Not inserted");
								if($scope.data.responseObject.mobileNumber==null){
									document.getElementById("mobileID").style.border = "1px  solid red";
									
									$("#fID").show();
								}
								
							}
						});
			}

			$scope.checkTarget=function(data,targetName){
				data.targetName=targetName;
				
				$http.post('register/checkMobile', data).then(function(response) {
							$scope.data1 = response.data;
							console.log($scope.data1);
							if ($scope.data1.successful) {
								document.getElementById(targetName).style.border = "1px  solid green";
								$("#sID").show();
								$("#fID").hide();
							
							} else {
									document.getElementById(targetName).style.border = "1px  solid red";
									$("#fID").show();
									$("#sID").hide();
								}
						});
			}
			
			// Get all data From Database based on Name

			$http.post('register/getAllUsers').then(function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					$scope.userData = $scope.data.responseObject;
					console.log($scope.userData);
				} else {
					alert("Error while getting data");
				}

			});

			$scope.getAllUsers = function() {
				$http.post('register/getAllUsers').then(function(response) {
					$scope.data = response.data;
					if ($scope.data.successful) {
						$scope.userData = $scope.data.responseObject;
						console.log($scope.userData);
					} else {
						alert("Error while getting data");
					}

				});
			}

			// Show related Userdata from Scope
			$scope.updateById = function(showData) {
				alert("getting data from scope");
				console.log(showData);
				var data = {};
				data.object = showData;
				$scope.data = data;
				console.log($scope.data);
				jQuery("#myModal").modal('show');

			}

			// Update Data into Database
			$scope.updateData = function(updateData) {
				alert("Reg JS")
				$http.post('register/update', updateData).then(
						function(response) {
							$scope.data = response.data;
							if ($scope.data.successful) {
								$scope.getAllUsers();
								alert("Updated successfully");
							} else {
								alert("Data Not Updated");
							}
						});
			}
			// Delete data from
			$scope.deleteRegData = function(deleteRegData) {
				
				if (confirm("Are you sure to delete this record?")) {
					$http.post('register/deleteRegData', deleteRegData).then(
							function(response) {
								$scope.data = response.data;
								if ($scope.data.successful) {
									alert("deletion of data successfull");
									$scope.getAllUsers();
								} else {
									alert("data not deleted")
								}
							});
				}
			}

		} ]);