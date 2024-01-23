package com.katary.personalback.controladores;

import com.katary.personalback.esquema.secuencias.ArchivoSecuencia;
import com.katary.personalback.utiles.Env;
import com.katary.personalback.utiles.FrameworkService;
import io.undertow.util.StatusCodes;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@RestController
public class ArchivoController {

    private final FrameworkService fw;
    private final ArchivoSecuencia archivoSecuencia;

    public ArchivoController(FrameworkService fw, ArchivoSecuencia archivoSecuencia) {
        this.fw = fw;
        this.archivoSecuencia = archivoSecuencia;
    }


    @CrossOrigin
    @RequestMapping(
            value = "/v1/upload",
            method = RequestMethod.POST,
            consumes = "multipart/form-data"
    )
    public void subirArchivo(HttpServletRequest req, HttpServletResponse resp
            , @RequestParam("file") MultipartFile file
    ) throws IOException {
        HashMap<String, Object> response = new HashMap<>(4);
        try {
            // Aquí puedes manejar el archivo y los parámetros recibidos
            if (!file.isEmpty()) {
                // Procesa el archivo adjunto
                String fileName = file.getOriginalFilename();
                String ruta = archivoSecuencia.subirArchivo(
                        file
                );
                response.put("ruta", ruta);
                // ...
            }

            // Procesa los parámetros de tipo String
            // ...

            //return ResponseEntity.ok("Archivo recibido correctamente");
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.setStatus(StatusCodes.INTERNAL_SERVER_ERROR);
            if (Env.PERSONA_ENVIRONMENT.equals("DEBUG")) response.put("error", throwables.getMessage());
        }
        fw.sendJSON(resp, response);
    }

}
