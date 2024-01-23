package com.katary.personalback.controladores;

import com.katary.personalback.esquema.io.AsignacionIn;
import com.katary.personalback.esquema.secuencias.AsignacionSecuencia;
import com.katary.personalback.utiles.Env;
import com.katary.personalback.utiles.FrameworkService;
import io.undertow.util.StatusCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@RestController
public class AsignacionController {
    private final FrameworkService fw;
    private final AsignacionSecuencia asignacionSecuencia;

    @Autowired
    public AsignacionController(FrameworkService fw, AsignacionSecuencia asignacionSecuencia) {
        this.fw = fw;
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
            response = asignacionSecuencia.obtenerAsignaciones();
            fw.sendJSON(resp, response);
        } catch (Exception throwables) {
            fw.sendErrorJSON(resp, throwables, null);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());
        }
    }

    @CrossOrigin
    @RequestMapping(
            value = "/v1/asignacion/{id}",
            method = RequestMethod.GET
    )
    public void obtenerCliente(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            HashMap<String, Object> success = asignacionSecuencia.obtenerAsignacion(id);
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

    @CrossOrigin
    @RequestMapping(
            value = "/v1/asignaciones/tabla",
            method = RequestMethod.GET
    )
    public void obtenerAsignacionesTabla(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            response = asignacionSecuencia.obtenerAsignacionesTabla();
            fw.sendJSON(resp, response);
        } catch (Exception throwables) {
            fw.sendErrorJSON(resp, throwables, null);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());
        }
    }

    @CrossOrigin
    @RequestMapping(
            value = "/v1/asignacion",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    public void crear(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        AsignacionIn.AsignacionPOST body = fw.getBody(req, AsignacionIn.AsignacionPOST.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            int id = asignacionSecuencia.crear(body);
            response.put("id_asignacion", id);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());

        }
        fw.sendJSON(resp, response);
    }

    @CrossOrigin
    @RequestMapping(
            value = "/v1/asignacion/{id}",
            method = RequestMethod.PUT,
            consumes = "application/json"
    )
    public void actualizar(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id) throws IOException {

        AsignacionIn.AsignacionPUT body = fw.getBody(req, AsignacionIn.AsignacionPUT.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            int codigo = asignacionSecuencia.actualizar(id, body);
            response.put("exito", codigo);

        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());
        }
        fw.sendJSON(resp, response);
    }

}	  