package com.katary.personalback.esquema.bd.proyecto;

import com.katary.personalback.esquema.io.ProyectoIn;
import com.katary.personalback.utiles.DBCoreService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.katary.personalback.esquema.bd.proyecto.Consultas.*;

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

    public ArrayList<HashMap<String, Object>> obtenerProyectosActivos() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_PROYECTO_ACTIVOS_SELECT, parametros);
    }

    public HashMap<String, Object> obtenerProyecto(int id_proyecto) throws SQLException {
        Object[] parametros = new Object[]{id_proyecto};
        return dbCoreService.obtenerElemento(SP_PROYECTO_SELECT_X_ID_PROYECTO, parametros);
    }

    public int crearProyecto(ProyectoIn.ProyectoPOST body) throws SQLException {
        Object[] parametros = new Object[]{
                body.getId_cliente(),
                body.getNombre(),
                body.getDescripcion(),
                body.getId_tipo_proyecto(),
                body.getFecha_inicio(),
                body.getFecha_fin_proyectada(),
                body.getFecha_fin_real(),
                body.getValor_presupuestado(),
                body.getEstado()};
        return dbCoreService.ejecutarQuery(SP_PROYECTO_INSERT, parametros);
    }

    public int actualizarProyecto(int id_proyecto, ProyectoIn.ProyectoPUT body) throws SQLException {
        Object[] parametros = new Object[]{
                id_proyecto,
                body.getNombre(),
                body.getDescripcion(),
                body.getId_tipo_proyecto(),
                body.getFecha_inicio(),
                body.getFecha_fin_proyectada(),
                body.getFecha_fin_real(),
                body.getValor_presupuestado(),
                body.getId_cliente(),
                body.getEstado()};
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