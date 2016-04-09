app.filter('celsius', function () {
    return function (input) {
        return (parseFloat(input) -  273.15).toFixed(2);
    }
});
