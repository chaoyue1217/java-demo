app.controller("HerosModifyCtrl",["$scope","$http","$state","$stateParams",function($scope,$http,$state,$stateParams){
	var id = $stateParams.hero_id;
	$scope.category_name = $stateParams.category_name;
	$scope.category_id = $stateParams.category_id;
	var url = window.location.protocol+"//"+window.location.host;
	$http({
		url:url+"/heros/"+id,
		method:"get"
	}).success(function(data){
		$scope.hero = data;
	})
	
	$scope.update = function(){
		$scope.upload(function(){
			var data = JSON.stringify($scope.hero);
			$http({
				url:url+"/heros/",
				method:"put",
				data:data
			}).success(function(data){
				$state.go("app.category.heros",{category_id:$scope.category_id})
			})
		});
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
            	}
            	callback();
            }
		})
	}
	
	$scope.goBack = function(){
		$state.go("app.category.heros",{category_id:$scope.category_id});
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
	
}])