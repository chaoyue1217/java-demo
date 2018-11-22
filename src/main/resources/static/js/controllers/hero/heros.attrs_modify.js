app.controller("HeroAttrModifyCtrl",function($scope,$http,$state,$stateParams){
	var url = window.location.protocol + "//" + window.location.host;
	$scope.id = $stateParams.hero_id;
	$scope.category_id = $stateParams.category_id;
	$scope.hero_name = $stateParams.hero_name;
	
	$http({
		url:url+"/category/"+$scope.category_id,
		method:"get"
	}).success(function(data){
		$scope.category_name = data.name;
	});
	
	$http({
		url:url+"/attrs/"+$scope.id,
		method:"get"
	}).success(function(data){
		$scope.attrs = data
	});
	
	$scope.modifyAttrs = function(){
		var data = JSON.stringify($scope.attrs);
		$http({
			url:url+"/attrs",
			method:"put",
			data:data
		}).success(function(){
			$state.go("app.category.attrs",{"category_id":$scope.category_id,"hero_id":$scope.id,"hero_name":$scope.hero_name});
		})
	}
	
	$scope.goBack = function(){
		$state.go("app.category.attrs",{"category_id":$scope.category_id,"hero_id":$scope.id,"hero_name":$scope.hero_name});
	}
	
});