package com.katary.backpersona.esquema.secuencias;

import com.katary.backpersona.esquema.bd.asignacion.AsignacionDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class AsignacionSecuencia {
    private final AsignacionDB asignacionDB;

    @Autowired
    public AsignacionSecuencia(AsignacionDB asignacionDB) {
        this.asignacionDB = asignacionDB;
    }

    public ArrayList<HashMap<String, Object>> obtenerAsignaciones() throws SQLException {
        ArrayList<HashMap<String, Object>> proyectoAsignacion = asignacionDB.obtenerProyectosAsignaciones();
        ArrayList<HashMap<String, Object>> asignacion = asignacionDB.obtenerAsignaciones();
        for (HashMap<String, Object> map : proyectoAsignacion) {
            ArrayList<HashMap<String, Object>> newList = new ArrayList<>();
            for (HashMap<String, Object> map2 : asignacion) {
                if(map.get("Id_proyecto")!=null&&map2.get("Id_proyecto")!=null&&map.get("Id_proyecto").toString().equals((map2.get("Id_proyecto").toString()))){
                    newList.add(map2);
                }
            }
            map.put("empleado", newList);
        }
        return proyectoAsignacion;
    }

    public ArrayList<HashMap<String, Object>> obtenerProyectosAsignaciones() throws SQLException {
        ArrayList<HashMap<String, Object>> proyectoAsignacion = asignacionDB.obtenerProyectosAsignaciones();
        ArrayList<HashMap<String, Object>> asignacion = asignacionDB.obtenerAsignaciones();
        for (HashMap<String, Object> map : proyectoAsignacion) {
            for (HashMap<String, Object> map2 : asignacion) {
                if(map.get("id_proyecto").toString().equals((map2.get("id_proyecto").toString()))){
                    map.put("empleado", map2);
                }
            }
        }
        return proyectoAsignacion;
    }


}	  