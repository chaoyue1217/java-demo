app.controller("HerosCtrl",["$scope","$http","$state","$stateParams",function($scope,$http,$state,$stateParams){
	var url = window.location.protocol+"//"+window.location.host;
	$scope.category_id = $stateParams.category_id;
	
	$http({
		url:url+"/category/"+$scope.category_id,
		method:"get"
	}).success(function(data){
		$scope.categoryName = data.name;
	});
	
	$scope.getAll = function(){
		$http({
			url:url+"/heros/all/"+$scope.category_id,
			method:"get"
		}).success(function(data){
			$scope.heros = data;
			
		});
	}
	$scope.getAll();
	
	$scope.deleteHero = function(id){
		var ifDelete = confirm("确定删除吗?");
		if(ifDelete){
			$http({
				url:url+"/heros/"+id,
				method:"delete"
			}).success(function(){
				$scope.getAll();
			});
		}
		
	}
	
	$scope.updateHero = function(id){
		$state.go("app.category.heros_modify",{hero_id:id,category_id:$scope.category_id,category_name:$scope.categoryName});
	}

   
	
}]);
