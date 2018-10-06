var feedback = angular.module('feedbackModule', []);

feedback.controller('feedbackController', [ '$http', '$scope', function($http, $scope) {

			// here feedback is a method from html button
			$scope.feedback = function(fbdata) {
				console.log(fbdata);
				$http.post('feedback/user', fbdata).then(function(response) {
					$scope.data = response.data;
					if ($scope.data.successful) {
						alert("sucsessful");
						$scope.getFeedbackData();
					} else {
						if($scope.data.responseObject.name==null){
							document.getElementById("nameID").style.border = "2px  solid red";
						}
						}
				});
			}

			$http.post('feedback/getFeedbackData').then(function(response) {
				$scope.data = response.data;
				if ($scope.data.successful) {
					$scope.feedbackData = $scope.data.responseObject;
					console.log($scope.feedbackData);
				}
			});

			$scope.getFeedbackData = function() {
				$http.post('feedback/getFeedbackData').then(function(response) {
					$scope.data = response.data;
					if ($scope.data.successful) {
						$scope.feedbackData = $scope.data.responseObject;
						console.log($scope.feedbackData);
					}
				});
			}
	//biding data to scope
			$scope.fbUpdateByName = function(showData) {
				alert("getting data from scope");
				console.log(showData);
				var data = {};
				data.object = showData;
				$scope.data = data;
				console.log($scope.data);
				jQuery("#myModal").modal('show');

			}
	//update data into database
			$scope.fbUpdate = function(upData){
				$http.post("feedback/updateFb",upData).then(function(response){
					$scope.data = response.data;
					if($scope.data.successful){
						$scope.getFeedbackData();
						alert("Updated");
						console.log($scope.data);
					}else{
						alert("not");
					}
				});
			}
	//Delete data from database
			$scope.fbDelete = function(deleteData){
				if (confirm("Are you sure to delete this record?")) {
				$http.post("feedback/delete", deleteData).then(function(response){
					$scope.data = response.data;
					if($scope.data.successful){
						$scope.getFeedbackData();
						alert("Selected Data deleted");
					}else{
						alert("Not Deleted");
					}
				});
				}
			}
		} ]);

