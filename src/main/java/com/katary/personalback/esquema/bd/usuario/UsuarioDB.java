package com.katary.personalback.esquema.bd.usuario;

import com.katary.personalback.utiles.DBCoreService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.katary.personalback.esquema.bd.usuario.Consultas.SP_USUARIOS_SELECT;

@Service
public class UsuarioDB {
    private final DBCoreService dbCoreService;

    public UsuarioDB(DBCoreService dbCoreService) {
        this.dbCoreService = dbCoreService;
    }
    public ArrayList<HashMap<String, Object>> obtenerUsuarios() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_USUARIOS_SELECT, parametros);
    }
}
