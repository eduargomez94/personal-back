package com.katary.personalback.esquema.secuencias;

import com.katary.personalback.esquema.bd.credenciales.CredencialesDB;
import com.katary.personalback.utiles.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

@Service
public class CredencialesSecuencia {
    private final CredencialesDB credencialesDB;

    @Autowired
    public CredencialesSecuencia(CredencialesDB credencialesDB) {
        this.credencialesDB = credencialesDB;
    }

    public ArrayList<HashMap<String, Object>> obtenerRoles(String email) throws SQLException {
        return credencialesDB.obtenerRoles(email);
    }

    public HashMap<String, Object> ingresar(String email, String contrasena) throws Exception {
        HashMap<String, Object> user = credencialesDB.obtenerUsuario(email);
        if (user == null) {
            return null;
        }
        String md5String;

        byte[] bytes = Base64.getDecoder().decode(contrasena);
        String originalString = new String(bytes);

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md.digest(originalString.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }

        md5String = sb.toString();
        user.put("token", JwtUtil.createToken(email, Integer.parseInt(user.get("id").toString())));
        if (md5String.equals(user.get("password").toString())){
            user.remove("password");
            return user;
        }
        return null;
    }
}
