package com.katary.personalback.esquema.bd.asignacion;

import com.katary.personalback.esquema.io.AsignacionIn;
import com.katary.personalback.utiles.DBCoreService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.katary.personalback.esquema.bd.asignacion.Consultas.*;

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

    public ArrayList<HashMap<String, Object>> obtenerAsignacionesTabla() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_ASIGNACION_TABLA_SELECT, parametros);
    }

    public HashMap<String, Object> obtenerAsignacion(int id) throws SQLException {
        Object[] parametros = new Object[]{id};
        return dbCoreService.obtenerElemento(SP_ASIGNACION_SELECT_ID, parametros);
    }

    public int crear(AsignacionIn.AsignacionPOST body) throws SQLException {
        Object[] parametros = new Object[]{
                body.getId_proyecto(),
                body.getId_empleado(),
                body.getFecha_inicio(),
                body.getFecha_fin()
        };
        return dbCoreService.ejecutarQuery(SP_ASIGNACION_INSERT, parametros);
    }

    public int actualizar(int id, AsignacionIn.AsignacionPUT body) throws SQLException {
        Object[] parametros = new Object[]{
                id,
                body.getId_proyecto(),
                body.getId_empleado(),
                body.getFecha_inicio(),
                body.getFecha_fin()
        };
        return dbCoreService.ejecutarQuery(SP_ASIGNACION_UPDATE, parametros);
    }
}	  