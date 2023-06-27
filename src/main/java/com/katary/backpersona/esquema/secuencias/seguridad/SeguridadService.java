package com.katary.backpersona.esquema.secuencias.seguridad;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Base64;


@Service
public class SeguridadService {
    private static boolean leidas = false;


    public static String contruirToken(int cantidad) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[cantidad];
        random.nextBytes(bytes);
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        return encoder.encodeToString(bytes).substring(0, cantidad);
    }


    public String generarToken(int cantidad) throws SQLException {
        String token = contruirToken(cantidad);
        return token;
    }

}
