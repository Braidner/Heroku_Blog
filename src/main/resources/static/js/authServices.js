var authServices = angular.module('authServices', ['ngResource']);

authServices.factory('Authorization', ['$resource', 'Session',
    function ($resource, Session) {
        return $resource('/auth/login', {}, {
            query: {method: 'POST', params: {login: 'login', password: "password"}}
        }.then(function (res) {
                Session.create(res.data.id, res.data.user.id, res.data.user.role);
                return res.data.user;
            }));
    }]);


authServices.factory('AuthService', function ($http, Session) {
    var authService = {};

    authService.login = function (credentials) {
        return $http
            .post('/login', credentials)
            .then(function (res) {
                Session.create(res.data.id, res.data.user.id,
                    res.data.user.role);
                return res.data.user;
            });
    };

    authService.isAuthenticated = function () {
        return !!Session.userId;
    };

    authService.isAuthorized = function (authorizedRoles) {
        if (!angular.isArray(authorizedRoles)) {
            authorizedRoles = [authorizedRoles];
        }
        return (authService.isAuthenticated() &&
        authorizedRoles.indexOf(Session.userRole) !== -1);
    };

    return authService;
});