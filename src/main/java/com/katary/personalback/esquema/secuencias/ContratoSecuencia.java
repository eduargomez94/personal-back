package com.katary.personalback.esquema.secuencias;

import com.katary.personalback.esquema.bd.contrato.ContratoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class ContratoSecuencia {
    private final ContratoDB contratoDB;
    @Autowired
    public ContratoSecuencia(ContratoDB contratoDB) {
        this.contratoDB = contratoDB;
    }

    public ArrayList<HashMap<String, Object>> obtenerContratos() throws SQLException {
        return contratoDB.obtenerContratos();
    }
    public HashMap<String, Object> obtenerContrato(int id_contrato) throws SQLException {
        return contratoDB.obtenerContrato(id_contrato);
    }
    public int crearContrato(
            int id_contrato,
            int id_empleado,
            int id_cargo,
            String fecha_ingreso,
            String fecha_retiro,
            int empresa_ingreso,
            int id_tipo_contrato,
            BigDecimal salario_convenido,
            BigDecimal bonificacion,
            String estado

            ) throws SQLException {
        return contratoDB.crearContrato(id_contrato,id_empleado,id_cargo,fecha_ingreso,fecha_retiro,empresa_ingreso,id_tipo_contrato,salario_convenido,bonificacion,estado);
    }
    public int actualizarContrato(
            int id_contrato,
            int id_empleado,
            int id_cargo,
            String fecha_ingreso,
            String fecha_retiro,
            int empresa_ingreso,
            int id_tipo_contrato,
            BigDecimal salario_convenido,
            BigDecimal bonificacion,
            String estado
            ) throws SQLException {
        return contratoDB.actualizarContrato(id_contrato,id_empleado,id_cargo,fecha_ingreso,fecha_retiro,empresa_ingreso,id_tipo_contrato,salario_convenido,bonificacion,estado);
    }
    public HashMap<String, Object> eliminarContrato(int id_contrato) throws SQLException {
        return contratoDB.eliminarContrato(id_contrato);
    }

}	  