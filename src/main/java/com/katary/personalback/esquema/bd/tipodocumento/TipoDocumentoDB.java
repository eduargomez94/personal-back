package com.katary.personalback.esquema.bd.tipodocumento;

import com.katary.personalback.utiles.DBCoreService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.katary.personalback.esquema.bd.tipodocumento.Consultas.*;

@Service
public class TipoDocumentoDB {
    private final DBCoreService dbCoreService;

    public TipoDocumentoDB(DBCoreService dbCoreService) {
        this.dbCoreService = dbCoreService;
    }

    public ArrayList<HashMap<String, Object>> obtenerTiposDocumento() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_TIPO_DOCUMENTO_SELECT, parametros);
    }


}	  