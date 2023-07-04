package com.katary.backpersona.controladores;

import com.katary.backpersona.esquema.secuencias.CargoSecuencia;
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
public class CargoController {
    private final FrameworkService fw;
    private final SeguridadService seguridadService;
    private final CargoSecuencia cargoSecuencia;

    @Autowired
    public CargoController(FrameworkService fw, SeguridadService seguridadService, CargoSecuencia cargoSecuencia) {
        this.fw = fw;
        this.seguridadService = seguridadService;
        this.cargoSecuencia = cargoSecuencia;
    }

    @CrossOrigin
    @RequestMapping(
            value = "/v1/cargos",
            method = RequestMethod.GET
    )
    public void obtenerCargos(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = cargoSecuencia.obtenerCargos();
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