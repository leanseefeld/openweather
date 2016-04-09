var app = angular.module('LeWeather', []);
var apiUri = app.apiUri = '/openweather/rest/';

app.controller('favoritesCtrl', function ($scope, $http, $log) {
    $http.get(apiUri + 'favorites').then(function success(response) {
        $scope.favCities = response.data;
    }, function error(response) {
        $log.error(response);
    });

    $scope.newFavorite = '';
    $scope.bookmark = function bookmark() {
        $http({
            method: 'PUT',
            url: apiUri + 'favorites',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            transformRequest: function (obj) {
                var p, str = [];
                for (p in obj) {
                    str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                }
                return str.join("&");
            },
            data: {
                city: $scope.newFavorite
            }
        }).then(function success(response) {
            $log.log(response.data);
            var i, isPresent, newCity = response.data;
            for (i = 0; i < $scope.favCities.length; i++) {
                if ($scope.favCities[i].id == newCity.id) {
                    isPresent = true;
                    break;
                }
            }

            if (!isPresent) {
                $scope.favCities.push(newCity);
                $scope.$emit('favoriteAdded', newCity);
            }
            $scope.newFavorite = '';
        }, function error(response) {
            $log.error(response);
            window.alert(response.data);
        });
    };

    $scope.$on('removeFavorite', function (event, city) {
        $http.delete(app.apiUri + 'favorites/' + city.id).then(function success() {
            var i = $scope.favCities.indexOf(city);
            $scope.favCities.splice(i, 1);
        }, function error(response) {
            $log.error(response.data);
        });
    })
});