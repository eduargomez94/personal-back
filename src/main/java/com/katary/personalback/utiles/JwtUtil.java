package com.katary.personalback.utiles;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "mysecretkey";
    private static final long EXPIRATION_TIME = 900000;

    public static String createToken(String username, int usuarioId) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        return JWT.create()
                .withSubject(username)
                .withIssuer("auth0")
                .withClaim("usuarioId", usuarioId)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(algorithm);
    }

    public static DecodedJWT verifyTokenDec(String token) throws Exception {
        String[] split = token.split(" ");
        if (!split[0].equals("Bearer")) {
            throw new Exception("Mal estructura token");
        }
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build();
        return verifier.verify(split[1]);
    }

    public static boolean verifyToken(String token) {
        try {
            verifyTokenDec(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getUsernameFromToken(String token) throws Exception {
        DecodedJWT decodedJWT = verifyTokenDec(token);
        return decodedJWT.getSubject();
    }

    public static Integer getUsuarioIdFromToken(String token) throws Exception {
        DecodedJWT decodedJWT = verifyTokenDec(token);
        return decodedJWT.getClaim("usuarioId").asInt();
    }
}
