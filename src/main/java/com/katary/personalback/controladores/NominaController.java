package com.katary.personalback.controladores;
import com.katary.personalback.esquema.io.NominaIn;
import com.katary.personalback.esquema.secuencias.NominaSecuencia;
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
public class NominaController {
    private final FrameworkService fw;
    private final NominaSecuencia nominaSecuencia;
    @Autowired
    public NominaController(FrameworkService fw, NominaSecuencia nominaSecuencia) {
        this.fw = fw;
        this.nominaSecuencia = nominaSecuencia;
    }

    @CrossOrigin
    @RequestMapping(
            value = "/v1/nominas",
            method = RequestMethod.GET
    )
    public void obtenerNominas(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = nominaSecuencia.obtenerNominas();
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
            value = "/v1/nomina/{id_nomina}",
            method = RequestMethod.GET
    )
    public void obtenerNomina(HttpServletRequest req, HttpServletResponse resp,@PathVariable int id_nomina

    ) throws IOException {

        HashMap<String, Object> response = new HashMap<>();
        try {
            HashMap<String, Object> success = nominaSecuencia.obtenerNomina(id_nomina);
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
            value = "/v1/nomina",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    public void crearNomina(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        NominaIn.NominaPOST body = fw.getBody(req, NominaIn.NominaPOST.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            int id = nominaSecuencia.crearNomina(
                    body.getId_nomina(),
                    body.getId_contrato(),
                    body.getDev_basico(),
                    body.getDev_transporte(),
                    body.getDed_salud(),
                    body.getDed_pension(),
                    body.getDed_celular(),
                    body.getDed_retencion(),
                    body.getDed_otros(),
                    body.getNeto(),
                    body.getCesantias(),
                    body.getIntereses(),
                    body.getPrima(),
                    body.getVacaciones(),
                    body.getPension(),
                    body.getComfamiliar(),
                    body.getRiesgos(),
                    body.getTotal_mes(),
                    body.getCosto_hora(),
                    body.getDias_trabajados(),
                    body.getId_periodo()

            );
            response.put("id_nomina", id);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());

        }
        fw.sendJSON(resp, response);
    }
    @CrossOrigin
    @RequestMapping(
            value = "/v1/nomina/{id_nomina}",
            method = RequestMethod.PUT,
            consumes = "application/json"
    )
    public void actualizarNomina(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id_nomina) throws IOException {

        NominaIn.NominaPUT body = fw.getBody(req, NominaIn.NominaPUT.class);
        if (body == null || body.esInValido()) {
            fw.sendBadRequestJSON(resp, body);
            return;
        }
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            int codigo = nominaSecuencia.actualizarNomina(
                    id_nomina,
                    body.getId_contrato(),
                    body.getDev_basico(),
                    body.getDev_transporte(),
                    body.getDed_salud(),
                    body.getDed_pension(),
                    body.getDed_celular(),
                    body.getDed_retencion(),
                    body.getDed_otros(),
                    body.getNeto(),
                    body.getCesantias(),
                    body.getIntereses(),
                    body.getPrima(),
                    body.getVacaciones(),
                    body.getPension(),
                    body.getComfamiliar(),
                    body.getRiesgos(),
                    body.getTotal_mes(),
                    body.getCosto_hora(),
                    body.getDias_trabajados(),
                    body.getId_periodo()

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
            value = "/v1/nomina/{id_nomina}",
            method = RequestMethod.DELETE
    )
    public void eliminarNomina(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id_nomina) throws IOException {

        HashMap<String, Object> response = new HashMap<>(4);
        try {
            response = nominaSecuencia.eliminarNomina(id_nomina);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());
        }
        fw.sendJSON(resp, response);

    }

}	  