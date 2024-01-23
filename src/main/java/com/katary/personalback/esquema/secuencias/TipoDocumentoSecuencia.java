package com.katary.personalback.esquema.secuencias;

import com.katary.personalback.esquema.bd.tipodocumento.TipoDocumentoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class TipoDocumentoSecuencia {
    private final TipoDocumentoDB tipoDocumentoDB;

    @Autowired
    public TipoDocumentoSecuencia(TipoDocumentoDB tipoDocumentoDB) {
        this.tipoDocumentoDB = tipoDocumentoDB;
    }

    public ArrayList<HashMap<String, Object>> obtenerTiposDocumento() throws SQLException {
        return tipoDocumentoDB.obtenerTiposDocumento();
    }

}	  