app.filter('start', function () {
    return function (input, start) {
        if (input) {
            return input.slice(Math.min(start, input.length - 1));
        }
    }
});
