package com.sisu.sisu.Service.UtilidadesService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

public interface UtilidadesService {
    public byte[] generarReporte(String rutaJasper, Map<String, Object> parametros);
    public ByteArrayOutputStream compilarAndExportarReporte(String ruta, Map<String, Object> params) throws IOException, JRException, SQLException;
    public ByteArrayOutputStream Exportar_Reporte(String nombreArchivo)throws IOException, JRException, SQLException;
}
