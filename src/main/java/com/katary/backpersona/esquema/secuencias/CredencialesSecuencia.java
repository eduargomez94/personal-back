package com.katary.backpersona.esquema.secuencias;

import com.katary.backpersona.esquema.bd.credenciales.CredencialesDB;
import com.katary.backpersona.esquema.secuencias.seguridad.SeguridadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class CredencialesSecuencia {
    private final CredencialesDB credencialesDB;
    private final SeguridadService seguridadService;
    @Autowired
    public CredencialesSecuencia(CredencialesDB credencialesDB, SeguridadService seguridadService) {
        this.credencialesDB = credencialesDB;
        this.seguridadService = seguridadService;
    }

    public ArrayList<HashMap<String, Object>> obtenerRoles(String email) throws SQLException {
        return credencialesDB.obtenerRoles(email);
    }
    public HashMap<String, Object> ingresar(String email,String contrasena) throws Exception {
        HashMap<String, Object> user = credencialesDB.obtenerUsuario(email);
        if (user == null) {
            return null;
        }
        String md5String="";

        byte[] bytes = Base64.getDecoder().decode(contrasena);
        String originalString = new String(bytes);

            // Obtener una instancia del algoritmo MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Calcular el hash MD5 de la cadena
            byte[] hashBytes = md.digest(originalString.getBytes());

            // Convertir los bytes a una representación hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

             md5String = sb.toString();

            System.out.println("MD5: " + md5String);


        user.put("token",seguridadService.generarToken( 20));
        if(md5String.equals(user.get("Password").toString()))return user;
        return null;
    }
}
