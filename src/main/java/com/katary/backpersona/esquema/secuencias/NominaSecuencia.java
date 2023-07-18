package com.katary.backpersona.esquema.secuencias;

import com.katary.backpersona.esquema.bd.nomina.NominaDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class NominaSecuencia {
    private final NominaDB nominaDB;
    @Autowired
    public NominaSecuencia(NominaDB nominaDB) {
        this.nominaDB = nominaDB;
    }

    public ArrayList<HashMap<String, Object>> obtenerNominas() throws SQLException {
        return nominaDB.obtenerNominas();
    }
    public HashMap<String, Object> obtenerNomina(int id_nomina) throws SQLException {
        return nominaDB.obtenerNomina(id_nomina);
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
        return nominaDB.crearNomina(id_nomina,id_contrato,dev_basico,dev_transporte,ded_salud,ded_pension,ded_celular,ded_retencion,ded_otros,neto,cesantias,intereses,prima,vacaciones,pension,comfamiliar,riesgos,total_mes,costo_hora,dias_trabajados,id_periodo);
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
        return nominaDB.actualizarNomina(id_nomina,id_contrato,dev_basico,dev_transporte,ded_salud,ded_pension,ded_celular,ded_retencion,ded_otros,neto,cesantias,intereses,prima,vacaciones,pension,comfamiliar,riesgos,total_mes,costo_hora,dias_trabajados,id_periodo);
    }
    public HashMap<String, Object> eliminarNomina(int id_nomina) throws SQLException {
        return nominaDB.eliminarNomina(id_nomina);
    }

}	  