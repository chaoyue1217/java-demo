'use strict';

/**
 * Config for the router
 */
angular.module('app')
  .run(
    [          '$rootScope', '$state', '$stateParams',
      function ($rootScope,   $state,   $stateParams) {
          $rootScope.$state = $state;
          $rootScope.$stateParams = $stateParams;        
      }
    ]
  )
  .config(
    [          '$stateProvider', '$urlRouterProvider',
      function ($stateProvider,   $urlRouterProvider) {
          
          $urlRouterProvider
              .otherwise('/app/category/category');
          $stateProvider
              .state('app', {
                  abstract: true,
                  url: '/app',
                  templateUrl: 'tpl/app.html'
              })            
              .state("app.category",{
            	  url:"/category",
            	  template:'<div ui-view></div>'
              })
              .state('app.category.category', {
                  url: '/category',
                  templateUrl: 'tpl/hero/category.html',
                  resolve:{
                	  deps:["$ocLazyLoad",function($ocLazyLoad){
                		  return $ocLazyLoad.load("ngGrid").then(function(){
                			  return $ocLazyLoad.load("js/controllers/hero/category.js")
                		  })
                	  }]
                  }
              })
              .state('app.category.modify', {
                  url: '/modify',
                  templateUrl: 'tpl/hero/category.modify.html',
                  params:{category_id:null},
                  resolve:{
                	  deps:["$ocLazyLoad",function($ocLazyLoad){
                			 return $ocLazyLoad.load("js/controllers/hero/category.modify.js")
                	  }]
                  }
              })
              .state("app.category.heros",{
            	  url:"/heros",
            	  templateUrl:"tpl/hero/heros.html",
            	  params:{category_id:null,category_name:null},
            	  resolve:{
            		  deps:["$ocLazyLoad",function($ocLazyLoad){
            			  return $ocLazyLoad.load("ngGrid").then(function(){
                			  return $ocLazyLoad.load("js/controllers/hero/heros.js")
                		  })
            		  }]
            	  }
              })
              .state("app.category.heros_modify",{
            	  url:"/heros_modify",
            	  templateUrl:"tpl/hero/heros.modify.html",
            	  params:{hero_id:null,category_id:null,category_name:null},
            	  resolve:{
            		  deps:["$ocLazyLoad",function($ocLazyLoad){
            			  return $ocLazyLoad.load("ngImgCrop").then(function(){
                			  return $ocLazyLoad.load("js/controllers/hero/heros.modify.js")
                		  })
            		  }]
            	  }
              })
              .state("app.category.heros_create",{
            	  url:"/heros_create",
            	  templateUrl:"tpl/hero/heros.create.html",
            	  params:{category_id:null},
            	  resolve:{
            		  deps:["$ocLazyLoad",function($ocLazyLoad){
            			  return $ocLazyLoad.load("ngImgCrop").then(function(){
                			  return $ocLazyLoad.load("js/controllers/hero/heros.create.js")
                		  })
            		  }]
            	  }
              })
               .state("app.category.attrs",{
            	  url:"/attrs",
            	  templateUrl:"tpl/hero/heros.attr.html",
            	  params:{hero_id:null,hero_name:null,category_id:null},
            	  resolve:{
            		  deps:["$ocLazyLoad",function($ocLazyLoad){
            			  return $ocLazyLoad.load("js/controllers/hero/heros.attrs.js");
            		  }]
            	  }
              })
              .state("app.category.attrs_create",{
            	  url:"/attrs_create",
            	  templateUrl:"tpl/hero/heros.attrs_create.html",
            	  params:{hero_id:null,hero_name:null,category_id:null},
            	  resolve:{
            		  deps:["$ocLazyLoad",function($ocLazyLoad){
            			  return $ocLazyLoad.load("js/controllers/hero/heros.attrs_create.js");
            		  }]
            	  }
              })
              .state("app.category.attrs_modify",{
            	  url:"/attrs_modify",
            	  templateUrl:"tpl/hero/heros.attrs_modify.html",
            	  params:{hero_id:null,hero_name:null,category_id:null},
            	  resolve:{
            		  deps:["$ocLazyLoad",function($ocLazyLoad){
            			  return $ocLazyLoad.load("js/controllers/hero/heros.attrs_modify.js");
            		  }]
            	  }
              })
              .state('app.hero', {
                  url: '/hero',
                  templateUrl: 'tpl/hero/hero.html'
              })
      }
    ]
  );