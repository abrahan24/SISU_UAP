function buscar(button) {
    // Capture the value of th:data-idpersona from the clicked button
    var idHistorialLiname = $(button).data('idhistorial');

 
    // Create the URL to request the fragment using the captured idPersona
    var url = "../../../../historialLiname/" + idHistorialLiname;
   
    // Load the fragment and replace content in #replace_div
    $('#replace_divHistorial').load(url, function (){
        $('#modal-form').attr('action', '/SaveHistorial');
        $('#exampleModalScrollableH').modal('show');
    });
}