package com.katary.personalback.esquema.bd.credenciales;

import com.katary.personalback.utiles.DBCoreService;
import com.katary.personalback.utiles.SerializadorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import static com.katary.personalback.esquema.bd.seguridad.Consultas.*;

@Service
public class CredencialesDB {
    private final DBCoreService dbCoreService;
    SerializadorService serializadorService;

    public CredencialesDB(DBCoreService dbCoreService) {
        this.dbCoreService = dbCoreService;
    }

    public ArrayList<HashMap<String, Object>> obtenerRoles(String email) throws SQLException {
        Object[] parametros = new Object[]{email};
        return dbCoreService.obtenerElementos(SP_ROL_USUARIO_SELECT_X_EMAIL, parametros);
    }

    public HashMap<String, Object> obtenerUsuario(String email) throws SQLException, IOException {
        String[] parametros = new String[]{email};
        return dbCoreService.obtenerElemento(SP_USUARIOS_SELECT_X_EMAIL, parametros);

    }
}
