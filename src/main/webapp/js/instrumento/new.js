/* 
 * Copyright (c) 2015 by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com)
 * 
 * openAUSIAS: The stunning micro-library that helps you to develop easily 
 *             AJAX web applications by using Java and jQuery
 * openAUSIAS is distributed under the MIT License (MIT)
 * Sources at https://github.com/rafaelaznar/
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
 * 
 */

'use strict';
moduloInstrumento.controller('InstrumentoNewController', ['$scope', '$routeParams', '$location', 'serverService', 'sharedSpaceService', '$filter',
    function ($scope, $routeParams, $location, serverService, sharedSpaceService, $filter) {

        $scope.ob = 'instrumento';
        $scope.op = 'new';

        $scope.title = "Edición de instrumento";
        $scope.icon = "fa-file-text-o";

        $scope.result = null;

        $scope.obj = {};
        $scope.obj.obj_grupoinstrumento = {"id": 0};
        
        if (sharedSpaceService.getFase() == 0) {

            if ($routeParams.usuario && $routeParams.usuario > 0) {
                $scope.obj.obj_usuario.id = $routeParams.usuario;
            }
            if ($routeParams.genero && $routeParams.genero > 0) {
                $scope.obj.obj_genero.id = $routeParams.genero;
            }
            if ($routeParams.tonalidadinstrumento && $routeParams.tonalidadinstrumento > 0) {
                $scope.obj.obj_tonalidadinstrumento.id = $routeParams.tonalidadinstrumento;
            }
            
        } else {
            
            $scope.obj = sharedSpaceService.getObject();
            sharedSpaceService.setFase(0);
        }

        $scope.chooseOne = function (foreignObjectName) {
            sharedSpaceService.setObject($scope.obj);
            sharedSpaceService.setReturnLink('/' + $scope.ob + '/' + $scope.op);
            sharedSpaceService.setFase(1);
            $location.path('/' + foreignObjectName + '/selection/1/10');
        }

        $scope.save = function () {
            var dateSubidaAsString = $filter('date')($scope.obj.fecha_subida, "dd/MM/yyyy");
            var dateModificacionAsString = $filter('date')($scope.obj.fecha_modificacion, "dd/MM/yyyy");
            $scope.obj.fecha_subida = dateSubidaAsString;
            $scope.obj.fecha_modificacion = dateModificacionAsString;
            //console.log({json: JSON.stringify(serverService.array_identificarArray($scope.obj))});            
            serverService.getDataFromPromise(serverService.promise_setOne($scope.ob, {json: JSON.stringify(serverService.array_identificarArray($scope.obj))})).then(function (data) {
                $scope.result = data;
            });
        };

//        $scope.$watch('obj.obj_tipodocumento.id', function () {
//            if ($scope.obj) {
//                serverService.getDataFromPromise(serverService.promise_getOne('tipodocumento', $scope.obj.obj_tipodocumento.id)).then(function (data2) {
//                    $scope.obj.obj_tipodocumento = data2.message;
//                });
//            }
//        });
        $scope.$watch('obj.obj_grupoinstrumento.id', function () {
            if ($scope.obj) {
                serverService.getDataFromPromise(serverService.promise_getOne('usuario', $scope.obj.obj_usuario.id)).then(function (data2) {
                    $scope.obj.obj_usuario = data2.message;
                });
            }
        });
        
        $scope.back = function () {
            window.history.back();
        };
        $scope.close = function () {
            $location.path('/home');
        };
        $scope.plist = function () {
            $location.path('/instrumento/plist');
        };


        //datepicker
        $scope.open1 = function () {
            $scope.popup1.opened = true;
        };
        $scope.popup1 = {
            opened: false
        };
        $scope.disabled = function (date, mode) {
            return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
        };
        $scope.dateOptions = {
            formatYear: 'yyyy',
            startingDay: 1
        };
        $scope.open2 = function () {
            $scope.popup2.opened = true;
        };
        $scope.popup2 = {
            opened: false
        };
    }]);