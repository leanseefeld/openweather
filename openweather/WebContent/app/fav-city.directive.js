app.directive('favCity', function ($http) {

    return {
        restrict: 'E',
        scope: {
            city: '='
        },
        templateUrl: 'app/fav-city.template.html',
        transclude: true,
        link: linkFunc
    };

    function linkFunc($scope, $element) {
        $element.bind('mouseover', function () {
            $scope.mouseover = true;
            $scope.$apply();
        });
        $element.bind('mouseout', function () {
            $scope.mouseover = false;
            $scope.$apply();
        });
        $element.bind('click', function (event) {
            if (!$scope.city.active) {
                $scope.$root.$broadcast('cityActivated', $scope.city);
                $scope.$apply();
            }
        });

        $scope.unfavorite = function unfavorite($event) {
            $event.stopPropagation();
            $scope.$emit('removeFavorite', $scope.city);
        };
    }
});
