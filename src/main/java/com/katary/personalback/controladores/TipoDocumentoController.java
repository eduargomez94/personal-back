package com.katary.personalback.controladores;

import com.katary.personalback.esquema.secuencias.TipoDocumentoSecuencia;
import com.katary.personalback.utiles.Env;
import com.katary.personalback.utiles.FrameworkService;
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
public class TipoDocumentoController {
    private final FrameworkService fw;
    private final TipoDocumentoSecuencia tipoDocumentoSecuencia;

    @Autowired
    public TipoDocumentoController(FrameworkService fw, TipoDocumentoSecuencia tipoDocumentoSecuencia) {
        this.fw = fw;
        this.tipoDocumentoSecuencia = tipoDocumentoSecuencia;
    }

    @CrossOrigin
    @RequestMapping(
            value = "/v1/tiposdocumento",
            method = RequestMethod.GET
    )
    public void obtenerTiposDocumento(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = tipoDocumentoSecuencia.obtenerTiposDocumento();
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