
function abriModal(idReceta) {
    $('#id_receta2').val(idReceta);
    $.ajax({
        url: '/obtenerRecetaRemedios',
        type: 'GET',
        data: { idReceta: idReceta },
        success: function (response) {
            generarInputs(response);
            $('#modal1').modal('show');
        },
        error: function (error) {
            console.error('Error al obtener los remedios:', error);
        }
    });
}

function generarInputs(recetaRemedios) {
    var container = $('#inputsContainer');
    container.empty();

    recetaRemedios.forEach(function (remedio, index) {
        var textoOption = remedio.lista_liname.medicamento + ' - ' +
            remedio.lista_liname.codigoLiname + ' - ' +
            remedio.lista_liname.concentracion;

        var rowHtml = '<div class="row justify-content-center">' +
            '<div class="form-group col-md-6">' +
            '<label for="remedio' + index + '">Medicamento ' + (index + 1) + '</label>' +
            '<select class="form-control" id="medicamento' + index + '" name="medicamentos">' +
            '<option value="' + remedio.lista_liname.id_lista_liname + '">' + textoOption + '</option>' +
            '</select>' +
            '</div>' +
            '<div class="form-group col-md-2">' +
            '<label for="cantidadR' + index + '">Cantidad Recetada</label>' +
            '<input readonly type="text" class="form-control" id="cantidadR' + index + '" name="cantidadR" value="' + (remedio.cantidad_recetada || '') + '">' +
            '</div>' +
            '<div class="form-group col-md-2">' +
            '<label for="cantidadD' + index + '">Cantidad Dispensada</label>' +
            '<input  required type="text" class="form-control" id="cantidadD' + index + '" name="cantidadD" placeholder="Ingresar">' +
            '</div>' +
            '<div >' +
            '<input required type="hidden" class="form-control" id="id_remedio' + index + '" name="id_remedio" value="' + remedio.idRecetaRemedios + '">' +
            '</div>' +
            '</div>';

        container.append(rowHtml);
    });
}



function generarInputsClientes(dipsJson, gradosJson, estadosCivilJson) {
    var html = "";
    var tipoClient = $("#tipoCliente").val();
    var container = $('#InputsClienteNuevo');
    try {
        // Parsear los JSONs de entrada
        var dips = JSON.parse(dipsJson);
        var grados = JSON.parse(gradosJson);
        var estadosCivil = JSON.parse(estadosCivilJson);
        if (tipoClient === "N") {

            html = `
                <div class="row">
                    <div class="col-12 col-md-4 mb-3">
                        <label for="">Nombres</label>
                        <input type="text" class="form-control" placeholder="Ingrese Nombres" required>
                        <div class="valid-feedback">
                            ¡Ingrese Nombres!
                        </div>
                    </div>
                    <div class="col-12 col-md-4 mb-3">
                        <label for="">Apellido Paterno</label>
                        <input type="text" class="form-control" placeholder="Ingrese Apellido Paterno" required>
                        <div class="valid-feedback">
                            ¡Ingrese Apellido Paterno!
                        </div>
                    </div>
                    <div class="col-12 col-md-4 mb-3">
                        <label for="">Apellido Materno</label>
                        <input type="text" class="form-control" placeholder="Ingrese Apellido Materno" required>
                        <div class="valid-feedback">
                            ¡Ingrese Apellido Materno!
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12 col-md-4 mb-3">
                        <label for="">Carnet de Identidad (CI)</label>
                        <input type="text" class="form-control" placeholder="Ingrese CI" required>
                        <div class="valid-feedback">
                            ¡Ingrese Carnet de Identidad!
                        </div>
                    </div>
                    <div class="col-12 col-md-4 mb-3">
                        <label for="">Expedido</label>
                        <select class="js-example-basic-single" name="expedido" style="width: 100%;" required>
                            <option value=""></option>
                            ${dips.map(d => `<option value="${d.idDip}">${d.descripcion} - ${d.codDip}</option>`).join('')}
                        </select>
                        <div class="valid-feedback">
                            ¡Seleccione el Expedido!
                        </div>
                    </div>
                    <div class="col-12 col-md-4 mb-3">
                        <label for="">Celular</label>
                        <input type="text" class="form-control" placeholder="Ingrese Celular" required>
                        <div class="valid-feedback">
                            ¡Ingrese Celular!
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12 col-md-4 mb-3">
                        <label for="">Dirección</label>
                        <textarea class="form-control" rows="2" placeholder="Ingrese Dirección o Ubicación" required></textarea>
                        <div class="valid-feedback">
                            ¡Ingrese Dirección o Ubicación!
                        </div>
                    </div>
                    <div class="col-12 col-md-4 mb-3">
                        <label for="">Grado Académico</label>
                        <select class="js-example-basic-single" name="grado" style="width: 100%;" required>
                            <option value=""></option>
                            ${grados.map(g => `<option value="${g.idGradoAcademico}">${g.nombre_gradoAcademico}</option>`).join('')}
                        </select>
                        <div class="valid-feedback">
                            ¡Seleccione un Grado Académico!
                        </div>
                    </div>
                    <div class="col-12 col-md-4 mb-3">
                        <label for="">Estado Civil</label>
                        <select class="js-example-basic-single" name="estadoCivil" style="width: 100%;" required>
                            <option value=""></option>
                            ${estadosCivil.map(ec => `<option value="${ec.idTipoEstadoCivil}">${ec.nomEstadoCivil}</option>`).join('')}
                        </select>
                        <div class="valid-feedback">
                            ¡Seleccione un Estado Civil!
                        </div>
                    </div>
                </div>
            `;

            // Inserta el HTML generado en el contenedor
            container.html(html);

            // Re-inicia Select2 para los nuevos select
            $('.js-example-basic-single').select2({
                placeholder: "Seleccione..."
            });
        } else {
            html = `
                <div class="row">
                    <div class="col-12 col-md-12 mb-3">
                        <label for="">Carnet de Identidad</label>
                        <input type="text" class="form-control" id="ci_persona" placeholder="Ingrese CI" required>
                        <div class="valid-feedback">
                            ¡Ingrese Carnet de Identidad!
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12 col-md-12 mb-3">
                        <button style="width : 100%;
                        color: black;
                        font-weight: bold;"
                        onclick="buscarPersona()" 
                        class="btn btn-success">Buscar Persona 
                        </button>
                    </div>
                </div>
            `;
            // Inserta el HTML generado en el contenedor
            container.html(html);

            // Re-inicia Select2 para los nuevos select
            $('.js-example-basic-single').select2({
                placeholder: "Seleccione..."
            });
        }
    } catch (error) {
        console.error("Error al generar inputs:", error);
    }
}

function buscarPersona() {
    var ci = $("#ci_persona").val();

    $.ajax({
        url: '/buscarPersonaCI/' + ci,
        type: 'POST',
        success: function (response) {
            console.log("Persona encontrada:", response);
        },
        error: function (xhr, status, error) {
            console.error("Estado:", status);
            console.error("Error:", error);
            console.error("Respuesta del servidor:", xhr.responseText);
        }
    });
}

