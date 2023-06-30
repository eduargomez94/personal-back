package com.katary.backpersona.esquema.bd.entidad;
import com.katary.backpersona.utiles.DBCoreService;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.katary.backpersona.esquema.bd.entidad.Consultas.*;
@Service
public class EntidadDB {
    private final DBCoreService dbCoreService;

    public EntidadDB(DBCoreService dbCoreService) {
        this.dbCoreService = dbCoreService;
    }

    public ArrayList<HashMap<String, Object>> obtenerEntidades(String tipo) throws SQLException {
        Object[] parametros = new Object[]{tipo};
        return dbCoreService.obtenerElementos(SP_ENTIDAD_SELECT_X_TIPO, parametros);
    }
}