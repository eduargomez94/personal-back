package com.katary.backpersona.esquema.bd.cliente;
import com.katary.backpersona.utiles.DBCoreService;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.katary.backpersona.esquema.bd.cliente.Consultas.*;
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
    public HashMap<String, Object> obtenerCliente(int id_cliente) throws SQLException {
        Object[] parametros = new Object[]{id_cliente};
        return dbCoreService.obtenerElemento(SP_CLIENTE_SELECT_X_ID_CLIENTE, parametros);
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
        Object[] parametros = new Object[]{tipo_documento,no_documento,nombre_razonsocial,id_ciudad,direccion,telefono_ppal,contacto,email,pagina_web,logo,estado};
        return dbCoreService.ejecutarQuery(SP_CLIENTE_INSERT, parametros);
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
        Object[] parametros = new Object[]{id_cliente,tipo_documento,no_documento,nombre_razonsocial,id_ciudad,direccion,telefono_ppal,contacto,email,pagina_web,logo,estado};
        return dbCoreService.ejecutarQuery(SP_CLIENTE_UPDATE_X_ID_CLIENTE, parametros);
    }
    public HashMap<String, Object> eliminarCliente(int id_cliente) throws SQLException {
        Object[] parametros = new Object[]{id_cliente};
        return dbCoreService.obtenerElemento(SP_CLIENTE_DELETE_X_ID_CLIENTE, parametros);
    }


}	  