package com.katary.backpersona.esquema.secuencias;

import com.katary.backpersona.esquema.bd.proyecto.ProyectoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class ProyectoSecuencia {
    private final ProyectoDB proyectoDB;
    @Autowired
    public ProyectoSecuencia(ProyectoDB proyectoDB) {
        this.proyectoDB = proyectoDB;
    }

    public ArrayList<HashMap<String, Object>> obtenerProyectos() throws SQLException {
        return proyectoDB.obtenerProyectos();
    }
    public HashMap<String, Object> obtenerProyecto(int id_proyecto) throws SQLException {
        return proyectoDB.obtenerProyecto(id_proyecto);
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
        return proyectoDB.crearProyecto(id_proyecto,nombre_proyecto,descripcion,id_tipo_proyecto,fecha_inicio,fecha_terminacion_pres,fecha_terminacion_real,valor_presupuestado,valor_real,id_cliente,estado);
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
        return proyectoDB.actualizarProyecto(id_proyecto,nombre_proyecto,descripcion,id_tipo_proyecto,fecha_inicio,fecha_terminacion_pres,fecha_terminacion_real,valor_presupuestado,valor_real,id_cliente,estado);
    }
    public HashMap<String, Object> eliminarProyecto(int id_proyecto) throws SQLException {
        return proyectoDB.eliminarProyecto(id_proyecto);
    }

}	  