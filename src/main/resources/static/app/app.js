(function (angular) {
    angular.module("rest-with-angular-js.controllers", []);
    angular.module("rest-with-angular-js.services", []);
    angular.module("rest-with-angular-js", ["ngResource", "rest-with-angular-js.controllers", "rest-with-angular-js.services"]);
}(angular));