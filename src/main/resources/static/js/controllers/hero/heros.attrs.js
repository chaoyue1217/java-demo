app.controller("HeroAttrsCtrl",["$scope","$http","$state","$stateParams",function($scope,$http,$state,$stateParams){

	var url = window.location.protocol+"//"+window.location.host;

	$scope.id = $stateParams.hero_id;
	$scope.category_id = $stateParams.category_id;
	$scope.hero_name = $stateParams.hero_name;
	$scope.show = true;
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
		if(data){
			$scope.show = true;
			$scope.attrs = data;
		}else{
			$scope.show = false;
		}
		
	});
	
	$scope.goModifyAttrs = function(){
		$state.go("app.category.attrs_modify",{"category_id":$scope.category_id,"hero_id":$scope.id,"hero_name":$scope.hero_name})
	}
	
}]);