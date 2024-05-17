function cargarInformacion() {
    // Obtener el valor del campo de entrada
    var codigoUniversitario = $("#validationCustom01").val().trim();

    // Verificar si el campo está vacío
    if (codigoUniversitario === "") {
        Swal.fire({
            title: 'El campo no puede estar Vacío!',
            icon: "warning",
            showConfirmButton: false,
            timer: 1500
        });
        return;
    }

    // Hacer la solicitud AJAX para obtener información del universitario
    $.ajax({
        type: "GET",
        url: "/universitarioC",
        data: { codigoUniversitario: codigoUniversitario },
        success: function (data) {
            // Verificar si el servidor devolvió "error"
            if (data === "error") {
                Swal.fire({
                    title: 'Ingrese un Código de Universitario Válido!',
                    icon: "warning",
                    showConfirmButton: false,
                    timer: 1500
                });
                return;
            }

            // Actualizar los campos del modal con los valores obtenidos
            if (data && data.nombreUniversitario) {
                $("#nombreUniversitario").val(data.nombreUniversitario);
                $('#apPaterno').val(data.apPaterno);
                $('#apMaterno').val(data.apMaterno);
                $("#ci").val(data.ci);
                $("#ru").val(data.ru);
                $("#fechaNacimiento").val(data.fechaNacimiento);
                $("#direccion").val(data.direccion);
                $("#correo").val(data.correo);
                $("#celular").val(data.celular);
                $("#carrera").val(data.carrera);
                $("#tipoSanguineo").val(data.tipoSanguineo);
                $("#sexo").val(data.sexo);

                // Mostrar el modal solo si los datos se obtuvieron correctamente
                if (data.estadoMatriculacion == 'true') {
                    $("#myModal").modal("show");
                    $("#estadoMatriculacion").val("ACTIVO").css("color", "green");
                    // Cambiar el texto y la acción del botón en función del estado de matriculación
                    $("#generarFichaButton").text("Generar Ficha");
                } else {
                    $("#estadoMatriculacion").val("INACTIVO").css("color", "red");
                    Swal.fire({
                        title: 'Matrícula Inactiva, Debe Ingresar una Matrícula Activa en la Gestión Actual!',
                        icon: "warning",
                        showConfirmButton: false,
                        timer: 1500
                    });
                }
            } else {
                alert("No se encuentran datos válidos para el código universitario proporcionado.");
            }
        },
        error: function(error) {
            console.error("Error en la solicitud AJAX", error);
            Swal.fire({
                title: 'Error en la solicitud AJAX!',
                icon: "error",
                showConfirmButton: false,
                timer: 1500
            });
        }
    });
}

// Función para manejar la generación de la ficha
function generarFicha() {
    var servicio = $("select[name='servicio']").val();

    
    if (!servicio || isNaN(servicio)) {
        Swal.fire({
            title: 'Debe seleccionar un Servicio!',
            icon: "warning",
            showConfirmButton: false,
            timer: 1500
        });
        return;
    }

    $.ajax({
        type: "POST",
        url: "/generarFichaCaja",
        data: { servicio: servicio }, // Enviar el servicio también en esta solicitud
        success: function (data) {
            $("#myModal").modal("hide");
            if (data == "exito") {
                Swal.fire({
                    title: 'Se Registro la Ficha con Exitoso!',
                    icon: "success",
                    showConfirmButton: false,
                    timer: 1500
                });
                // Redireccionar a la página de inicioCliente después de la alerta de éxito
                setTimeout(function () {
                    location.href = "../../../../Ficha";
                }, 2000);
            } else if (data == "error") {
                Swal.fire({
                    title: 'No está habilitado para generar Fichas, debe apersonarse a SISU y verificar sus datos',
                    icon: "warning",
                    showConfirmButton: false,
                    timer: 1500
                });
                // Redireccionar a la página de inicioCliente después de la alerta de éxito
                setTimeout(function () {
                    location.href = "../../../../Ficha";
                }, 2000);
            } else {
                Swal.fire({
                    title: 'Usted ya tiene una ficha en la fecha actual',
                    icon: "warning",
                    showConfirmButton: false,
                    timer: 1500
                });
                // Redireccionar a la página de inicioCliente después de la alerta de éxito
                setTimeout(function () {
                    location.href = "../../../../Ficha";
                }, 2000);
            }
        },
        error: function (error) {
            console.error("Error en Generar la Ficha", error);
            Swal.fire({
                title: 'Error en Generar la Ficha. Consulta la consola para más detalles',
                icon: "error",
                showConfirmButton: false,
                timer: 1500
            });
        }
    });
}

