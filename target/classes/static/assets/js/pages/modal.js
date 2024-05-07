function buscar(button) {
    // Capture the value of th:data-idpersona from the clicked button
    var idUsuario = $(button).data('idusuario');

    // Create the URL to request the fragment using the captured idPersona
    var url = "../../../../usuario/" + idUsuario;

    // Load the fragment and replace content in #replace_div
    $('#replace_div').load(url, function (){
        $('#modal-form').attr('action', '/SavePerUsuario');
        $('#exampleModalScrollable2').modal('show');
    });
}