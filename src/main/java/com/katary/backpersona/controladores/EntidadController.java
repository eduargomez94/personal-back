package com.katary.backpersona.controladores;
import com.katary.backpersona.esquema.secuencias.EntidadSecuencia;
import com.katary.backpersona.esquema.secuencias.seguridad.SeguridadService;
import com.katary.backpersona.utiles.Env;
import com.katary.backpersona.utiles.FrameworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class EntidadController {
    private final FrameworkService fw;
    private final SeguridadService seguridadService;
    private final EntidadSecuencia entidadSecuencia;
    @Autowired
    public EntidadController(FrameworkService fw, SeguridadService seguridadService, EntidadSecuencia entidadSecuencia) {
        this.fw = fw;
        this.seguridadService = seguridadService;
        this.entidadSecuencia = entidadSecuencia;
    }

    @CrossOrigin
    @RequestMapping(
            value = "/v1/entidades/{tipo}",
            method = RequestMethod.GET
    )
    public void obtenerEntidades(HttpServletRequest req, HttpServletResponse resp,@PathVariable String tipo) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = entidadSecuencia.obtenerEntidades(tipo);
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