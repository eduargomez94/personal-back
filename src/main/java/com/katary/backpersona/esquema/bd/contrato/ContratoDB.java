package com.katary.backpersona.esquema.bd.contrato;
import com.katary.backpersona.utiles.DBCoreService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.katary.backpersona.esquema.bd.contrato.Consultas.*;
@Service
public class ContratoDB {
    private final DBCoreService dbCoreService;
    public ContratoDB(DBCoreService dbCoreService) {
        this.dbCoreService = dbCoreService;
    }

    public ArrayList<HashMap<String, Object>> obtenerContratos() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_CONTRATO_SELECT, parametros);
    }
    public HashMap<String, Object> obtenerContrato(int id_contrato) throws SQLException {
        Object[] parametros = new Object[]{id_contrato};
        return dbCoreService.obtenerElemento(SP_CONTRATO_SELECT_X_ID_CONTRATO, parametros);
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
        Object[] parametros = new Object[]{id_empleado,id_cargo,fecha_ingreso,fecha_retiro,empresa_ingreso,id_tipo_contrato,salario_convenido,bonificacion,estado,};
        return dbCoreService.ejecutarQuery(SP_CONTRATO_INSERT, parametros);
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
        Object[] parametros = new Object[]{id_contrato,id_empleado,id_cargo,fecha_ingreso,fecha_retiro,empresa_ingreso,id_tipo_contrato,salario_convenido,bonificacion,estado};
        return dbCoreService.ejecutarQuery(SP_CONTRATO_UPDATE_X_ID_CONTRATO, parametros);
    }
    public HashMap<String, Object> eliminarContrato(int id_contrato) throws SQLException {
        Object[] parametros = new Object[]{id_contrato};
        return dbCoreService.obtenerElemento(SP_CONTRATO_DELETE_X_ID_CONTRATO, parametros);
    }


}	  