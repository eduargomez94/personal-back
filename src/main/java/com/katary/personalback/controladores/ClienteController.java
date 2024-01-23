package com.katary.personalback.controladores;

import com.katary.personalback.esquema.io.ClienteIn;
import com.katary.personalback.esquema.secuencias.ClienteSecuencia;
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
public class ClienteController {
    private final FrameworkService fw;
    private final ClienteSecuencia clienteSecuencia;

    @Autowired
    public ClienteController(FrameworkService fw, ClienteSecuencia clienteSecuencia) {
        this.fw = fw;
        this.clienteSecuencia = clienteSecuencia;
    }

    @CrossOrigin
    @RequestMapping(
            value = "/v1/clientes",
            method = RequestMethod.GET
    )
    public void obtenerClientes(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = clienteSecuencia.obtenerClientes();
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
            value = "/v1/clientes/activos",
            method = RequestMethod.GET
    )
    public void obtenerClientesActivos(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = clienteSecuencia.obtenerClientesActivos();
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
            value = "/v1/cliente/{id_cliente}",
            method = RequestMethod.GET
    )
    public void obtenerCliente(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id_cliente

    ) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            HashMap<String, Object> success = clienteSecuencia.obtenerCliente(id_cliente);
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
            value = "/v1/cliente",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    public void crearCliente(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        ClienteIn.ClientePOST body = fw.getBody(req, ClienteIn.ClientePOST.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            int id = clienteSecuencia.crearCliente(body);
            response.put("id_cliente", id);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());

        }
        fw.sendJSON(resp, response);
    }

    @CrossOrigin
    @RequestMapping(
            value = "/v1/cliente/{id_cliente}",
            method = RequestMethod.PUT,
            consumes = "application/json"
    )
    public void actualizarCliente(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id_cliente) throws IOException {

        ClienteIn.ClientePUT body = fw.getBody(req, ClienteIn.ClientePUT.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            int codigo = clienteSecuencia.actualizarCliente(id_cliente, body);
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
            value = "/v1/cliente/{id_cliente}",
            method = RequestMethod.DELETE
    )
    public void eliminarCliente(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id_cliente) throws IOException {

        HashMap<String, Object> response = new HashMap<>(4);
        try {
            response = clienteSecuencia.eliminarCliente(id_cliente);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());
        }
        fw.sendJSON(resp, response);

    }

}	  