package com.katary.personalback.controladores;

import com.katary.personalback.esquema.io.MenuIn;
import com.katary.personalback.esquema.secuencias.MenuSecuencia;
import com.katary.personalback.utiles.Env;
import com.katary.personalback.utiles.FrameworkService;
import com.katary.personalback.utiles.JwtUtil;
import io.undertow.util.StatusCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class MenuController {
    private final FrameworkService fw;
    private final MenuSecuencia menuSecuencia;

    @Autowired
    public MenuController(FrameworkService fw, MenuSecuencia menuSecuencia) {
        this.fw = fw;
        this.menuSecuencia = menuSecuencia;
    }

    @CrossOrigin
    @RequestMapping(
            value = "/v1/menus",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    public void obtenerMenus(HttpServletRequest req, HttpServletResponse resp, @RequestHeader("Authorization") String token) throws IOException {
        if (!JwtUtil.verifyToken(token)) {
            fw.sendUnauthorized(resp, "Token inválido o expirado");
            return;
        }

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

