package com.katary.backpersona.controladores;

import com.katary.backpersona.esquema.secuencias.AsignacionSecuencia;
import com.katary.backpersona.esquema.secuencias.seguridad.SeguridadService;
import com.katary.backpersona.utiles.Env;
import com.katary.backpersona.utiles.FrameworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class AsignacionController {
    private final FrameworkService fw;
    private final SeguridadService seguridadService;
    private final AsignacionSecuencia asignacionSecuencia;

    @Autowired
    public AsignacionController(FrameworkService fw, SeguridadService seguridadService, AsignacionSecuencia asignacionSecuencia) {
        this.fw = fw;
        this.seguridadService = seguridadService;
        this.asignacionSecuencia = asignacionSecuencia;
    }

    @CrossOrigin
    @RequestMapping(
            value = "/v1/asignaciones",
            method = RequestMethod.GET
    )
    public void obtenerAsignaciones(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = asignacionSecuencia.obtenerAsignaciones();
            if (success.isEmpty()) {
                fw.sendNotFound(resp);
                return;
            }
            response.put("data", success);
            fw.sendJSON(resp, response);
        } catch (Exception throwables) {
            fw.sendErrorJSON(resp, throwables, null);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());
        }
    }


}	  