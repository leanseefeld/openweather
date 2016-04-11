app.filter('celsius', function () {
    return function (input, defaultValue) {
        var ret = (parseFloat(input) - 273.15);
        return angular.isNumber(ret) && !isNaN(ret) ? ret.toFixed(2) : defaultValue;
    }
});
