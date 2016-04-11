app.controller('WeatherController', function ($scope, $http, $log) {

    var baseWeatherUri = 'http://api.openweathermap.org/data/2.5/forecast?appid=' + app.openweatherKey + '&id=';

    $scope.$on('cityActivated', function (event, city) {
        if (city) {
            loadWeather();
        }
    });

    function loadWeather() {
        if ($scope.activeCity.weather) {
            $scope.weather = $scope.activeCity.weather;
        } else {
            $scope.weather = undefined;
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
