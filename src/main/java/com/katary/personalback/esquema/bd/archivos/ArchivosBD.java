package com.katary.personalback.esquema.bd.archivos;

import com.katary.personalback.utiles.DBCoreService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

import static com.katary.personalback.esquema.bd.archivos.Consultas.SP_ARCHIVO_INSERT;

@Service
public class ArchivosBD {
    private final DBCoreService dbCoreService;

    public ArchivosBD(DBCoreService dbCoreService) {
        this.dbCoreService = dbCoreService;
    }

    public int crear(String nombre, String url) throws SQLException {
        Object[] parametros = new Object[]{nombre, url};
        return dbCoreService.ejecutarQuery(SP_ARCHIVO_INSERT, parametros);
    }

}	  