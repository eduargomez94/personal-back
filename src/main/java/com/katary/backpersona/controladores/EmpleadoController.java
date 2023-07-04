package com.katary.backpersona.controladores;
import com.katary.backpersona.esquema.io.EmpleadoIn;
import com.katary.backpersona.esquema.secuencias.EmpleadoSecuencia;
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
public class EmpleadoController {
    private final FrameworkService fw;
    private final SeguridadService seguridadService;
    private final EmpleadoSecuencia empleadoSecuencia;
    @Autowired
    public EmpleadoController(FrameworkService fw, SeguridadService seguridadService, EmpleadoSecuencia empleadoSecuencia) {
        this.fw = fw;
        this.seguridadService = seguridadService;
        this.empleadoSecuencia = empleadoSecuencia;
    }
    @CrossOrigin
    @RequestMapping(
            value = "/v1/empleado",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    public void crearEmpleado(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        EmpleadoIn.EmpleadoPOST body = fw.getBody(req, EmpleadoIn.EmpleadoPOST.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            int id = empleadoSecuencia.crearEmpleado(
                    body.getId_empleado(),
                    body.getId_tipo_doc(),
                    body.getNo_documento(),
                    body.getApellidos(),
                    body.getNombres(),
                    body.getEmail_personal(),
                    body.getEmail_corporativo(),
                    body.getCelular(),
                    body.getDireccion(),
                    body.getId_ciudad(),
                    body.getHoja_vida(),
                    body.getFecha_cumpleanos(),
                    body.getEntidad_salud(),
                    body.getEntidad_pension(),
                    body.getEntidad_ARL(),
                    body.getEstado(),
                    body.getFotografia(),
                    body.getFecha_aniversario(),
                    body.getPerfil_tecnico()
                    );
            response.put("id_empleado", id);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());

        }
        fw.sendJSON(resp, response);
    }
    @CrossOrigin
    @RequestMapping(
            value = "/v1/empleado/{id_empleado}",
            method = RequestMethod.PUT,
            consumes = "application/json"
    )
    public void actualizarEmpleado(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id_empleado) throws IOException {
        EmpleadoIn.EmpleadoPUT body = fw.getBody(req, EmpleadoIn.EmpleadoPUT.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            int codigo = empleadoSecuencia.actualizarEmpleado(
                    id_empleado,
                    body.getId_tipo_doc(),
                    body.getNo_documento(),
                    body.getApellidos(),
                    body.getNombres(),
                    body.getEmail_personal(),
                    body.getEmail_corporativo(),
                    body.getCelular(),
                    body.getDireccion(),
                    body.getId_ciudad(),
                    body.getHoja_vida(),
                    body.getFecha_cumpleanos(),
                    body.getEntidad_salud(),
                    body.getEntidad_pension(),
                    body.getEntidad_ARL(),
                    body.getEstado(),
                    body.getFotografia(),
                    body.getFecha_aniversario(),
                    body.getPerfil_tecnico()
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
            value = "/v1/empleados",
            method = RequestMethod.GET
    )
    public void obtenerEmpleados(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = empleadoSecuencia.obtenerEmpleados();
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
            value = "/v1/empleado/{id_empleado}",
            method = RequestMethod.GET
    )
    public void obtenerEmpleado(HttpServletRequest req, HttpServletResponse resp,@PathVariable int id_empleado

    ) throws IOException {
        HashMap<String, Object> response = new HashMap<>();
        try {
            HashMap<String, Object> success = empleadoSecuencia.obtenerEmpleado(id_empleado);
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
            value = "/v1/empleado/{id_empleado}",
            method = RequestMethod.DELETE
    )
    public void eliminarEmpleado(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id_empleado) throws IOException {
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            response = empleadoSecuencia.eliminarEmpleado(id_empleado);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());
        }
        fw.sendJSON(resp, response);
    }
    @CrossOrigin
    @RequestMapping(
            value = "/v1/tipos-documentos",
            method = RequestMethod.GET
    )
    public void obtenerTiposDocumentos(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = empleadoSecuencia.obtenerTiposDocumentos();
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
            value = "/v1/ciudades/{id_depto}",
            method = RequestMethod.GET
    )
    public void obtenerCiudades(HttpServletRequest req, HttpServletResponse resp,@PathVariable int id_depto) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = empleadoSecuencia.obtenerCiudades(id_depto);
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
            value = "/v1/departamentos/{id_pais}",
            method = RequestMethod.GET
    )
    public void obtenerDepartamentos(HttpServletRequest req, HttpServletResponse resp,@PathVariable int id_pais) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = empleadoSecuencia.obtenerDepartamentos(id_pais);
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
            value = "/v1/pais",
            method = RequestMethod.GET
    )
    public void obtenerPais(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = empleadoSecuencia.obtenerPais();
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
            value = "/v1/tipo-contratos",
            method = RequestMethod.GET
    )
    public void obtenerTipoContratos(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = empleadoSecuencia.obtenerTipoContratos();
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