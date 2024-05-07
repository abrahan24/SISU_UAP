$(document).ready(function () {
        // Inicializar el selector de fecha
        $('#customDateInput').datepicker();

        // Configurar el formato de fecha deseado
        $('#customDateInput').datepicker({
            dateFormat: 'yyyy-mm-dd'
        });
});



