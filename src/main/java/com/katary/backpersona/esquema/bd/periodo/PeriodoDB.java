package com.katary.backpersona.esquema.bd.periodo;
import com.katary.backpersona.utiles.DBCoreService;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.katary.backpersona.esquema.bd.periodo.Consultas.*;
@Service
public class PeriodoDB {
    private final DBCoreService dbCoreService;
    public PeriodoDB(DBCoreService dbCoreService) {
        this.dbCoreService = dbCoreService;
    }

    public ArrayList<HashMap<String, Object>> obtenerPeriodosNominas() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_PERIODOS_NOMINA_SELECT, parametros);
    }
    public HashMap<String, Object> obtenerPeriodosNomina(int id_periodo) throws SQLException {
        Object[] parametros = new Object[]{id_periodo};
        return dbCoreService.obtenerElemento(SP_PERIODOS_NOMINA_SELECT_X_ID_PERIODO, parametros);
    }
    public int crearPeriodosNomina(
            int id_periodo,
            int anio,
            int mes,
            String fecha_inicial,
            String fecha_final
    ) throws SQLException {
        Object[] parametros = new Object[]{anio,mes,fecha_inicial,fecha_final};
        return dbCoreService.ejecutarQuery(SP_PERIODOS_NOMINA_INSERT, parametros);
    }
    public int actualizarPeriodosNomina(
            int id_periodo,
            int anio,
            int mes,
            String fecha_inicial,
            String fecha_final

            ) throws SQLException {
        Object[] parametros = new Object[]{id_periodo,anio,mes,fecha_inicial,fecha_final};
        return dbCoreService.ejecutarQuery(SP_PERIODOS_NOMINA_UPDATE_X_ID_PERIODO, parametros);
    }
    public HashMap<String, Object> eliminarPeriodosNomina(int id_periodo) throws SQLException {
        Object[] parametros = new Object[]{id_periodo};
        return dbCoreService.obtenerElemento(SP_PERIODOS_NOMINA_DELETE_X_ID_PERIODO, parametros);
    }


}	  