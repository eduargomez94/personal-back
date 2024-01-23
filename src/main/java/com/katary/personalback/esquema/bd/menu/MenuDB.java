package com.katary.personalback.esquema.bd.menu;

import com.katary.personalback.utiles.DBCoreService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.katary.personalback.esquema.bd.menu.Consultas.SP_TAREA_SISTEMA_SELECT;

@Service
public class MenuDB {
    private final DBCoreService dbCoreService;

    public MenuDB(DBCoreService dbCoreService) {
        this.dbCoreService = dbCoreService;
    }

    public ArrayList<HashMap<String, Object>> obtenerMenus(String email, int id_rol) throws SQLException {
        Object[] parametros = new Object[]{email, id_rol};
        return dbCoreService.obtenerElementos(SP_TAREA_SISTEMA_SELECT, parametros);
    }

}

