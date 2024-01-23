package com.katary.personalback.esquema.bd.entidad;
import com.katary.personalback.utiles.DBCoreService;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.katary.personalback.esquema.bd.entidad.Consultas.*;
@Service
public class EntidadDB {
    private final DBCoreService dbCoreService;

    public EntidadDB(DBCoreService dbCoreService) {
        this.dbCoreService = dbCoreService;
    }

    public ArrayList<HashMap<String, Object>> obtenerEntidadesXTipo(String tipo) throws SQLException {
        Object[] parametros = new Object[]{tipo};
        return dbCoreService.obtenerElementos(SP_ENTIDAD_SELECT_X_TIPO, parametros);
    }
    public ArrayList<HashMap<String, Object>> obtenerEntidades() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_ENTIDAD_SELECT, parametros);
    }
    public HashMap<String, Object> obtenerEntidad(int id_entidad) throws SQLException {
        Object[] parametros = new Object[]{id_entidad};
        return dbCoreService.obtenerElemento(SP_ENTIDAD_SELECT_X_ID_ENTIDAD, parametros);
    }
    public int crearEntidad(
            int id_entidad,
            String nombre,
            String tipo

    ) throws SQLException {
        Object[] parametros = new Object[]{nombre,tipo};
        return dbCoreService.ejecutarQuery(SP_ENTIDAD_INSERT, parametros);
    }
    public int actualizarEntidad(
            int id_entidad,
            String nombre,
            String tipo

    ) throws SQLException {
        Object[] parametros = new Object[]{id_entidad,nombre,tipo};
        return dbCoreService.ejecutarQuery(SP_ENTIDAD_UPDATE_X_ID_ENTIDAD, parametros);
    }
    public HashMap<String, Object> eliminarEntidad(int id_entidad) throws SQLException {
        Object[] parametros = new Object[]{id_entidad};
        return dbCoreService.obtenerElemento(SP_ENTIDAD_DELETE_X_ID_ENTIDAD, parametros);
    }
}