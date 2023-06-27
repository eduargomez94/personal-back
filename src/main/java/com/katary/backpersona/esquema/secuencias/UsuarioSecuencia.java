package com.katary.backpersona.esquema.secuencias;

import com.katary.backpersona.esquema.bd.usuario.UsuarioDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class UsuarioSecuencia {
    private final UsuarioDB usuarioDB;
    @Autowired
    public UsuarioSecuencia(UsuarioDB codigoDB) {
        this.usuarioDB = codigoDB;
    }

    public ArrayList<HashMap<String, Object>> obtenerUsuarios() throws SQLException {
        return usuarioDB.obtenerUsuarios();
    }
}
