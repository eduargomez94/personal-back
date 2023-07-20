package com.katary.backpersona.esquema.secuencias;

import com.katary.backpersona.esquema.bd.cargo.CargoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class CargoSecuencia {
    private final CargoDB cargoDB;
    @Autowired
    public CargoSecuencia(CargoDB cargoDB) {
        this.cargoDB = cargoDB;
    }

    public ArrayList<HashMap<String, Object>> obtenerCargos() throws SQLException {
        return cargoDB.obtenerCargos();
    }
    public HashMap<String, Object> obtenerCargo(int id_cargo) throws SQLException {
        return cargoDB.obtenerCargo(id_cargo);
    }
    public int crearCargo(
            int id_cargo,
            String descripcion_cargo,
            int id_categoria
            ) throws SQLException {
        return cargoDB.crearCargo(id_cargo,descripcion_cargo,id_categoria);
    }
    public int actualizarCargo(
            int id_cargo,
            String descripcion_cargo,
            int id_categoria
            ) throws SQLException {
        return cargoDB.actualizarCargo(id_cargo,descripcion_cargo,id_categoria);
    }
    public HashMap<String, Object> eliminarCargo(int id_cargo) throws SQLException {
        return cargoDB.eliminarCargo(id_cargo);
    }

}	  