package com.katary.backpersona.esquema.secuencias;

import com.katary.backpersona.esquema.bd.entidad.EntidadDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class EntidadSecuencia {
    private final EntidadDB entidadDB;
    @Autowired
    public EntidadSecuencia(EntidadDB entidadDB) {
        this.entidadDB = entidadDB;
    }

    public ArrayList<HashMap<String, Object>> obtenerEntidades() throws SQLException {
        return entidadDB.obtenerEntidades();
    }
}
