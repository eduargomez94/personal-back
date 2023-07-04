package com.katary.backpersona.esquema.bd.empleado;
import com.katary.backpersona.utiles.DBCoreService;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.katary.backpersona.esquema.bd.empleado.Consultas.*;
@Service
public class EmpleadoDB {
    private final DBCoreService dbCoreService;
    public EmpleadoDB(DBCoreService dbCoreService) {
        this.dbCoreService = dbCoreService;
    }
    public int crearEmpleado(
            int id_empleado,
            int id_tipo_doc,
            String no_documento,
            String apellidos,
            String nombres,
            String email_personal,
            String email_corporativo,
            String celular,
            String direccion,
            int id_ciudad,
            String hoja_vida,
            String fecha_cumpleanos,
            int entidad_salud,
            int entidad_pension,
            int entidad_ARL,
            String estado,
            String fotografia,
            String fecha_aniversario,
            String perfil_tecnico
    ) throws SQLException {
        Object[] parametros = new Object[]{ id_tipo_doc, no_documento, apellidos, nombres, email_personal, email_corporativo, celular, direccion, id_ciudad, hoja_vida, fecha_cumpleanos, entidad_salud, entidad_pension, entidad_ARL, estado, fotografia, fecha_aniversario, perfil_tecnico};
        return dbCoreService.ejecutarQuery(SP_EMPLEADO_INSERT, parametros);
    }
    public int actualizarEmpleado(
            int id_empleado,
            int id_tipo_doc,
            String no_documento,
            String apellidos,
            String nombres,
            String email_personal,
            String email_corporativo,
            String celular,
            String direccion,
            int id_ciudad,
            String hoja_vida,
            String fecha_cumpleanos,
            int entidad_salud,
            int entidad_pension,
            int entidad_ARL,
            String estado,
            String fotografia,
            String fecha_aniversario,
            String perfil_tecnico
    ) throws SQLException {
        Object[] parametros = new Object[]{id_empleado,id_tipo_doc,no_documento,apellidos,nombres,email_personal,email_corporativo,celular,direccion,id_ciudad,hoja_vida,fecha_cumpleanos,entidad_salud,entidad_pension,entidad_ARL,estado,fotografia,fecha_aniversario,perfil_tecnico};
        return dbCoreService.ejecutarQuery(SP_EMPLEADO_UPDATE_X_ID_EMPLEADO, parametros);
    }
    public ArrayList<HashMap<String, Object>> obtenerEmpleados() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_EMPLEADO_SELECT, parametros);
    }
    public HashMap<String, Object> obtenerEmpleado(int id_empleado) throws SQLException {
        Object[] parametros = new Object[]{id_empleado};
        return dbCoreService.obtenerElemento(SP_EMPLEADO_SELECT_X_ID_EMPLEADO, parametros);
    }
    public HashMap<String, Object> eliminarEmpleado(int id_empleado) throws SQLException {
        Object[] parametros = new Object[]{id_empleado};
        return dbCoreService.obtenerElemento(SP_EMPLEADO_DELETE_X_ID_EMPLEADO, parametros);
    }
    public ArrayList<HashMap<String, Object>> obtenerTiposDocumentos() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_TIPOSDOCUMENTO_SELECT, parametros);
    }
    public ArrayList<HashMap<String, Object>> obtenerCiudades(int id_depto) throws SQLException {
        Object[] parametros = new Object[]{id_depto};
        return dbCoreService.obtenerElementos(SP_CIUDAD_SELECT, parametros);
    }
    public ArrayList<HashMap<String, Object>> obtenerDepartamentos(int id_pais) throws SQLException {
        Object[] parametros = new Object[]{id_pais};
        return dbCoreService.obtenerElementos(SP_DEPTO_PROVINCIA_SELECT, parametros);
    }
    public ArrayList<HashMap<String, Object>> obtenerPais() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_PAIS_SELECT, parametros);
    }
    public ArrayList<HashMap<String, Object>> obtenerTipoContratos() throws SQLException {
        Object[] parametros = new Object[]{};
        return dbCoreService.obtenerElementos(SP_TIPO_CONTRATO_SELECT, parametros);
    }
}
