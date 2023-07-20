package com.katary.backpersona.esquema.secuencias;

import com.katary.backpersona.esquema.bd.entidad.EntidadDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class EntidadSecuencia {
    private final EntidadDB entidadDB;
    @Autowired
    public EntidadSecuencia(EntidadDB entidadDB) {
        this.entidadDB = entidadDB;
    }

    public ArrayList<HashMap<String, Object>> obtenerEntidadesXTipo(String tipo) throws SQLException {
        return entidadDB.obtenerEntidadesXTipo(tipo);
    }
    public ArrayList<HashMap<String, Object>> obtenerEntidades() throws SQLException {
        return entidadDB.obtenerEntidades();
    }
    public HashMap<String, Object> obtenerEntidad(int id_entidad) throws SQLException {
        return entidadDB.obtenerEntidad(id_entidad);
    }
    public int crearEntidad(
            int id_entidad,
            String nombre,
            String tipo

    ) throws SQLException {
        return entidadDB.crearEntidad(id_entidad,nombre,tipo);
    }
    public int actualizarEntidad(
            int id_entidad,
            String nombre,
            String tipo

    ) throws SQLException {
        return entidadDB.actualizarEntidad(id_entidad,nombre,tipo);
    }
    public HashMap<String, Object> eliminarEntidad(int id_entidad) throws SQLException {
        return entidadDB.eliminarEntidad(id_entidad);
    }
}
