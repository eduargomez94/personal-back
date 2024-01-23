package com.katary.personalback.esquema.bd.cliente;

import com.katary.personalback.esquema.io.ClienteIn;
import com.katary.personalback.utiles.DBCoreService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.katary.personalback.esquema.bd.cliente.Consultas.*;

@Service
public class ClienteDB {
    private final DBCoreService dbCoreService;

    public ClienteDB(DBCoreService dbCoreService) {
        this.dbCoreService = dbCoreService;
    }

    public ArrayList<HashMap<String, Object>> obtenerClientes() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_CLIENTE_SELECT, parametros);
    }

    public ArrayList<HashMap<String, Object>> obtenerClientesActivos() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_CLIENTE_SELECT_ACTIVOS, parametros);
    }

    public HashMap<String, Object> obtenerCliente(int id_cliente) throws SQLException {
        Object[] parametros = new Object[]{id_cliente};
        return dbCoreService.obtenerElemento(SP_CLIENTE_SELECT_X_ID_CLIENTE, parametros);
    }

    public int crearCliente(ClienteIn.ClientePOST body) throws SQLException {
        Object[] parametros = new Object[]{
                body.getTipo_documento(),
                body.getNo_documento(),
                body.getNombre(),
                body.getId_ciudad(),
                body.getDireccion(),
                body.getTelefono(),
                body.getContacto(),
                body.getEmail(),
                body.getPagina_web(),
                body.getLogo(),
                body.getEstado()
        };
        return dbCoreService.ejecutarQuery(SP_CLIENTE_INSERT, parametros);
    }

    public int actualizarCliente(int id_cliente, ClienteIn.ClientePUT body) throws SQLException {
        Object[] parametros = new Object[]{
                id_cliente,
                body.getTipo_documento(),
                body.getNo_documento(),
                body.getNombre(),
                body.getId_ciudad(),
                body.getDireccion(),
                body.getTelefono(),
                body.getContacto(),
                body.getEmail(),
                body.getPagina_web(),
                body.getLogo(),
                body.getEstado()
        };
        return dbCoreService.ejecutarQuery(SP_CLIENTE_UPDATE_X_ID_CLIENTE, parametros);
    }

    public HashMap<String, Object> eliminarCliente(int id_cliente) throws SQLException {
        Object[] parametros = new Object[]{id_cliente};
        return dbCoreService.obtenerElemento(SP_CLIENTE_DELETE_X_ID_CLIENTE, parametros);
    }


}	  