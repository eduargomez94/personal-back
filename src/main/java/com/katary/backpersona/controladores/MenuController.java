package com.katary.backpersona.controladores;

import com.katary.backpersona.esquema.io.MenuIn;
import com.katary.backpersona.esquema.secuencias.MenuSecuencia;
import com.katary.backpersona.esquema.secuencias.seguridad.SeguridadService;
import com.katary.backpersona.utiles.Env;
import com.katary.backpersona.utiles.FrameworkService;
import io.undertow.util.StatusCodes;
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
public class MenuController {
    private final FrameworkService fw;
    private final SeguridadService seguridadService;
    private final MenuSecuencia menuSecuencia;

    @Autowired
    public MenuController(FrameworkService fw, SeguridadService seguridadService, MenuSecuencia menuSecuencia) {
        this.fw = fw;
        this.seguridadService = seguridadService;
        this.menuSecuencia = menuSecuencia;
    }

    @CrossOrigin
    @RequestMapping(
            value = "/v1/menus",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    public void obtenerMenus(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        MenuIn.MenuPOST body = fw.getBody(req, MenuIn.MenuPOST.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            ArrayList<HashMap<String, Object>> success = menuSecuencia.obtenerMenus(
                    body.getEmail(),
                    body.getId_rol());
            if (success.isEmpty()) {
                fw.sendNotFound(resp);
                return;
            }
            response.put("data", success);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());

        }
        fw.sendJSON(resp, response);
    }
}

