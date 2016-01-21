/*
 * Copyright (c) 2015 by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com)
 * 
 * openAUSIAS: The stunning micro-library that helps you to develop easily 
 *             AJAX web applications by using Java and jQuery
 * openAUSIAS is distributed under the MIT License (MIT)
 * Sources at https://github.com/rafaelaznar/openAUSIAS
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

'use strict';

//var appName = 'AjaxStockNg';

var openAusias = angular.module('myApp', [
    'ngRoute',
    'Filters',
    'Services',
    'Directives',
    'systemControllers',
    'obraControllers',
    'usuarioControllers',
//    'tipoobraControllers',
    'tipousuarioControllers',
    'ui.bootstrap',
    'ngSanitize'
]);

openAusias.config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when('/', {templateUrl: 'js/system/home.html', controller: 'HomeController'});
        //------------
        $routeProvider.when('/home', {templateUrl: 'js/system/home.html', controller: 'HomeController'});
        //------------
        $routeProvider.when('/obra/view/:id', {templateUrl: 'js/obra/view.html', controller: 'ObraViewController'});
        $routeProvider.when('/obra/new', {templateUrl: 'js/obra/newedit.html', controller: 'ObraNewController'});
        $routeProvider.when('/obra/edit/:id', {templateUrl: 'js/obra/newedit.html', controller: 'ObraEditController'});
        $routeProvider.when('/obra/remove/:id', {templateUrl: 'js/obra/remove.html', controller: 'ObraRemoveController'});
        $routeProvider.when('/obra/plist/:page?/:rpp?', {templateUrl: 'js/obra/plist.html', controller: 'ObraPListController'});
        //------------
        $routeProvider.when('/usuario/view/:id', {templateUrl: 'js/usuario/view.html', controller: 'UsuarioViewController'});
        $routeProvider.when('/usuario/new/:id?', {templateUrl: 'js/usuario/newedit.html', controller: 'UsuarioNewController'});
        $routeProvider.when('/usuario/edit/:id', {templateUrl: 'js/usuario/newedit.html', controller: 'UsuarioEditController'});
        $routeProvider.when('/usuario/remove/:id', {templateUrl: 'js/usuario/remove.html', controller: 'UsuarioRemoveController'});
        $routeProvider.when('/usuario/plist/:page?/:rpp?', {templateUrl: 'js/usuario/plist.html', controller: 'UsuarioPListController'});
        //------------
//        $routeProvider.when('/tipoobra/view/:id', {templateUrl: 'js/tipoobra/view.html', controller: 'TipoobraViewController'});
//        $routeProvider.when('/tipoobra/selection/:page/:rpp', {templateUrl: 'js/tipoobra/selection.html', controller: 'TipoobraSelectionController'});
        //------------
        $routeProvider.when('/tipousuario/selection/:page/:rpp', {templateUrl: 'js/tipousuario/selection.html', controller: 'TipousuarioSelectionController'});        
        //------------
        $routeProvider.otherwise({redirectTo: '/'});


    }]);

var moduloSistema = angular.module('systemControllers', []);
var moduloUsuario = angular.module('usuarioControllers', []);
var moduloObra = angular.module('obraControllers', []);
//var moduloTipoobra = angular.module('tipoobraControllers', []);
var moduloTipousuario = angular.module('tipousuarioControllers', []);

