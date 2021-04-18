$(document).ready(function() {

	$('#ancho').attr('value', ''); 
	$('#alto').attr('value', ''); 
	$('#cantidad').attr('value', ''); 

	$("#descargarExcel").click(function() {
		var today = new Date();
		var dd = String(today.getDate()).padStart(2, '0');
		var mm = String(today.getMonth() + 1).padStart(2, '0');
		var yyyy = today.getFullYear();
		today = dd + '/' + mm + '/' + yyyy;
		var name = 'CortesVentanas-' + today;
		$("#tablaProyecto").table2excel({
			exclude: ".noExport",
			filename: name,
			columns: [0, 1, 2, 3, 4, 5, 6, 7, 8]
		});
	});


	$("#btnEliminar").click(function() {
		var opcion = confirm("Estás seguro que deseas eliminar el proyecto?");
		if (opcion == true) {
			$("#formEliminar").submit();
		}
		else {
			return 0;
		}

	}
	);


});