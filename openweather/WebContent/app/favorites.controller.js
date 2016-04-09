app.controller('FavoritesController', function ($scope, $http, $log) {
    var apiUri = app.apiUri;

    $http.get(apiUri + 'favorites').then(function success(response) {
        $scope.favCities = response.data;
    }, function error(response) {
        $log.error(response);

        // TODO: for testing without the server; remove when complete
        $scope.favCities = [{
            "country": "BR",
            "favorite": true,
            "id": 3468879,
            "lat": -48.9175,
            "lon": -27.09806,
            "name": "Brusque",
            weather: [] // here is the most relevant data
        }];
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
                    if (obj.hasOwnProperty(p)) {
                        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                    }
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
                if ($scope.favCities[i].id === newCity.id) {
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
            if ($scope.activeCity === city) {
                onCityActivated(event, undefined);
            }
        }, function error(response) {
            $log.error(response.data);
        });
    });

    $scope.$on('cityActivated', function (event, city) {
        onCityActivated(event, city);
    });

    function onCityActivated(event, city) {
        if ($scope.activeCity) {
            $scope.activeCity.active = false;
        }
        $scope.activeCity = city;
        if (city) {
            $scope.activeCity.active = true;
        }
    }
});
