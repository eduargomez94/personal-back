package com.katary.backpersona.esquema.bd.asignacion;
import com.katary.backpersona.utiles.DBCoreService;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.katary.backpersona.esquema.bd.asignacion.Consultas.*;
@Service
public class AsignacionDB {
    private final DBCoreService dbCoreService;
    public AsignacionDB(DBCoreService dbCoreService) {
        this.dbCoreService = dbCoreService;
    }

    public ArrayList<HashMap<String, Object>> obtenerAsignaciones() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_ASIGNACION_SELECT, parametros);
    }
    public ArrayList<HashMap<String, Object>> obtenerProyectosAsignaciones() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_PROYECTO_SELECT_ASIGNACION, parametros);
    }


}	  