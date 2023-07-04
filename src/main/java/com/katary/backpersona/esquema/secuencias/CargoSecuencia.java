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

}	  