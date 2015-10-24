var postControllers = angular.module('postControllers', ['ngRoute']);

postControllers.controller('PostListCtrl', ['$scope', 'Post', function ($scope, Post) {
    $scope.posts = Post.query();
}]);

postControllers.controller('PostCtrl', ['$scope', '$routeParams', 'Post', function ($scope, $routeParams, Post) {
    $scope.post = Post.get({postId: $routeParams.postId});
}]);