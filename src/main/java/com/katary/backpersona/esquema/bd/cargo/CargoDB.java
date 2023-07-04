package com.katary.backpersona.esquema.bd.cargo;
import com.katary.backpersona.utiles.DBCoreService;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.katary.backpersona.esquema.bd.cargo.Consultas.*;
@Service
public class CargoDB {
    private final DBCoreService dbCoreService;

    public CargoDB(DBCoreService dbCoreService) {
        this.dbCoreService = dbCoreService;
    }

    public ArrayList<HashMap<String, Object>> obtenerCargos() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_CARGO_SELECT, parametros);
    }
}
	  