// Asignar el evento click al botón generarFichaButton solo cuando se muestra el modal
$("#myModal").on('shown.bs.modal', function () {
    $("#generarFichaButton").off("click").on("click", generarFicha);
});


function cargarInformacion2() {
    // Obtener el valor del campo de entrada
    var codigoDocente = $("#codigoDocenteInput").val().trim();

    // Verificar si el campo está vacío
    if (codigoDocente === "") {
        Swal.fire({
            title: 'El campo no puede estar Vacío!',
            icon: "warning",
            showConfirmButton: false,
            timer: 1500
        });
        return;
    }

    // Hacer la solicitud AJAX para obtener información del docente
    $.ajax({
        type: "GET",
        url: "/docenteC",
        data: { codigoDocente: codigoDocente },
        success: function (data) {
            // Verificar si el servidor devolvió "error"
            if (data === "error") {
                Swal.fire({
                    title: 'Ingrese un Código de Docente Válido!',
                    icon: "warning",
                    showConfirmButton: false,
                    timer: 1500
                });
                return;
            }

            // Actualizar los campos del modal con los valores obtenidos
            if (data) {
                $("#DatosDocente").val(data.DatosDocente);
                $("#apellidoPaterno").val(data.apellidoPaterno);
                $("#apellidoMaterno").val(data.apellidoMaterno);
                $("#ciD").val(data.ci);
                $("#rd").val(data.rd);
                $("#gradoAcademicoD").val(data.gradoAcademicoD);
                $("#titulo").val(data.titulo);
                $("#fechaNacimientoD").val(data.fechaNacimiento);
                $("#tipoSanguineoD").val(data.tipoSanguineoD);
                $("#sexoD").val(data.sexo);
                $("#direccionD").val(data.direccion);
                $("#celularD").val(data.celular);
                $("#correoD").val(data.correo);
                $("#asignatura").val(data.asignatura);
                $("#tipoDocente").val(data.tipoDocente);
                $("#carrera").val(data.carrera);
                $("#facultad").val(data.facultad);

                // Mostrar el modal solo si los datos se obtuvieron correctamente
                if (data.activo == 'true') {
                    $("#myModal2").modal("show");
                    $("#activo").val("ACTIVO").css("color", "green");
                    // Cambiar el texto y la acción del botón en función del estado de matriculación
                    $("#generarFichaButton2").text("Generar Ficha");
                } else {
                    $("#estadoMatriculacion").val("INACTIVO").css("color", "red");
                    Swal.fire({
                        title: 'Matrícula Inactiva, Debe Ingresar una Matrícula Activa en la Gestión Actual!',
                        icon: "warning",
                        showConfirmButton: false,
                        timer: 1500
                    });
                }
            } else {
                alert("No se encuentran datos válidos para el código de docente proporcionado.");
            }
        },
        error: function(error) {
            console.error("Error en la solicitud AJAX", error);
            Swal.fire({
                title: 'Error en la solicitud AJAX!',
                icon: "error",
                showConfirmButton: false,
                timer: 1500
            });
        }
    });
}

// Función para manejar la generación de la ficha
function generarFicha2() {
    var servicio = $("select[name='servicio2']").val();

    if (!servicio || isNaN(servicio)) {
        Swal.fire({
            title: 'Debe seleccionar un Servicio!',
            icon: "warning",
            showConfirmButton: false,
            timer: 1500
        });
        return;
    }

    $.ajax({
        type: "POST",
        url: "/generarFichaDocCaja",
        data: { servicio: servicio }, // Enviar el servicio también en esta solicitud
        success: function (data) {
            $("#myModal2").modal("hide");
            if (data == "exito") {
                Swal.fire({
                    title: 'Se Registro la Ficha con Exitoso!',
                    icon: "success",
                    showConfirmButton: false,
                    timer: 1500
                });
                // Redireccionar a la página de inicioCliente después de la alerta de éxito
                setTimeout(function () {
                    location.href = "../../../../Ficha";
                }, 2000);
            } else if (data == "error") {
                Swal.fire({
                    title: 'No está habilitado para generar Fichas, debe apersonarse a SISU y verificar sus datos',
                    icon: "warning",
                    showConfirmButton: false,
                    timer: 1500
                });
                // Redireccionar a la página de inicioCliente después de la alerta de éxito
                setTimeout(function () {
                    location.href = "../../../../Ficha";
                }, 2000);
            } else {
                Swal.fire({
                    title: 'Usted ya tiene una ficha en la fecha actual',
                    icon: "warning",
                    showConfirmButton: false,
                    timer: 1500
                });
                // Redireccionar a la página de inicioCliente después de la alerta de éxito
                setTimeout(function () {
                    location.href = "../../../../Ficha";
                }, 2000);
            }
        },
        error: function (error) {
            console.error("Error en Generar la Ficha", error);
            Swal.fire({
                title: 'Error en Generar la Ficha. Consulta la consola para más detalles',
                icon: "error",
                showConfirmButton: false,
                timer: 1500
            });
        }
    });
}

