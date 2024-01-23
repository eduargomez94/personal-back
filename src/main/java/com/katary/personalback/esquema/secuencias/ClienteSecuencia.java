package com.katary.personalback.esquema.secuencias;

import com.katary.personalback.esquema.bd.archivos.ArchivosBD;
import com.katary.personalback.esquema.bd.cliente.ClienteDB;
import com.katary.personalback.esquema.io.ClienteIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.HashMap;

@Service
public class ClienteSecuencia {
    private final ClienteDB clienteDB;
    private final ArchivosBD archivosBD;
    private final ArchivoSecuencia archivoSecuencia;

    @Autowired
    public ClienteSecuencia(ClienteDB clienteDB, ArchivosBD archivosBD, ArchivoSecuencia archivoSecuencia) {
        this.clienteDB = clienteDB;
        this.archivosBD = archivosBD;
        this.archivoSecuencia = archivoSecuencia;
    }

    public ArrayList<HashMap<String, Object>> obtenerClientes() throws SQLException {
        return clienteDB.obtenerClientes();
    }

    public ArrayList<HashMap<String, Object>> obtenerClientesActivos() throws SQLException {
        return clienteDB.obtenerClientesActivos();
    }

    public HashMap<String, Object> obtenerCliente(int id_cliente) throws SQLException {
        HashMap<String, Object> data = clienteDB.obtenerCliente(id_cliente);
        if (data.get("url_logo") != null && data.containsKey("url_logo")) {
            String base64 = this.archivoSecuencia.descargarArchivo(data.get("url_logo").toString());
            data.put("file_logo", base64);
            data.put("nombre_logo", data.get("nombre_logo").toString());
        }
        return data;
    }

    public int crearCliente(ClienteIn.ClientePOST body) throws SQLException {
        if (body.getFile_logo() != null && !body.getFile_logo().isEmpty()) {
            String[] parteA = body.getFile_logo().split(",");
            String base64String = parteA[1];
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);
            InputStream inputStream = new ByteArrayInputStream(decodedBytes);

            String ext = this.archivoSecuencia.getFileExtension(body.getNombre_logo());
            String path = this.archivoSecuencia.subirArchivo(inputStream, "logo_" + body.getNo_documento() + "_" + Calendar.getInstance().getTimeInMillis() + "." + ext);

            int idLogo = this.archivosBD.crear(body.getNombre_logo(), path);
            body.setLogo(idLogo);
        }

        return clienteDB.crearCliente(body);
    }

    public int actualizarCliente(int id_cliente, ClienteIn.ClientePUT body) throws SQLException {
        if (body.getFile_logo() != null && !body.getFile_logo().isEmpty()) {
            String[] parteA = body.getFile_logo().split(",");
            String base64String = parteA[1];
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);
            InputStream inputStream = new ByteArrayInputStream(decodedBytes);

            String ext = this.archivoSecuencia.getFileExtension(body.getNombre_logo());
            String path = this.archivoSecuencia.subirArchivo(inputStream, "foto_" + body.getNo_documento() + "_" + Calendar.getInstance().getTimeInMillis() + "." + ext);

            int idLogo = this.archivosBD.crear(body.getNombre(), path);
            body.setLogo(idLogo);
        }
        return clienteDB.actualizarCliente(id_cliente, body);
    }

    public HashMap<String, Object> eliminarCliente(int id_cliente) throws SQLException {
        return clienteDB.eliminarCliente(id_cliente);
    }

}	  