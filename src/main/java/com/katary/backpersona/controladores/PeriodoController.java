package com.katary.backpersona.controladores;
import com.katary.backpersona.esquema.io.PeriodoIn;
import com.katary.backpersona.esquema.secuencias.PeriodoSecuencia;
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
public class PeriodoController {
    private final FrameworkService fw;
    private final SeguridadService seguridadService;
    private final PeriodoSecuencia periodoSecuencia;
    @Autowired
    public PeriodoController(FrameworkService fw, SeguridadService seguridadService, PeriodoSecuencia periodoSecuencia) {
        this.fw = fw;
        this.seguridadService = seguridadService;
        this.periodoSecuencia = periodoSecuencia;
    }

    @CrossOrigin
    @RequestMapping(
            value = "/v1/periodos-nomina",
            method = RequestMethod.GET
    )
    public void obtenerPeriodos(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = periodoSecuencia.obtenerPeriodosNominas();
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
            value = "/v1/periodo-nomina/{id_periodo}",
            method = RequestMethod.GET
    )
    public void obtenerPeriodo(HttpServletRequest req, HttpServletResponse resp,@PathVariable int id_periodo

    ) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            HashMap<String, Object> success = periodoSecuencia.obtenerPeriodosNomina(id_periodo);
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
            value = "/v1/periodo-nomina",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    public void crearPeriodo(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PeriodoIn.PeriodoPOST body = fw.getBody(req, PeriodoIn.PeriodoPOST.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            int id = periodoSecuencia.crearPeriodosNomina(
                    body.getId_periodo(),
                    body.getAnio(),
                    body.getMes(),
                    body.getFecha_inicial(),
                    body.getFecha_final()

            );
            response.put("id_periodo", id);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());

        }
        fw.sendJSON(resp, response);
    }
    @CrossOrigin
    @RequestMapping(
            value = "/v1/periodo-nomina/{id_periodo}",
            method = RequestMethod.PUT,
            consumes = "application/json"
    )
    public void actualizarPeriodo(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id_periodo) throws IOException {

        PeriodoIn.PeriodoPUT body = fw.getBody(req, PeriodoIn.PeriodoPUT.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            int codigo = periodoSecuencia.actualizarPeriodosNomina(
                    id_periodo,
                    body.getAnio(),
                    body.getMes(),
                    body.getFecha_inicial(),
                    body.getFecha_final()

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
            value = "/v1/periodo-nomina/{id_periodo}",
            method = RequestMethod.DELETE
    )
    public void eliminarPeriodo(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id_periodo) throws IOException {

        HashMap<String, Object> response = new HashMap<>(4);
        try {
            response = periodoSecuencia.eliminarPeriodosNomina(id_periodo);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());
        }
        fw.sendJSON(resp, response);

    }

}	  