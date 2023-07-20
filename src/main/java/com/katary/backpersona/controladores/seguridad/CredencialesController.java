package com.katary.backpersona.controladores.seguridad;

import com.katary.backpersona.esquema.io.seguridad.CredencialesIn;
import com.katary.backpersona.esquema.secuencias.CredencialesSecuencia;
import com.katary.backpersona.utiles.Env;
import com.katary.backpersona.utiles.FrameworkService;
import io.undertow.util.StatusCodes;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class CredencialesController {
    private final FrameworkService fw;
    private final CredencialesSecuencia credencialesSecuencia;

    public CredencialesController(FrameworkService fw, CredencialesSecuencia credencialesSecuencia) {
        this.fw = fw;
        this.credencialesSecuencia = credencialesSecuencia;
    }

    @CrossOrigin
    @RequestMapping(
            value = "/v1/ingresar",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        CredencialesIn.CredencialesPost body = fw.getBody(req, CredencialesIn.CredencialesPost.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(6);

        HashMap<String, Object> usuario = new HashMap<>(6);

        try {
            usuario = credencialesSecuencia.ingresar(body.getEmail(), body.getContrasena());
            if (usuario != null) {
                response.put("success", 1);
                response.put("token", usuario.get("token"));
                response.put("esAutenticado", true);
                ArrayList<HashMap<String, Object>> roles = credencialesSecuencia.obtenerRoles(body.getEmail());
                response.put("roles", roles);
            }else{
                response.put("success", 1);
                response.put("token", null);
                response.put("esAutenticado", false);
            }


        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());
        }

        fw.sendJSON(resp, response);
    }
}
