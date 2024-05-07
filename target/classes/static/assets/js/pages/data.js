$('#exampleModalScrollable').on('shown.bs.modal', function () {
    // Inicializa el calendario después de que el modal esté visible
    $('#customDateInput').datepicker();
});
