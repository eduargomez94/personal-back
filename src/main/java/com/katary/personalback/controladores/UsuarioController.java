package com.katary.personalback.controladores;

import com.katary.personalback.esquema.secuencias.UsuarioSecuencia;
import com.katary.personalback.utiles.FrameworkService;
import io.undertow.util.StatusCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class UsuarioController {
    private final FrameworkService fw;
    private final UsuarioSecuencia usuarioSecuencia;

    @Autowired
    public UsuarioController(FrameworkService fw, UsuarioSecuencia usuarioSecuencia) {
        this.fw = fw;
        this.usuarioSecuencia = usuarioSecuencia;
    }

    @CrossOrigin
    @RequestMapping(
            value = "/usuarios",
            method = RequestMethod.GET
    )
    public void obtenerUsuarios(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HashMap<String, Object> response = new HashMap<>();
        try {
            ArrayList<HashMap<String, Object>> success = usuarioSecuencia.obtenerUsuarios();
            response.put("data", success);

        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
        }
        fw.sendJSON(resp, response);
    }
}
