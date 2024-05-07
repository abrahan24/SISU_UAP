function buscar(button) {
    // Capture the value of th:data-idpersona from the clicked button
    var idTipoUso = $(button).data('idtipouso');

 
    // Create the URL to request the fragment using the captured idPersona
    var url = "../../../../tipoUso/" + idTipoUso;
   
    // Load the fragment and replace content in #replace_div
    $('#replace_divTipoUso').load(url, function (){
        $('#modal-form').attr('action', '/SaveTipoUso');
        $('#exampleModalScrollableT').modal('show');
    });
}