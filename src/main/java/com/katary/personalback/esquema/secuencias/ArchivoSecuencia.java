package com.katary.personalback.esquema.secuencias;

import com.katary.personalback.utiles.SFTPService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
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

    public String subirArchivo(InputStream file, String fileName) throws SQLException {
        return sftpService.cargarArchivo(file, fileName);
    }

    public String descargarArchivo(String remoteFilePath) throws SQLException {
        return sftpService.descargarArchivo(remoteFilePath);
    }

    public String getFileExtension(String fileName) {
        return sftpService.getFileExtension(fileName);
    }
}
