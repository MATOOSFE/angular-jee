/**
 * Creación de controlador 
 */
(function(){
	var dato = {nombre:'mtoscano', clave:'123', visible:true};
	var app = angular.module('mod_seguridad', []);
	app.controller('SeguridadControl', function() {
		this.usuario = dato;
	});
})();