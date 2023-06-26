/**
 * Copyright 2022 Leito. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.katary.backpersona.utiles;


import com.google.common.base.Charsets;
import com.google.common.io.ByteSource;
import com.google.common.io.ByteStreams;
import com.google.gson.JsonObject;
import io.undertow.util.StatusCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * Esta clase es una clase de utilidades para manejar todas las peticiones, esto
 * me brinda flexibilidad y rendimiento ya que empleo serializadores minimizando
 * la necesidad de hacer copias del contenido del request y parseos a String
 * innecesarios.
 */
@Service
public class FrameworkService {

    private final static Logger logger = LoggerFactory.getLogger(FrameworkService.class);

    private static final String UTF8 = StandardCharsets.UTF_8.name();
    private static final byte[] RESPONSE_ERROR_403 = "FORBIDDEN".getBytes(StandardCharsets.UTF_8);
    private static final byte[] RESPONSE_ERROR_500 = "{\"code\":500,\"error\":\"internal server error\"}"
            .getBytes(StandardCharsets.UTF_8);

    private static final String LOCALHOST_IPV4 = "127.0.0.1";
    private static final String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";

    private final SerializadorService serializadorService;

    @Autowired
    FrameworkService(SerializadorService serializadorService) {
        this.serializadorService = serializadorService;
    }


    /*==================================================================================================================
     * MANEJADORES
     *=================================================================================================================*/


    /**
     * @param req:      la petición enviada por el usuario, necesaria por seguridad
     * @param resp:     el actual puntero de intercambio http
     * @param response: bytes con los datos de entrega en el intercambio http
     * @param tipo:     Tipo de elemento retornado al cliente
     */
    public void sendBYTES(HttpServletRequest req, HttpServletResponse resp, byte[] response, int length, String tipo)
            throws IOException {
        resp.setContentType(tipo);
        try (ServletOutputStream out = resp.getOutputStream()) {
            out.write(response, 0, length);
        }
    }

    /**
     * Finaliza el intercambio HTTP con el string proporcionado y lo escribe en el
     * response
     *
     * @param resp:     el actual puntero de intercambio http
     * @param response: estructura final con los datos de entrega en el intercambio
     *                  http
     */
    public void sendJSON(HttpServletResponse resp, HashMap<String, Object> response) throws IOException {
        resp.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try (ServletOutputStream outputStream = resp.getOutputStream()) {
            serializadorService.serialize(response, outputStream);
        }
    }


    /**
     * Finaliza el intercambio HTTP con el string proporcionado y lo escribe en el
     * response
     *
     * @param resp:    el actual puntero de intercambio http
     * @param entrada: parámetros requeridos por la petición
     */
    public void sendBadRequestJSON(HttpServletResponse resp, Object entrada) throws IOException {
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        resp.setContentType(MediaType.APPLICATION_JSON_VALUE);

        HashMap<String, Object> response = new HashMap<>();
        response.put("code", 400);
        if (entrada != null) {
            Field[] parametros = entrada.getClass().getDeclaredFields();
            HashMap<String, String> campos = new HashMap<>(parametros.length);
            for (Field param : parametros) {
                if (param.getAnnotatedType().getType().equals(Pattern.class))
                    continue;
                campos.put(param.getName(), param.getType().getSimpleName());
            }
            response.put("required", campos);
        } else {
            response.put("message", "invalid input");
        }

        try (ServletOutputStream out = resp.getOutputStream()) {
            serializadorService.serialize(response, out);
        }
    }


    /**
     * Finaliza el intercambio HTTP con el string proporcionado y lo escribe en el
     * response
     *
     * @param resp:  el actual puntero de intercambio http
     * @param error: excecion para manejar
     */
    public void sendErrorJSON(HttpServletResponse resp, Exception error) throws IOException {
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        resp.setContentType(MediaType.APPLICATION_JSON_VALUE);

        if (Env.PERSONA_ENVIRONMENT != null && Env.PERSONA_ENVIRONMENT.equals("DEBUG")) {
            HashMap<String, Object> hm = new HashMap<>();
            hm.put("code", 0);
            hm.put("error", error.getMessage());
            hm.put("trace", Arrays.toString(error.getStackTrace()));
            try (ServletOutputStream out = resp.getOutputStream()) {
                serializadorService.serialize(hm, out);
            }
            return;
        }

        try (ServletOutputStream out = resp.getOutputStream()) {
            out.write(RESPONSE_ERROR_500);
        }
    }


    /**
     * Finaliza el intercambio HTTP con el string de no autorizado
     *
     * @param resp: el actual puntero de intercambio http
     */
    public void sendForbiddenTEXT(HttpServletResponse resp) throws IOException {
        resp.setStatus(StatusCodes.FORBIDDEN);
        resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
        try (ServletOutputStream out = resp.getOutputStream()) {
            out.write(RESPONSE_ERROR_403);
        }
    }

    /**
     * Finaliza el intercambio HTTP con el string de no encontrado
     *
     * @param resp: el actual puntero de intercambio http
     */
    public void sendNotFound(HttpServletResponse resp) throws IOException {
        resp.setStatus(StatusCodes.NOT_FOUND);
        resp.setContentType(MediaType.APPLICATION_JSON_VALUE);
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("code", 404);
        hm.put("data", new HashMap<>());
        try (ServletOutputStream out = resp.getOutputStream()) {
            serializadorService.serialize(hm, out);
        }
    }

