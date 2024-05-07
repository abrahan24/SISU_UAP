function buscar(button) {
    // Capture the value of th:data-idpersona from the clicked button
    var idFormaFarmaceutica = $(button).data('idfarma');

 
    // Create the URL to request the fragment using the captured idPersona
    var url = "../../../../formaFarmaceutica/" + idFormaFarmaceutica;
   
    // Load the fragment and replace content in #replace_div
    $('#replace_divFarmaceutica').load(url, function (){
        $('#modal-form').attr('action', '/SaveFarmaceutica');
        $('#exampleModalScrollableF').modal('show');
    });
}