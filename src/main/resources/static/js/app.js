'use strict';

var blogApp = angular.module('blogApp', [
    'ngRoute',
    'ngResource',
    'ngAnimate',
    'angular-loading-bar',
    'postControllers',
    'postServices',
    'loginControllers'
]).run(['$rootScope', '$location', '$window', 'cfpLoadingBar',
    function ($rootScope, $location, $window, cfpLoadingBar) {
        $rootScope.$on('$routeChangeStart',
            function () {
                cfpLoadingBar.start();
            }
        );
        $rootScope.$on('$routeChangeSuccess',
            function () {
                cfpLoadingBar.complete();
                if (!$window.ga) {
                    return;
                }
                $window.ga('send', 'pageview', {
                    page: $location.path()
                });
            }
        );
    }]);

blogApp.config(['$routeProvider', '$locationProvider',
    function ($routeProvider, $locationProvider) {
        $routeProvider.
            when('/', {
                templateUrl: '/angular/templates/posts.html',
                controller: 'PostListCtrl'
            }).
            when('/blog/:postId', {
                templateUrl: '/angular/templates/post.html',
                controller: 'PostCtrl'
            }).
            when('/auth/:method', {
                templateUrl: '/angular/templates/login.html',
                controller: 'Navigation'
            }).
            otherwise({
                redirectTo: '/'
            });
        $locationProvider.html5Mode(true);
    }]);