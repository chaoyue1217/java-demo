app.controller("HerosCreateCtrl",["$scope","$http","$state","$stateParams",function($scope,$http,$state,$stateParams){
	var url = window.location.protocol+"//"+window.location.host;
	$scope.category_id = $stateParams.category_id;
	$http({
		url:url+"/category/"+$scope.category_id,
		method:"get"
	}).success(function(data){
		$scope.category_name = data.name;
	});
	
	$scope.addHeros = function(){
		$scope.upload(function(){
			$scope.hero.categoryId = $scope.category_id;
			var data = JSON.stringify($scope.hero);
			$http({
				url:url+"/heros/",
				method:"post",
				data:data
			}).success(function(data){
				$state.go("app.category.heros",{category_id:$scope.category_id})
			})
		});
	}
	
	$scope.goBack = function(){
		$state.go("app.category.heros",{category_id:$scope.category_id})
	}
	
	$scope.upload = function(callback){
		var formData = new FormData($( "#fileForm" )[0]);
		var file = $("#fileInput").val();
		$.ajax({
			url:url+"/heros/file",
			method:"post",
			data: formData,
			contentType: false,
            processData: false,
            success:function(data){
            	if(!(data=="img/")){
            		$scope.hero.imgUrl = data;
            	}else{
            		$scope.hero.imgUrl = "img/a0.jpg";
            	}
            	callback();
            }
		})
	}
	
	//图片上传
 	$scope.myImage='';
    $scope.myCroppedImage='';
    $scope.cropType="square";

    var handleFileSelect=function(evt) {
      var file=evt.currentTarget.files[0];
      var reader = new FileReader();
      reader.onload = function (evt) {
        $scope.$apply(function($scope){
          $scope.myImage=evt.target.result;
        });
      };
      reader.readAsDataURL(file);
    };
    angular.element(document.querySelector('#fileInput')).on('change',handleFileSelect);
	
}]);