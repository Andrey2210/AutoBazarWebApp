var carApp = angular.module('carApp', ["ngRoute"]);


carApp.controller('CarsController',
    function CarsController($scope, $http, $location) {
        $scope.currentItems = "10";
        $scope.currentSort = "id";
        $scope.pagesType = "items.jsp";
        $scope.currentMark = "";
        $scope.model = "";

        $scope.go = function go(param) {
            $http({
                method: 'POST',
                url: "/autobazar/cars/search",
                data: {'itemsOnPage': $scope.currentItems, 'sort': $scope.currentSort, 'pageType': "items"}
            }).then(function success(response) {
                $scope.cars = response.data;
                $scope.template = 'views/' + $scope.pagesType;
            });
        };

        $scope.load = function load(pageType) {
            $http({
                method: 'POST',
                url: "/autobazar/cars/search",
                data: {'pageType': pageType}
            }).then(function success(response) {
                $scope.cars = response.data;
                $scope.pagesType = pageType + '.jsp';
                $scope.template = 'views/' + $scope.pagesType;
            });
        };

        $scope.loadPage = function loadPage(pageNumber) {
            $http({
                method: 'POST',
                url: "/autobazar/cars/search",
                data: {'pageNumber': pageNumber}
            }).then(function success(response) {
                $scope.cars = response.data;
                $scope.template = 'views/' + $scope.pagesType;
            });
        };

        $scope.byMark = function byMark(mark) {
            $http({
                method: 'GET',
                url: "/autobazar/cars/search/" + mark
            }).then(function success(response) {
                $scope.models = response.data;
            });

            $http({
                method: 'POST',
                url: "/autobazar/cars/search/parameters",
                data: {'mark': mark}
            }).then(function success(response) {
                $scope.cars = response.data;
                $scope.template = 'views/' + $scope.pagesType;
            });
        };
        $scope.byModel = function byModel(model) {
            $http({
                method: 'POST',
                url: "/autobazar/cars/search/parameters",
                data: {'model': model}
            }).then(function success(response) {
                $scope.cars = response.data;
                $scope.template = 'views/' + $scope.pagesType;
            });
        };
        $http({
            method: 'POST',
            url: "/autobazar/cars/search",
            data: {}
        }).then(function success(response) {
            $scope.cars = response.data;
            $scope.template = 'views/' + $scope.pagesType;
        });
    }
);


carApp.controller('UserController',
    function UserController($scope, $http) {
        $scope.loadProfileAds = function loadProfileAds() {
            $http({
                method: 'GET',
                url: "/autobazar/profile/ads"
            }).then(function success(response) {
                $scope.cars = response.data;
                $scope.userTemplate = 'views/myAd.jsp';
            });
        };

        $scope.loadProfileSettings= function loadProfileSettings() {
            $http({
                method: 'GET',
                url: "/autobazar/profile/settings"
            }).then(function success(response) {
                $scope.user = response.data;
                $scope.userTemplate = 'views/profileSettings.jsp';
            });
        };


        $http({
            method: 'GET',
            url: "/autobazar/profile/ads"
        }).then(function success(response) {
            $scope.cars = response.data;
            $scope.userTemplate = 'views/myAd.jsp';
        });
    }
);

carApp.controller('AdminController',
    function AdminController($scope, $http) {
        $scope.loadUsers = function loadUsers() {
            $http({
                method: 'GET',
                url: "/autobazar/admin/users"
            }).then(function success(response) {
                $scope.users = response.data;
                $scope.adminTemplate = 'views/usersDashboard.jsp';
            });
        };

        $scope.loadCars= function loadCars() {
            $http({
                method: 'GET',
                url: "/autobazar/admin/cars"
            }).then(function success(response) {
                $scope.cars = response.data;
                $scope.adminTemplate = 'views/carsDashboard.jsp';
            });
        };

        $http({
            method: 'GET',
            url: "/autobazar/admin/users"
        }).then(function success(response) {
            $scope.users = response.data;
            $scope.adminTemplate = 'views/usersDashboard.jsp';
        });
    }
);