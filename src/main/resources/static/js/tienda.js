var guardarProducto = function(nombre) {
	/*
		todo IMPLEMENTACION DE LOGICA
	*/
};

var iniciarSesion = function() {
	
	//hardcode
	
	
	$.post("/usuario/login", { 'correo': "sergio.mena@uacm.edu.mx", 'contrasenia': "1234" }, /*callback*/ function( fragmento ) {
 			$("#contenedor").replaceWith(fragmento);
	});
};