package com.katary.backpersona.controladores;
import com.katary.backpersona.esquema.io.EntidadIn;
import com.katary.backpersona.esquema.secuencias.EntidadSecuencia;
import com.katary.backpersona.esquema.secuencias.seguridad.SeguridadService;
import com.katary.backpersona.utiles.Env;
import com.katary.backpersona.utiles.FrameworkService;
import io.undertow.util.StatusCodes;
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
    public void obtenerEntidadesXTipo(HttpServletRequest req, HttpServletResponse resp,@PathVariable String tipo) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = entidadSecuencia.obtenerEntidadesXTipo(tipo);
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
            value = "/v1/entidades",
            method = RequestMethod.GET
    )
    public void obtenerEntidades(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = entidadSecuencia.obtenerEntidades();
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
            value = "/v1/entidad/{id_entidad}",
            method = RequestMethod.GET
    )
    public void obtenerEntidad(HttpServletRequest req, HttpServletResponse resp,@PathVariable int id_entidad

    ) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            HashMap<String, Object> success = entidadSecuencia.obtenerEntidad(id_entidad);
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
            value = "/v1/entidad",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    public void crearEntidad(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        EntidadIn.EntidadPOST body = fw.getBody(req, EntidadIn.EntidadPOST.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            int id = entidadSecuencia.crearEntidad(
                    body.getId_entidad(),
                    body.getNombre(),
                    body.getTipo()

            );
            response.put("id_entidad", id);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());

        }
        fw.sendJSON(resp, response);
    }
    @CrossOrigin
    @RequestMapping(
            value = "/v1/entidad/{id_entidad}",
            method = RequestMethod.PUT,
            consumes = "application/json"
    )
    public void actualizarEntidad(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id_entidad) throws IOException {

        EntidadIn.EntidadPUT body = fw.getBody(req, EntidadIn.EntidadPUT.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            int codigo = entidadSecuencia.actualizarEntidad(
                    id_entidad,
                    body.getNombre(),
                    body.getTipo()
            );
            response.put("exito", codigo);

        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());
        }
        fw.sendJSON(resp, response);
    }
    @CrossOrigin
    @RequestMapping(
            value = "/v1/entidad/{id_entidad}",
            method = RequestMethod.DELETE
    )
    public void eliminarEntidad(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id_entidad) throws IOException {

        HashMap<String, Object> response = new HashMap<>(4);
        try {
            response = entidadSecuencia.eliminarEntidad(id_entidad);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());
        }
        fw.sendJSON(resp, response);

    }
}
