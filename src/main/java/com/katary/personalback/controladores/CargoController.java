package com.katary.personalback.controladores;
import com.katary.personalback.esquema.io.CargoIn;
import com.katary.personalback.esquema.secuencias.CargoSecuencia;
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
public class CargoController {
    private final FrameworkService fw;
    private final CargoSecuencia cargoSecuencia;
    @Autowired
    public CargoController(FrameworkService fw, CargoSecuencia cargoSecuencia) {
        this.fw = fw;
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
    @CrossOrigin
    @RequestMapping(
            value = "/v1/cargo/{id_cargo}",
            method = RequestMethod.GET
    )
    public void obtenerCargo(HttpServletRequest req, HttpServletResponse resp,@PathVariable int id_cargo

    ) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            HashMap<String, Object> success = cargoSecuencia.obtenerCargo(id_cargo);
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
            value = "/v1/cargo",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    public void crearCargo(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        CargoIn.CargoPOST body = fw.getBody(req, CargoIn.CargoPOST.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            int id = cargoSecuencia.crearCargo(
                    body.getId_cargo(),
                    body.getDescripcion_cargo(),
                    body.getId_categoria()
                    );
            response.put("id_cargo", id);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());

        }
        fw.sendJSON(resp, response);
    }
    @CrossOrigin
    @RequestMapping(
            value = "/v1/cargo/{id_cargo}",
            method = RequestMethod.PUT,
            consumes = "application/json"
    )
    public void actualizarCargo(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id_cargo) throws IOException {

        CargoIn.CargoPUT body = fw.getBody(req, CargoIn.CargoPUT.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            int codigo = cargoSecuencia.actualizarCargo(
                    id_cargo,
                    body.getDescripcion_cargo(),
                    body.getId_categoria()
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
            value = "/v1/cargo/{id_cargo}",
            method = RequestMethod.DELETE
    )
    public void eliminarCargo(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id_cargo) throws IOException {

        HashMap<String, Object> response = new HashMap<>(4);
        try {
            response = cargoSecuencia.eliminarCargo(id_cargo);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());
        }
        fw.sendJSON(resp, response);

    }

}	  