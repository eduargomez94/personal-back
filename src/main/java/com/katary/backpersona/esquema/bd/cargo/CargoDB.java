package com.katary.backpersona.esquema.bd.cargo;
import com.katary.backpersona.utiles.DBCoreService;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.katary.backpersona.esquema.bd.cargo.Consultas.*;
@Service
public class CargoDB {
    private final DBCoreService dbCoreService;
    public CargoDB(DBCoreService dbCoreService) {
        this.dbCoreService = dbCoreService;
    }

    public ArrayList<HashMap<String, Object>> obtenerCargos() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_CARGO_SELECT, parametros);
    }
    public HashMap<String, Object> obtenerCargo(int id_cargo) throws SQLException {
        Object[] parametros = new Object[]{id_cargo};
        return dbCoreService.obtenerElemento(SP_CARGO_SELECT_X_ID_CARGO, parametros);
    }
    public int crearCargo(
            int id_cargo,
            String descripcion_cargo,
            int id_categoria
            ) throws SQLException {
        Object[] parametros = new Object[]{descripcion_cargo,id_categoria};
        return dbCoreService.ejecutarQuery(SP_CARGO_INSERT, parametros);
    }
    public int actualizarCargo(
            int id_cargo,
            String descripcion_cargo,
            int id_categoria
            ) throws SQLException {
        Object[] parametros = new Object[]{id_cargo,descripcion_cargo,id_categoria};
        return dbCoreService.ejecutarQuery(SP_CARGO_UPDATE_X_ID_CARGO, parametros);
    }
    public HashMap<String, Object> eliminarCargo(int id_cargo) throws SQLException {
        Object[] parametros = new Object[]{id_cargo};
        return dbCoreService.obtenerElemento(SP_CARGO_DELETE_X_ID_CARGO, parametros);
    }


}