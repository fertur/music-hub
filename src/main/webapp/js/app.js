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
    'generoControllers',
    'usuarioControllers',
    'instrumentoControllers',
    'grupoinstrumentoControllers',
    'tonalidadobraControllers',
    'tipousuarioControllers',
    'tipoobraControllers',
    'numpapelControllers',
    'ui.bootstrap',
    'ngSanitize'
]);

openAusias.config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when('/', {templateUrl: 'js/system/home.html', controller: 'HomeController'});
        //------------
        $routeProvider.when('/home', {templateUrl: 'js/system/home.html', controller: 'HomeController'});
        $routeProvider.when('/license', {templateUrl: 'js/system/license.html', controller: 'LicenseController'});
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
        $routeProvider.when('/usuario/selection/:page?/:rpp?', {templateUrl: 'js/usuario/selection.html', controller: 'UsuarioSelectionController'});
        //------------
        $routeProvider.when('/instrumento/view/:id', {templateUrl: 'js/instrumento/view.html', controller: 'InstrumentoViewController'});
        $routeProvider.when('/instrumento/new/:id?', {templateUrl: 'js/instrumento/newedit.html', controller: 'InstrumentoNewController'});
        $routeProvider.when('/instrumento/edit/:id', {templateUrl: 'js/instrumento/newedit.html', controller: 'InstrumentoEditController'});
        $routeProvider.when('/instrumento/remove/:id', {templateUrl: 'js/instrumento/remove.html', controller: 'InstrumentoRemoveController'});
        $routeProvider.when('/instrumento/plist/:page?/:rpp?', {templateUrl: 'js/instrumento/plist.html', controller: 'InstrumentoPListController'});
        $routeProvider.when('/instrumento/selection/:page?/:rpp?', {templateUrl: 'js/instrumento/selection.html', controller: 'InstrumentoSelectionController'});
        //------------
        $routeProvider.when('/grupoinstrumento/view/:id', {templateUrl: 'js/grupoinstrumento/view.html', controller: 'GrupoinstrumentoViewController'});       
        $routeProvider.when('/grupoinstrumento/selection/:page?/:rpp?', {templateUrl: 'js/grupoinstrumento/selection.html', controller: 'GrupoinstrumentoSelectionController'});
        //------------
        $routeProvider.when('/genero/view/:id', {templateUrl: 'js/genero/view.html', controller: 'GeneroViewController'});
        $routeProvider.when('/genero/selection/:page?/:rpp?', {templateUrl: 'js/genero/selection.html', controller: 'GeneroSelectionController'});        
//        $routeProvider.when('/genero/new/:id?', {templateUrl: 'js/genero/newedit.html', controller: 'GeneroNewController'});
//        $routeProvider.when('/genero/edit/:id', {templateUrl: 'js/genero/newedit.html', controller: 'GeneroEditController'});
//        $routeProvider.when('/genero/remove/:id', {templateUrl: 'js/genero/remove.html', controller: 'GeneroRemoveController'});
        $routeProvider.when('/genero/plist/:page?/:rpp?', {templateUrl: 'js/genero/plist.html', controller: 'GeneroPListController'});
        //$routeProvider.when('/genero/selection/:page?/:rpp?', {templateUrl: 'js/tipousuario/selection.html', controller: 'UsuarioSelectionController'});
        //------------
        $routeProvider.when('/tonalidadobra/view/:id', {templateUrl: 'js/tonalidadobra/view.html', controller: 'TonalidadobraViewController'});
        $routeProvider.when('/tonalidadobra/selection/:page?/:rpp?', {templateUrl: 'js/tonalidadobra/selection.html', controller: 'TonalidadobraSelectionController'});
        //------------
        $routeProvider.when('/tipousuario/selection/:page?/:rpp?', {templateUrl: 'js/tipousuario/selection.html', controller: 'TipousuarioSelectionController'});
        $routeProvider.when('/tipousuario/view/:id', {templateUrl: 'js/tipousuario/view.html', controller: 'TipousuarioViewController'});
        //------------
        $routeProvider.when('/tipoobra/selection/:page?/:rpp?', {templateUrl: 'js/tipoobra/selection.html', controller: 'TipoobraSelectionController'});
        $routeProvider.when('/tipoobra/view/:id', {templateUrl: 'js/tipoobra/view.html', controller: 'TipoobraViewController'});
        //------------
        $routeProvider.when('/numpapel/view/:id', {templateUrl: 'js/numpapel/view.html', controller: 'NumpapelViewController'});       
        $routeProvider.when('/numpapel/plist/:page?/:rpp?', {templateUrl: 'js/numpapel/plist.html', controller: 'NumpapelPListController'});
        $routeProvider.when('/numpapel/selection/:page?/:rpp?', {templateUrl: 'js/numpapel/selection.html', controller: 'NumpapelSelectionController'});
        //------------
        $routeProvider.otherwise({redirectTo: '/'});


    }]);

var moduloSistema = angular.module('systemControllers', []);
var moduloUsuario = angular.module('usuarioControllers', []);
var moduloObra = angular.module('obraControllers', []);
var moduloGenero = angular.module('generoControllers', []);
var moduloTipousuario = angular.module('tipousuarioControllers', []);
var moduloTonalidadobra = angular.module('tonalidadobraControllers', []);
var moduloInstrumento = angular.module('instrumentoControllers', []);
var moduloGrupoinstrumento = angular.module('grupoinstrumentoControllers', []);
var moduloNumpapel = angular.module('numpapelControllers', []);
var moduloTipoobra = angular.module('tipoobraControllers', []);