    /**
     * Finaliza el intercambio HTTP con el string proporcionado y lo escribe en el
     * response
     *
     * @param resp: el actual puntero de intercambio http
     * @param resp: cadena final de entrega en el intercambio http
     */
    public void sendTEXT(HttpServletResponse resp, String response) throws IOException {
        resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
        try (ServletOutputStream out = resp.getOutputStream()) {
            out.write(response.getBytes(StandardCharsets.UTF_8));
        }
    }

    /*==================================================================================================================
     *  obtener body raw
     *=================================================================================================================*/

    /**
     * Transforma el cuerpo de la petición a una clase establecida, elaborado a
     * nivel medio de rendimiento podriamos crear los precompilados de las clases
     * pero es innecesario ese nivel de optimizacion para esta tarea, con este nivel
     * es suficiente parta esta tarea
     *
     * @param req           HttpServletRequest
     * @param acumularClass
     * @return HashMap
     * @throws IOException cuando no pueda crear el reader
     */
    public <T> T getBody(HttpServletRequest req, Class<T> acumularClass) throws IOException {
        req.setCharacterEncoding(UTF8);

        byte[] arr = new byte[0];
        try {
            InputStream inputStream = req.getInputStream();
            arr = ByteStreams.toByteArray(inputStream);
            return serializadorService.deserialize(acumularClass, arr);
        } catch (Exception err) {
            logger.error(
                    ByteSource.wrap(arr)
                            .asCharSource(Charsets.UTF_8)
                            .read()
                            .replaceAll("\\r\\n|\\r|\\n", " ")
            );
            return null;
        }
    }


    /**
     * Finaliza el intercambio HTTP con el string proporcionado y lo escribe en el
     * response
     *
     * @param resp: el actual puntero de intercambio http
     * @param resp: cadena final de entrega en el intercambio http
     */
    public void sendNoContent(HttpServletResponse resp) {
        resp.setStatus(StatusCodes.NO_CONTENT);
    }


    /**
     * * Get the current network ip
     *
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "Unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {

                // According to the network card to get the IP of the machine configuration
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }
        if (ipAddress != null && ipAddress.length() > 15) {
            // "**.***.***.***".length() = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }


    /**
     * Finaliza el intercambio HTTP con el string proporcionado y lo escribe en el
     * response
     *
     * @param resp:     el actual puntero de intercambio http
     * @param response: estructura final con los datos de entrega en el intercambio
     *                  http
     */
    public void sendGSON(HttpServletResponse resp, JsonObject response) throws IOException {
        resp.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try (ServletOutputStream out = resp.getOutputStream()) {
            out.write(response.toString().getBytes(StandardCharsets.UTF_8));
        }
    }


    /**
     * Finaliza el intercambio HTTP con el string proporcionado y lo escribe en el
     * response
     *
     * @param resp:  el actual puntero de intercambio http
     * @param error: exception para manejar
     */
    public void sendErrorJSON(HttpServletResponse resp, Exception error, HashMap<String, Object> adicionales) throws IOException {
        error.printStackTrace();

        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        resp.setContentType(MediaType.APPLICATION_JSON_VALUE);

        if (Env.PERSONA_ENVIRONMENT != null && Env.PERSONA_ENVIRONMENT.equals("DEBUG")) {
            HashMap<String, Object> hm = adicionales == null ? new HashMap<>() : adicionales;
            hm.put("success", 0);
            hm.put("error", error.getMessage());
            hm.put("trace", Arrays.toString(error.getStackTrace()));
            logger.error(hm.toString());

            try (ServletOutputStream out = resp.getOutputStream()) {
                serializadorService.serialize(hm, out);
            }
            return;
        }

        try (ServletOutputStream out = resp.getOutputStream()) {
            out.write(RESPONSE_ERROR_500);
        }
    }

    /**
     * Mapea los valores del query contenidos en el respuesta a un HashMap
     *
     * @param req HttpServletRequest
     * @return mapeo HashMap<String,String>
     */
    public HashMap<String, ArrayList<String>> getQueries(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding(UTF8);
        HashMap<String, ArrayList<String>> mapeo = new HashMap<>();

        String cadena = req.getQueryString();

        if (cadena == null) return mapeo;

        cadena = java.net.URLDecoder.decode(cadena, UTF8);

        for (String par : cadena.split("&")) {
            String[] values = par.split("=");
            if (values.length != 2) continue;

            if (!mapeo.containsKey(values[0])) {
                mapeo.put(values[0], new ArrayList<>());
            }
            mapeo.get(values[0]).add(values[1]);
        }
        return mapeo;
    }

    /**
     * Valida que todos los parametros pasados por url en la peticion run existan
     *
     * @param queries HashMap<String, String>
     * @param data    String[]
     * @return boolean
     */
    public boolean isInvalidQuery(HashMap<String, ArrayList<String>> queries, String[] data) {
        for (String key : data) {
            if (!queries.containsKey(key)) {
                return true;
            }
        }
        return false;
    }
}
