/**
 * Controlador para manejar productos
 * 
 * @param $scope
 */
(function() {
	var modTes = angular.module('mod_test', []);
	var app = angular.module('mod_inventario', []);
	var serviceURI = "/curso_angular/rest/";
	
	app.controller('inventarioController', ['$scope','$http',function($scope,$http){
		$scope.producto = {};
		$scope.productos = [];
		$scope.tipoProductos = [];
		
		consultarProductos($scope,$http);
		consultarTipoProductos($scope, $http);
		
		$scope.anadirProducto = function(producto){
			$http.post(serviceURI + "productos",producto).success(function(data){
				$scope.productos.push(data);
			}).error(function(error){
				alert("No se pudo añadir un producto!");
			});
		}
		
		$scope.actualizarProducto = function(producto){
			$http.put(serviceURI + "productos",producto).success(function(data){
				if(data=="OK"){
					$scope.productos[$scope.id] = producto;
				}
			}).error(function(error){
				alert("No se pudo actualizar producto!");
			});
		}
		
		$scope.eliminarProducto = function(index){
			$http.delete(serviceURI + "productos/" + $scope.productos[index].prodCodigo).success(function(data){
				if(data=="OK"){
					$scope.productos.splice(index,1);
				}
			}).error(function(error){
				alert("No se pudo eliminar producto!");
			});
		}
		
		$scope.editarProducto = function(index){
			$scope.id = index;
			$scope.producto = $scope.productos[index];
		}
		
	}]);
	
	function consultarProductos($scope,$http){
		$http.get(serviceURI + "productos").success(function(data){
			$scope.productos = data;
		}).error(function(error){
			alert("No se puedo cargar los productos!" + error);
		});
	}
	
	function consultarTipoProductos($scope,$http){
		$http.get(serviceURI + "tipoProductos").success(function(data){
			$scope.tipoProductos = data;
		}).error(function(error){
			alert("No se puedo cargar los tipoProductos!" + error);
		});
	}

})();
