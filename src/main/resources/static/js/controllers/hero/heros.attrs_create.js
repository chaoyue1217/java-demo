app.controller("HeroAttrsCreateCtrl",["$scope","$http","$state","$stateParams",function($scope,$http,$state,$stateParams){
	var url = window.location.protocol + "//" + window.location.host;
	$scope.hero_id = $stateParams.hero_id;
	$scope.category_id = $stateParams.category_id;
	$scope.hero_name = $stateParams.hero_name;
	$scope.attrs = {
			heroId:$scope.hero_id
	}
	$http({
		url:url+"/category/"+$scope.category_id,
		method:"get"
	}).success(function(data){
		$scope.category_name = data.name;
	});
	
	$scope.addAttrs = function(){
		var data = JSON.stringify($scope.attrs);
		$http({
			url:url+"/attrs",
			method:"post",
			data:data
		}).success(function(){
			$state.go("app.category.attrs",{"category_id":$scope.category_id,"hero_id":$scope.hero_id,"hero_name":$scope.hero_name});
		})
	}
	
	$scope.goBack = function(){
		$state.go("app.category.heros",{"category_id":$scope.category_id,"category_name":$scope.category_name});
	};
	
}]);