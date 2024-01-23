package com.katary.personalback.esquema.secuencias;

import com.katary.personalback.esquema.bd.asignacion.AsignacionDB;
import com.katary.personalback.esquema.io.AsignacionIn;
import com.katary.personalback.esquema.io.ClienteIn;
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
public class AsignacionSecuencia {
    private final AsignacionDB asignacionDB;
    private final ArchivoSecuencia archivoSecuencia;

    @Autowired
    public AsignacionSecuencia(AsignacionDB asignacionDB, ArchivoSecuencia archivoSecuencia) {
        this.asignacionDB = asignacionDB;
        this.archivoSecuencia = archivoSecuencia;
    }

    public HashMap<String, Object> obtenerAsignaciones() throws SQLException {
        HashMap<String, Object> response = new HashMap<>();
        ArrayList<HashMap<String, Object>> proyectoAsignacion = asignacionDB.obtenerProyectosAsignaciones();
        ArrayList<HashMap<String, Object>> asignacionEmpleados = asignacionDB.obtenerAsignaciones();
        for (HashMap<String, Object> map : proyectoAsignacion) {
            ArrayList<HashMap<String, Object>> empleadosAsig = new ArrayList<>();
            for (HashMap<String, Object> map2 : asignacionEmpleados) {
                if (map.get("id") != null && map2.get("id_proyecto") != null && map.get("id").toString().equals((map2.get("id_proyecto").toString()))) {
                    if (map2.get("url_fotografia") != null && map2.containsKey("url_fotografia")) {
                        String base64Foto = this.archivoSecuencia.descargarArchivo(map2.get("url_fotografia").toString());
                        map2.put("file_foto", base64Foto);
                    }
                    empleadosAsig.add(map2);
                }
            }
            map.put("empleados", empleadosAsig);
        }

        ArrayList<HashMap<String, Object>> empleadosSinAsig = new ArrayList<>();
        for (HashMap<String, Object> map2 : asignacionEmpleados) {
            if (map2.get("id_proyecto") == null) {
                if (map2.get("url_fotografia") != null && map2.containsKey("url_fotografia")) {
                    String base64Foto = this.archivoSecuencia.descargarArchivo(map2.get("url_fotografia").toString());
                    map2.put("file_foto", base64Foto);
                }
                empleadosSinAsig.add(map2);
            }
        }
        response.put("data", proyectoAsignacion);
        response.put("empleadosSinAsig", empleadosSinAsig);
        return response;
    }

    public HashMap<String, Object> obtenerAsignacionesTabla() throws SQLException {
        HashMap<String, Object> response = new HashMap<>();
        ArrayList<HashMap<String, Object>> asignaciones = asignacionDB.obtenerAsignacionesTabla();
        response.put("data", asignaciones);
        return response;
    }

    public HashMap<String, Object> obtenerAsignacion(int id) throws SQLException {
        return asignacionDB.obtenerAsignacion(id);
    }

    public int crear(AsignacionIn.AsignacionPOST body) throws SQLException {
        return asignacionDB.crear(body);
    }

    public int actualizar(int id, AsignacionIn.AsignacionPUT body) throws SQLException {
        return asignacionDB.actualizar(id, body);
    }
}	  