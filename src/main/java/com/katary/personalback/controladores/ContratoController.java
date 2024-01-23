package com.katary.personalback.controladores;

import com.katary.personalback.esquema.io.ContratoIn;
import com.katary.personalback.esquema.secuencias.ContratoSecuencia;
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
public class ContratoController {
    private final FrameworkService fw;
    private final ContratoSecuencia contratoSecuencia;

    @Autowired
    public ContratoController(FrameworkService fw, ContratoSecuencia contratoSecuencia) {
        this.fw = fw;
        this.contratoSecuencia = contratoSecuencia;
    }

    @CrossOrigin
    @RequestMapping(
            value = "/v1/contratos",
            method = RequestMethod.GET
    )
    public void obtenerContratos(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = contratoSecuencia.obtenerContratos();
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
            value = "/v1/contrato/{id_contrato}",
            method = RequestMethod.GET
    )
    public void obtenerContrato(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id_contrato

    ) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            HashMap<String, Object> success = contratoSecuencia.obtenerContrato(id_contrato);
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
            value = "/v1/contrato",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    public void crearContrato(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        ContratoIn.ContratoPOST body = fw.getBody(req, ContratoIn.ContratoPOST.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            int id = contratoSecuencia.crearContrato(
                    body.getId_contrato(),
                    body.getId_empleado(),
                    body.getId_cargo(),
                    body.getFecha_ingreso(),
                    body.getFecha_retiro(),
                    body.getEmpresa_ingreso(),
                    body.getId_tipo_contrato(),
                    body.getSalario_convenido(),
                    body.getBonificacion(),
                    body.getEstado());
            response.put("id_contrato", id);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());

        }
        fw.sendJSON(resp, response);
    }

    @CrossOrigin
    @RequestMapping(
            value = "/v1/contrato/{id_contrato}",
            method = RequestMethod.PUT,
            consumes = "application/json"
    )
    public void actualizarContrato(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id_contrato) throws IOException {

        ContratoIn.ContratoPUT body = fw.getBody(req, ContratoIn.ContratoPUT.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            int codigo = contratoSecuencia.actualizarContrato(
                    id_contrato,
                    body.getId_empleado(),
                    body.getId_cargo(),
                    body.getFecha_ingreso(),
                    body.getFecha_retiro(),
                    body.getEmpresa_ingreso(),
                    body.getId_tipo_contrato(),
                    body.getSalario_convenido(),
                    body.getBonificacion(),
                    body.getEstado()
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
            value = "/v1/contrato/{id_contrato}",
            method = RequestMethod.DELETE
    )
    public void eliminarContrato(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id_contrato) throws IOException {

        HashMap<String, Object> response = new HashMap<>(4);
        try {
            response = contratoSecuencia.eliminarContrato(id_contrato);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());
        }
        fw.sendJSON(resp, response);

    }

}	  