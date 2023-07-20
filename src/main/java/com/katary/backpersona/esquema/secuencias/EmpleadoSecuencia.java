package com.katary.backpersona.esquema.secuencias;

import com.katary.backpersona.esquema.bd.empleado.EmpleadoDB;
import com.katary.backpersona.esquema.io.EmpleadoIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.HashMap;

@Service
public class EmpleadoSecuencia {

    private final EmpleadoDB empleadoDB;
    private final ArchivoSecuencia archivoSecuencia;

    @Autowired
    public EmpleadoSecuencia(EmpleadoDB empleadoDB, ArchivoSecuencia archivoSecuencia) {
        this.empleadoDB = empleadoDB;
        this.archivoSecuencia = archivoSecuencia;
    }

    public int crearEmpleado(EmpleadoIn.EmpleadoPOST body) throws SQLException {
        int id = empleadoDB.crearEmpleado(body);

        if (body.getFile_foto() != null && !body.getFile_foto().isEmpty()) {
            String[] parteA = body.getFile_foto().split(",");
            String base64String = parteA[1];
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);
            InputStream inputStream = new ByteArrayInputStream(decodedBytes);

            String ext = this.archivoSecuencia.getFileExtension(body.getFotografia());
            String pathFoto = this.archivoSecuencia.subirArchivo(inputStream, "foto_" + id + "_" + Calendar.getInstance().getTimeInMillis() + "." + ext);

            body.setUrl_fotografia(pathFoto);
            this.empleadoDB.actualizarEmpleadoFoto(id, body.getFotografia(), body.getUrl_fotografia());
        }

        if (body.getFile_hoja() != null && !body.getFile_hoja().isEmpty()) {
            String[] parteA = body.getFile_hoja().split(",");
            String base64String = parteA[1];
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);
            InputStream inputStream = new ByteArrayInputStream(decodedBytes);

            String ext = this.archivoSecuencia.getFileExtension(body.getHoja_vida());
            String pathHoja = this.archivoSecuencia.subirArchivo(inputStream, "hoja_" + id + "_" + Calendar.getInstance().getTimeInMillis() + "." + ext);

            body.setUrl_hoja_vida(pathHoja);
            this.empleadoDB.actualizarEmpleadoHoja(id, body.getHoja_vida(), body.getUrl_hoja_vida());
        }

        return id;
    }

    public int actualizarEmpleado(int id, EmpleadoIn.EmpleadoPUT body) throws SQLException {
        if (body.getFile_foto() != null && !body.getFile_foto().isEmpty()) {
            String[] parteA = body.getFile_foto().split(",");
            String base64String = parteA[1];
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);
            InputStream inputStream = new ByteArrayInputStream(decodedBytes);

            String ext = this.archivoSecuencia.getFileExtension(body.getFotografia());
            String pathFoto = this.archivoSecuencia.subirArchivo(inputStream, "foto_" + id + "_" + Calendar.getInstance().getTimeInMillis() + "." + ext);

            body.setUrl_fotografia(pathFoto);
            this.empleadoDB.actualizarEmpleadoFoto(id, body.getFotografia(), body.getUrl_fotografia());
        }

        if (body.getFile_hoja() != null && !body.getFile_hoja().isEmpty()) {
            String[] parteA = body.getFile_hoja().split(",");
            String base64String = parteA[1];
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);
            InputStream inputStream = new ByteArrayInputStream(decodedBytes);

            String ext = this.archivoSecuencia.getFileExtension(body.getHoja_vida());
            String pathHoja = this.archivoSecuencia.subirArchivo(inputStream, "hoja_" + id + "_" + Calendar.getInstance().getTimeInMillis() + "." + ext);

            body.setUrl_hoja_vida(pathHoja);
            this.empleadoDB.actualizarEmpleadoHoja(id, body.getHoja_vida(), body.getUrl_hoja_vida());
        }
        return empleadoDB.actualizarEmpleado(id, body);
    }

    public ArrayList<HashMap<String, Object>> obtenerEmpleados() throws SQLException {
        return empleadoDB.obtenerEmpleados();
    }

    public HashMap<String, Object> obtenerEmpleado(int id_empleado) throws SQLException {
        HashMap<String, Object> data = empleadoDB.obtenerEmpleado(id_empleado);
        if (data.get("url_fotografia") != null && data.containsKey("url_fotografia")) {
            String base64Foto = this.archivoSecuencia.descargarArchivo(data.get("url_fotografia").toString());
            data.put("file_foto", base64Foto);
        }
        if (data.get("url_hoja_vida") != null && data.containsKey("url_hoja_vida")) {
            String base64Hoja = this.archivoSecuencia.descargarArchivo(data.get("url_hoja_vida").toString());
            data.put("file_hoja", base64Hoja);
        }
        return data;
    }

    public HashMap<String, Object> eliminarEmpleado(int id_empleado) throws SQLException {
        return empleadoDB.eliminarEmpleado(id_empleado);
    }

    public ArrayList<HashMap<String, Object>> obtenerTiposDocumentos() throws SQLException {
        return empleadoDB.obtenerTiposDocumentos();
    }

    public ArrayList<HashMap<String, Object>> obtenerCiudades(int id_depto) throws SQLException {
        return empleadoDB.obtenerCiudades(id_depto);
    }

    public ArrayList<HashMap<String, Object>> obtenerDepartamentos(int id_pais) throws SQLException {
        return empleadoDB.obtenerDepartamentos(id_pais);
    }

    public ArrayList<HashMap<String, Object>> obtenerPais() throws SQLException {
        return empleadoDB.obtenerPais();
    }

    public ArrayList<HashMap<String, Object>> obtenerTipoContratos() throws SQLException {
        return empleadoDB.obtenerTipoContratos();
    }
}

