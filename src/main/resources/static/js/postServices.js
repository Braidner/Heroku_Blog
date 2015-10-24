var postServices = angular.module('postServices', ['ngResource']);

postServices.factory('Post', ['$resource',
    function ($resource) {
        return $resource('/rest/post/:postId', {}, {
            query: {method: 'GET', params: {postId: 'all'}, isArray: true}
        });
    }]);