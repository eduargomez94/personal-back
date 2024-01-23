package com.katary.personalback.esquema.secuencias;

import com.katary.personalback.esquema.bd.proyecto.ProyectoDB;
import com.katary.personalback.esquema.io.ProyectoIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public ArrayList<HashMap<String, Object>> obtenerProyectosActivos() throws SQLException {
        return proyectoDB.obtenerProyectosActivos();
    }

    public HashMap<String, Object> obtenerProyecto(int id_proyecto) throws SQLException {
        return proyectoDB.obtenerProyecto(id_proyecto);
    }

    public int crearProyecto(ProyectoIn.ProyectoPOST body) throws SQLException {
        return proyectoDB.crearProyecto(body);
    }

    public int actualizarProyecto(int id_proyecto, ProyectoIn.ProyectoPUT body) throws SQLException {
        return proyectoDB.actualizarProyecto(id_proyecto, body);
    }

    public HashMap<String, Object> eliminarProyecto(int id_proyecto) throws SQLException {
        return proyectoDB.eliminarProyecto(id_proyecto);
    }

    public ArrayList<HashMap<String, Object>> obtenerTipoProyectos() throws SQLException {
        return proyectoDB.obtenerTipoProyectos();
    }

}