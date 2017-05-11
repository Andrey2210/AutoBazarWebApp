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
                if(response.status == 204) {
                } else {
                    $scope.cars = response.data;
                    $scope.template = 'views/' + $scope.pagesType;
                }
            });
        };
        $scope.byModel = function byModel(model) {
            $http({
                method: 'POST',
                url: "/autobazar/cars/search/parameters",
                data: {'model': model}
            }).then(function success(response) {
                if(response.status == 204) {
                } else {
                    $scope.cars = response.data;
                    $scope.template = 'views/' + $scope.pagesType;
                }
            });
        };

        $scope.byMinPrice = function byMinPrice(price) {
            $http({
                method: 'POST',
                url: "/autobazar/cars/search/parameters",
                data: {'minPrice': price}
            }).then(function success(response) {
                if(response.status == 204) {
                } else {
                    $scope.cars = response.data;
                    $scope.template = 'views/' + $scope.pagesType;
                }
            });
        };

        $scope.byMaxPrice = function byMaxPrice(price) {
            $http({
                method: 'POST',
                url: "/autobazar/cars/search/parameters",
                data: {'maxPrice': price}
            }).then(function success(response) {
                if(response.status == 204) {
                } else {
                    $scope.cars = response.data;
                    $scope.template = 'views/' + $scope.pagesType;
                }
            });
        };

        $scope.byMinYear = function byMinYear(year) {
            $http({
                method: 'POST',
                url: "/autobazar/cars/search/parameters",
                data: {'minYear': year}
            }).then(function success(response) {
                if(response.status == 204) {
                } else {
                    $scope.cars = response.data;
                    $scope.template = 'views/' + $scope.pagesType;
                }
            });
        };

        $scope.byMaxYear = function byMaxYear(year) {
            $http({
                method: 'POST',
                url: "/autobazar/cars/search/parameters",
                data: {'maxYear': year}
            }).then(function success(response) {
                if(response.status == 204) {
                } else {
                    $scope.cars = response.data;
                    $scope.template = 'views/' + $scope.pagesType;
                }
            });
        };

        $scope.byMinEngineCapacity = function byMinEngineCapacity(capacity) {
            $http({
                method: 'POST',
                url: "/autobazar/cars/search/parameters",
                data: {'minEngineCapacity': capacity}
            }).then(function success(response) {
                if(response.status == 204) {
                } else {
                    $scope.cars = response.data;
                    $scope.template = 'views/' + $scope.pagesType;
                }
            });
        };

        $scope.byMaxEngineCapacity = function byMaxEngineCapacity(capacity) {
            $http({
                method: 'POST',
                url: "/autobazar/cars/search/parameters",
                data: {'maxEngineCapacity': capacity}
            }).then(function success(response) {
                if(response.status == 204) {
                } else {
                    $scope.cars = response.data;
                    $scope.template = 'views/' + $scope.pagesType;
                }
            });
        };

        $scope.byTransmission = function byTransmission(transmission) {
            $http({
                method: 'POST',
                url: "/autobazar/cars/search/parameters",
                data: {'transmission': transmission}
            }).then(function success(response) {
                if(response.status == 204) {
                } else {
                    $scope.cars = response.data;
                    $scope.template = 'views/' + $scope.pagesType;
                }
            });
        };

        $scope.byFuelType = function byFuelType(fuelType) {
            $http({
                method: 'POST',
                url: "/autobazar/cars/search/parameters",
                data: {'fuelType': fuelType}
            }).then(function success(response) {
                if(response.status == 204) {
                } else {
                    $scope.cars = response.data;
                    $scope.template = 'views/' + $scope.pagesType;
                }
            });
        };


        $scope.byBodyType = function byBodyType(bodyType) {
            $http({
                method: 'POST',
                url: "/autobazar/cars/search/parameters",
                data: {'bodyType': bodyType}
            }).then(function success(response) {
                if(response.status == 204) {
                } else {
                    $scope.cars = response.data;
                    $scope.template = 'views/' + $scope.pagesType;
                }
            });
        };

        $http({
            method: 'POST',
            url: "/autobazar/cars/search",
            data: {}
        }).then(function success(response) {
            if(response.status == 204) {
            } else {
                $scope.cars = response.data;
                $scope.template = 'views/' + $scope.pagesType;
            }
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
//
// carApp.controller('CommentController',
//     function CommentController($scope, $http, $location) {
//        $scope.path =  $location.path();
//         $scope.mySubmit = function mySubmit(id) {
//             if ($scope.comment) {
//                 $http({
//                     method: 'POST',
//                     url: "/autobazar/cars/comments/" + id,
//                     data: {'comment': $scope.comment}
//                 }).then(function success(response) {
//                     $scope.comments = response.data;
//                     $scope.commentTemplate = 'views/comments.jsp';
//                 });
//             }
//         };
//
//         $http({
//             method: 'GET',
//             url: "/autobazar" + $scope.path + "/comment"
//         }).then(function success(response) {
//             $scope.comments = response.data;
//             $scope.commentTemplate = 'views/comments.jsp';
//         });
//     }
// );