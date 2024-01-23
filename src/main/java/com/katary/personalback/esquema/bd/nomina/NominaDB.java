package com.katary.personalback.esquema.bd.nomina;
import com.katary.personalback.utiles.DBCoreService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.katary.personalback.esquema.bd.nomina.Consultas.*;
@Service
public class NominaDB {
    private final DBCoreService dbCoreService;
    public NominaDB(DBCoreService dbCoreService) {
        this.dbCoreService = dbCoreService;
    }

    public ArrayList<HashMap<String, Object>> obtenerNominas() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_NOMINA_SELECT, parametros);
    }
    public HashMap<String, Object> obtenerNomina(int id_nomina) throws SQLException {
        Object[] parametros = new Object[]{id_nomina};
        return dbCoreService.obtenerElemento(SP_NOMINA_SELECT_X_ID_NOMINA, parametros);
    }
    public int crearNomina(
            int id_nomina,
            int id_contrato,
            BigDecimal dev_basico,
            BigDecimal dev_transporte,
            BigDecimal ded_salud,
            BigDecimal ded_pension,
            BigDecimal ded_celular,
            BigDecimal ded_retencion,
            BigDecimal ded_otros,
            BigDecimal neto,
            BigDecimal cesantias,
            BigDecimal intereses,
            BigDecimal prima,
            BigDecimal vacaciones,
            BigDecimal pension,
            BigDecimal comfamiliar,
            BigDecimal riesgos,
            BigDecimal total_mes,
            BigDecimal costo_hora,
            int dias_trabajados,
            int id_periodo

    ) throws SQLException {
        Object[] parametros = new Object[]{id_contrato,dev_basico,dev_transporte,ded_salud,ded_pension,ded_celular,ded_retencion,ded_otros,neto,cesantias,intereses,prima,vacaciones,pension,comfamiliar,riesgos,total_mes,costo_hora,dias_trabajados,id_periodo};
        return dbCoreService.ejecutarQuery(SP_NOMINA_INSERT, parametros);
    }
    public int actualizarNomina(
            int id_nomina,
            int id_contrato,
            BigDecimal dev_basico,
            BigDecimal dev_transporte,
            BigDecimal ded_salud,
            BigDecimal ded_pension,
            BigDecimal ded_celular,
            BigDecimal ded_retencion,
            BigDecimal ded_otros,
            BigDecimal neto,
            BigDecimal cesantias,
            BigDecimal intereses,
            BigDecimal prima,
            BigDecimal vacaciones,
            BigDecimal pension,
            BigDecimal comfamiliar,
            BigDecimal riesgos,
            BigDecimal total_mes,
            BigDecimal costo_hora,
            int dias_trabajados,
            int id_periodo

    ) throws SQLException {
        Object[] parametros = new Object[]{id_nomina,id_contrato,dev_basico,dev_transporte,ded_salud,ded_pension,ded_celular,ded_retencion,ded_otros,neto,cesantias,intereses,prima,vacaciones,pension,comfamiliar,riesgos,total_mes,costo_hora,dias_trabajados,id_periodo};
        return dbCoreService.ejecutarQuery(SP_NOMINA_UPDATE_X_ID_NOMINA, parametros);
    }
    public HashMap<String, Object> eliminarNomina(int id_nomina) throws SQLException {
        Object[] parametros = new Object[]{id_nomina};
        return dbCoreService.obtenerElemento(SP_NOMINA_DELETE_X_ID_NOMINA, parametros);
    }


}	  