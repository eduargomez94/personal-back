package com.katary.backpersona.esquema.secuencias;

import com.katary.backpersona.esquema.bd.periodo.PeriodoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class PeriodoSecuencia {
    private final PeriodoDB periodoDB;
    @Autowired
    public PeriodoSecuencia(PeriodoDB periodoDB) {
        this.periodoDB = periodoDB;
    }

    public ArrayList<HashMap<String, Object>> obtenerPeriodosNominas() throws SQLException {
        return periodoDB.obtenerPeriodosNominas();
    }
    public HashMap<String, Object> obtenerPeriodosNomina(int id_periodo) throws SQLException {
        return periodoDB.obtenerPeriodosNomina(id_periodo);
    }
    public int crearPeriodosNomina(
            int id_periodo,
            int anio,
            int mes,
            String fecha_inicial,
            String fecha_final

    ) throws SQLException {
        return periodoDB.crearPeriodosNomina(id_periodo,anio,mes,fecha_inicial,fecha_final);
    }
    public int actualizarPeriodosNomina(
            int id_periodo,
            int anio,
            int mes,
            String fecha_inicial,
            String fecha_final

    ) throws SQLException {
        return periodoDB.actualizarPeriodosNomina(id_periodo,anio,mes,fecha_inicial,fecha_final);
    }
    public HashMap<String, Object> eliminarPeriodosNomina(int id_periodo) throws SQLException {
        return periodoDB.eliminarPeriodosNomina(id_periodo);
    }

}	  