app.controller("defaultCtrl",["$scope","$http","$state",function($scope,$http,$state){
	var url = window.location.protocol+"//"+window.location.host;

	$http({
		url:url+"/category",
		method:"get"
	}).success(function(data){
		$scope.myData = data;
	});

	$scope.updataCategory = function(row){
		$state.go("app.category.modify",{category_id:row.entity.id});
	}
	$scope.goHeros = function(row){
		$state.go("app.category.heros",{category_id:row.entity.id,category_name:row.entity.name});
	}
	
	$scope.nameTemplate = '<div class="ngCellText">'+'<a  class="cmd-button " title="查看英雄" ng-click="goHeros(row)" >{{row.entity.name}}</a>'+'</div>';
    $scope.revise='<div class="ngCellText operation">'+
    '<a  class="cmd-button " ng-click="updataCategory(row)" >修改</a>'+'</div>';
	$scope.gridOptions = {
	        showColumnMenu:true,// 是否显示列头部菜单按钮
	        i18n:'zh-cn',
	        data: 'myData',
	        enableSorting : true,//是否支持排序(列)
	        enablePaging: true,
	        showFooter: true,
	        multiSelect: false,
	        groupsCollapsedByDefault:false,
	        selectedItems: $scope.mySelections,
	        columnDefs:[
	            {field: "name",displayName:"名称",cellTemplate:$scope.nameTemplate,enableCellEdit: false,width:"30%"},
	            {field: "description",displayName:"英雄描述",enableCellEdit: false,visible:true},
	            {field: "",displayName:'操作',cellTemplate:$scope.revise,enableCellEdit: false,width:"13%",class:'ngCellText'}
	        ]
	    };
}]);