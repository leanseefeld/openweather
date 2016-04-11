app.controller('WeatherController', function ($scope, $http, $timeout, $log) {

    var baseWeatherUri = 'http://api.openweathermap.org/data/2.5/forecast?appid=' + app.openweatherKey + '&id=';

    $scope.$on('cityActivated', function (event, city) {
        if (city) {
            loadWeather();
        }
    });

    function loadWeather() {
        $scope.weather = undefined;
        if ($scope.activeCity.weather) {
            $timeout(function () {
                $scope.weather = $scope.activeCity.weather;
            }, 200);
        } else {
            $http.get(baseWeatherUri + $scope.activeCity.id).then(
                function success(response) {
                    $scope.weather = $scope.activeCity.weather = response.data.list;
                },
                function error(response) {
                    $log.error(response);
                });
        }
    }

});
