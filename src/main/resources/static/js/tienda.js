var guardarProducto = function(nombre) {
	/*
		todo IMPLEMENTACION DE LOGICA
	*/
};

var iniciarSesion = function() {
	

	var email = $("#correo").val();
	var password = $("#password").val();

	
	$.post("/usuario/login", { 'correo': email, 'contrasenia': password }, /*callback*/ function( fragmento ) {
 			$("#contenedor").replaceWith(fragmento);
	});
};

$(document).ready(function () {
	
	
	 jQuery.validator.addMethod("sololetrasyespacios", function (value, element) {
        return this.optional(element) || /^[a-z\s]+$/i.test(value);
    }, "Solo letras y espacios");

	
	jQuery.extend(jQuery.validator.messages, {
        required: "Este campo es obligatorio.",
        remote: "Por favor, rellena este campo.",
        email: "Por favor, escribe una dirección de correo válida",
        url: "Por favor, escribe una URL válida.",
        date: "Por favor, escribe una fecha válida.",
        dateISO: "Por favor, escribe una fecha (ISO) válida.",
        number: "Por favor, escribe un número entero válido.",
        digits: "Por favor, escribe sólo dígitos.",
        creditcard: "Por favor, escribe un número de tarjeta válido.",
        equalTo: "Por favor, escribe el mismo valor de nuevo.",
        accept: "Por favor, escribe un valor con una extensión aceptada.",
        maxlength: jQuery.validator.format("Por favor, no escribas más de {0} caracteres."),
        minlength: jQuery.validator.format("Por favor, no escribas menos de {0} caracteres."),
        rangelength: jQuery.validator.format("Por favor, escribe un valor entre {0} y {1} caracteres."),
        range: jQuery.validator.format("Por favor, escribe un valor entre {0} y {1}."),
        max: jQuery.validator.format("Por favor, escribe un valor menor o igual a {0}."),
        min: jQuery.validator.format("Por favor, escribe un valor mayor o igual a {0}.")
    });
	
	$("#forma-login").validate({
	rules: {
		correo: {
			required: true,
			maxlength: 100
		},
		password: {
			required: true,
			sololetrasyespacios:true
		}
	},
	errorPlacement: function(error, element) {
		error.appendTo(element.parent());
	},
	submitHandler: function(form) {
		form.submit();
	}

});

    
    
   });
