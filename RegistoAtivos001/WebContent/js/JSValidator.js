/**
 * Validação de campos de um formulário 
 */


// Validação dos campos
(function () {
	'use strict';
	window.addEventListener('load', function() {
		// Retorna os campos por classe
		var forms = document.getElementsByClassName('needs-validation');
		// Previne submissão até a validação correta
		var validation = Array.prototype.filter.call(forms, function(form) {
			form.addEventListener('submit', function(event) {
				if (form.checkValidity() === false) {
					event.preventDefault();
					event.stopPropagation();
				}
				form.classList.add('was-validated');
			}, false);
		});
	}, false);
})();