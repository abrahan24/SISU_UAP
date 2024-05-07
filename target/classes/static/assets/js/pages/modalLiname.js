function buscar(button) {
    // Capture the value of th:data-idpersona from the clicked button
    var idLiname = $(button).data('idlinamee');

 
    // Create the URL to request the fragment using the captured idPersona
    var url = "../../../../listLiname/" + idLiname;
   
    // Load the fragment and replace content in #replace_div
    $('#replace_divLiname').load(url, function (){
        $('#modal-form').attr('action', '/SaveLiname');
        $('#exampleModalScrollableL').modal('show');
    });
}