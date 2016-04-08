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
        $element.bind('mouseover', function (e) {
            $scope.mouseover = true;
            $scope.$apply();
        });
        $element.bind('mouseout', function (e) {
            $scope.mouseover = false;
            $scope.$apply();
        });

        $scope.unfavorite = function unfavorite() {
            $scope.$emit('removeFavorite', $scope.city);
        };
    }
});