// Asignar el evento click al botón generarFichaButton solo cuando se muestra el modal
$("#myModal2").on('shown.bs.modal', function () {
    $("#generarFichaButton2").off("click").on("click", generarFicha2);
});

function cargarInformacion3() {
    // Obtener el valor del campo de entrada
    var codigoAdministrativo = $("#codigoAdministrativoInput").val().trim();

    // Verificar si el campo está vacío
    if (codigoAdministrativo === "") {
        Swal.fire({
            title: 'El campo no puede estar Vacío!',
            icon: "warning",
            showConfirmButton: false,
            timer: 1500
        });
        return;
    }

    // Hacer la solicitud AJAX para obtener información del administrativo
    $.ajax({
        type: "GET",
        url: "/administrativoC",
        data: { codigoAdministrativo: codigoAdministrativo },
        success: function (data) {
            // Verificar si el servidor devolvió "error"
            if (data === "error") {
                Swal.fire({
                    title: 'Ingrese un Código de Administrativo Válido!',
                    icon: "warning",
                    showConfirmButton: false,
                    timer: 1500
                });
                return;
            }

            // Actualizar los campos del modal con los valores obtenidos
            if (data) {
                $("#nombreA").val(data.nombresA);
                $("#apPaternoA").val(data.apPaternoA);
                $("#apMaternoA").val(data.apMaternoA);
                $("#CA").val(data.CA);
                $("#ciA").val(data.ciA);
                $("#fechaNacimientoA").val(data.fechaNacimientoA);
                $("#sexoA").val(data.sexoA);
                $("#gmailA").val(data.gmailA);
                $("#descripcionA").val(data.descripcionA);
                $("#descripcionA2").val(data.descripcionA2);
                $("#nivel").val(data.nivel);

                // Mostrar el modal solo si los datos se obtuvieron correctamente
                $("#myModal3").modal("show");
                $("#generarFichaButton2").text("Generar Ficha");
            } else {
                alert("No se encuentran datos válidos para el código administrativo proporcionado.");
            }
        },
        error: function (error) {
            
            Swal.fire({
                title: 'Ingrese un código de Administrativo Correcto!',
                icon: "warning",
                showConfirmButton: false,
                timer: 1500
            });
        }
    });
}

// Función para manejar la generación de la ficha
function generarFicha3() {
    var servicio = $("select[name='servicio3']").val();

    if (!servicio || isNaN(servicio)) {
        Swal.fire({
            title: 'Debe seleccionar un Servicio!',
            icon: "warning",
            showConfirmButton: false,
            timer: 1500
        });
        return;
    }

    $.ajax({
        type: "POST",
        url: "/generarFichaAdmCaja",
        data: { servicio: servicio }, // Enviar el servicio también en esta solicitud
        success: function (data) {
            $("#myModal3").modal("hide");
            if (data == "exito") {
                Swal.fire({
                    title: 'Se Registro la Ficha con Exitoso!',
                    icon: "success",
                    showConfirmButton: false,
                    timer: 1500
                });
                // Redireccionar a la página de inicioCliente después de la alerta de éxito
                setTimeout(function () {
                    location.href = "../../../../Ficha";
                }, 2000);
            } else if (data == "error") {
                Swal.fire({
                    title: 'No está habilitado para generar Fichas, debe apersonarse a SISU y verificar sus datos',
                    icon: "warning",
                    showConfirmButton: false,
                    timer: 1500
                });
                // Redireccionar a la página de inicioCliente después de la alerta de éxito
                setTimeout(function () {
                    location.href = "../../../../Ficha";
                }, 2000);
            } else {
                Swal.fire({
                    title: 'Usted ya tiene una ficha en la fecha actual',
                    icon: "warning",
                    showConfirmButton: false,
                    timer: 1500
                });
                // Redireccionar a la página de inicioCliente después de la alerta de éxito
                setTimeout(function () {
                    location.href = "../../../../Ficha";
                }, 2000);
            }
        },
        error: function (error) {
            console.error("Error en Generar la Ficha", error);
            Swal.fire({
                title: 'Error en Generar la Ficha. Consulta la consola para más detalles',
                icon: "error",
                showConfirmButton: false,
                timer: 1500
            });
        }
    });
}

// Asignar el evento click al botón generarFichaButton solo cuando se muestra el modal
$("#myModal3").on('shown.bs.modal', function () {
    $("#generarFichaButton3").off("click").on("click", generarFicha3);
});