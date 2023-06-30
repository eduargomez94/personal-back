package com.katary.backpersona.esquema.secuencias;

import com.katary.backpersona.utiles.SFTPService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;

@Service
public class ArchivoSecuencia {
    private final SFTPService sftpService;

    public ArchivoSecuencia(SFTPService sftpService) {
        this.sftpService = sftpService;
    }

    public String subirArchivo(MultipartFile file) throws SQLException {
        return sftpService.cargarArchivo(file);

    }
}
