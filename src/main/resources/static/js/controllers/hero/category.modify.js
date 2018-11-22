app.controller("defaultCreateCtrl",["$scope","$http","$state","$stateParams",function($scope,$http,$state,$stateParams){
	var url = window.location.protocol+"//"+window.location.host;
	var id = $stateParams.category_id;
	$http({
		url:url+"/category/"+id,
		method:"get"
	}).success(function(data){
		$scope.category = data;
	})
	
	$scope.update = function(){
		var data = JSON.stringify($scope.category);
		console.log(data)
		$http({
			url:url+"/category",
			method:"put",
			data:data
		}).success(function(){
			$state.go("app.category.category");
		})
	}
	$scope.goBack = function(){
		$state.go("app.category.category");
	}
	
}]);