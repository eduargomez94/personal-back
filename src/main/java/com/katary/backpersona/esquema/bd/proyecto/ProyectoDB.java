package com.katary.backpersona.esquema.bd.proyecto;
import com.katary.backpersona.utiles.DBCoreService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.katary.backpersona.esquema.bd.proyecto.Consultas.*;
@Service
public class ProyectoDB {
    private final DBCoreService dbCoreService;
    public ProyectoDB(DBCoreService dbCoreService) {
        this.dbCoreService = dbCoreService;
    }

    public ArrayList<HashMap<String, Object>> obtenerProyectos() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_PROYECTO_SELECT, parametros);
    }
    public HashMap<String, Object> obtenerProyecto(int id_proyecto) throws SQLException {
        Object[] parametros = new Object[]{id_proyecto};
        return dbCoreService.obtenerElemento(SP_PROYECTO_SELECT_X_ID_PROYECTO, parametros);
    }
    public int crearProyecto(
            int id_proyecto,
            String nombre_proyecto,
            String descripcion,
            int id_tipo_proyecto,
            String fecha_inicio,
            String fecha_terminacion_pres,
            String fecha_terminacion_real,
            BigDecimal valor_presupuestado,
            BigDecimal valor_real,
            int id_cliente,
            String estado

            ) throws SQLException {
        Object[] parametros = new Object[]{nombre_proyecto,descripcion,id_tipo_proyecto,fecha_inicio,fecha_terminacion_pres,fecha_terminacion_real,valor_presupuestado,valor_real,id_cliente,estado};
        return dbCoreService.ejecutarQuery(SP_PROYECTO_INSERT, parametros);
    }
    public int actualizarProyecto(
            int id_proyecto,
            String nombre_proyecto,
            String descripcion,
            int id_tipo_proyecto,
            String fecha_inicio,
            String fecha_terminacion_pres,
            String fecha_terminacion_real,
            BigDecimal valor_presupuestado,
            BigDecimal valor_real,
            int id_cliente,
            String estado

            ) throws SQLException {
        Object[] parametros = new Object[]{id_proyecto,nombre_proyecto,descripcion,id_tipo_proyecto,fecha_inicio,fecha_terminacion_pres,fecha_terminacion_real,valor_presupuestado,valor_real,id_cliente,estado};
        return dbCoreService.ejecutarQuery(SP_PROYECTO_UPDATE_X_ID_PROYECTO, parametros);
    }
    public HashMap<String, Object> eliminarProyecto(int id_proyecto) throws SQLException {
        Object[] parametros = new Object[]{id_proyecto};
        return dbCoreService.obtenerElemento(SP_PROYECTO_DELETE_X_ID_PROYECTO, parametros);
    }
    public ArrayList<HashMap<String, Object>> obtenerTipoProyectos() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_TIPO_PROYECTO_SELECT, parametros);
    }


}	  