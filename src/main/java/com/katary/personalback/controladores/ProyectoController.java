package com.katary.personalback.controladores;

import com.katary.personalback.esquema.io.ProyectoIn;
import com.katary.personalback.esquema.secuencias.ProyectoSecuencia;
import com.katary.personalback.utiles.Env;
import com.katary.personalback.utiles.FrameworkService;
import io.undertow.util.StatusCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class ProyectoController {
    private final FrameworkService fw;
    private final ProyectoSecuencia proyectoSecuencia;

    @Autowired
    public ProyectoController(FrameworkService fw, ProyectoSecuencia proyectoSecuencia) {
        this.fw = fw;
        this.proyectoSecuencia = proyectoSecuencia;
    }

    @CrossOrigin
    @RequestMapping(
            value = "/v1/proyectos",
            method = RequestMethod.GET
    )
    public void obtenerProyectos(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = proyectoSecuencia.obtenerProyectos();
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
            value = "/v1/proyectos/activos",
            method = RequestMethod.GET
    )
    public void obtenerProyectosActivos(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = proyectoSecuencia.obtenerProyectosActivos();
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
            value = "/v1/proyecto/{id_proyecto}",
            method = RequestMethod.GET
    )
    public void obtenerProyecto(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id_proyecto

    ) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            HashMap<String, Object> success = proyectoSecuencia.obtenerProyecto(id_proyecto);
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
            value = "/v1/proyecto",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    public void crearProyecto(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        ProyectoIn.ProyectoPOST body = fw.getBody(req, ProyectoIn.ProyectoPOST.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            int id = proyectoSecuencia.crearProyecto(body);
            response.put("id_proyecto", id);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());

        }
        fw.sendJSON(resp, response);
    }

    @CrossOrigin
    @RequestMapping(
            value = "/v1/proyecto/{id_proyecto}",
            method = RequestMethod.PUT,
            consumes = "application/json"
    )
    public void actualizarProyecto(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id_proyecto) throws IOException {

        ProyectoIn.ProyectoPUT body = fw.getBody(req, ProyectoIn.ProyectoPUT.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            int codigo = proyectoSecuencia.actualizarProyecto(id_proyecto, body);
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
            value = "/v1/proyecto/{id_proyecto}",
            method = RequestMethod.DELETE
    )
    public void eliminarProyecto(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id_proyecto) throws IOException {

        HashMap<String, Object> response = new HashMap<>(4);
        try {
            response = proyectoSecuencia.eliminarProyecto(id_proyecto);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());
        }
        fw.sendJSON(resp, response);

    }

    @CrossOrigin
    @RequestMapping(
            value = "/v1/tipo-proyectos",
            method = RequestMethod.GET
    )
    public void obtenerTipoProyectos(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = proyectoSecuencia.obtenerTipoProyectos();
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