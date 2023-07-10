package com.katary.backpersona.esquema.secuencias;

import com.katary.backpersona.esquema.bd.cliente.ClienteDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class ClienteSecuencia {
    private final ClienteDB clienteDB;
    @Autowired
    public ClienteSecuencia(ClienteDB clienteDB) {
        this.clienteDB = clienteDB;
    }

    public ArrayList<HashMap<String, Object>> obtenerClientes() throws SQLException {
        return clienteDB.obtenerClientes();
    }
    public HashMap<String, Object> obtenerCliente(int id_cliente) throws SQLException {
        return clienteDB.obtenerCliente(id_cliente);
    }
    public int crearCliente(
            int id_cliente,
            int tipo_documento,
            String no_documento,
            String nombre_razonsocial,
            int id_ciudad,
            String direccion,
            String telefono_ppal,
            String contacto,
            String email,
            String pagina_web,
            String logo,
            String estado
            ) throws SQLException {
        return clienteDB.crearCliente(id_cliente,tipo_documento,no_documento,nombre_razonsocial,id_ciudad,direccion,telefono_ppal,contacto,email,pagina_web,logo,estado);
    }
    public int actualizarCliente(
            int id_cliente,
            int tipo_documento,
            String no_documento,
            String nombre_razonsocial,
            int id_ciudad,
            String direccion,
            String telefono_ppal,
            String contacto,
            String email,
            String pagina_web,
            String logo,
            String estado

            ) throws SQLException {
        return clienteDB.actualizarCliente(id_cliente,tipo_documento,no_documento,nombre_razonsocial,id_ciudad,direccion,telefono_ppal,contacto,email,pagina_web,logo,estado);
    }
    public HashMap<String, Object> eliminarCliente(int id_cliente) throws SQLException {
        return clienteDB.eliminarCliente(id_cliente);
    }

}	  