package com.katary.backpersona.esquema.bd.empleado;

import com.katary.backpersona.esquema.io.EmpleadoIn;
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

    public int crearEmpleado(EmpleadoIn.EmpleadoPOST body) throws SQLException {
        Object[] parametros = new Object[]{
                body.getId_tipo_doc(),
                body.getNo_documento(),
                body.getApellidos(),
                body.getNombres(),
                body.getEmail_personal(),
                body.getEmail_corporativo(),
                body.getCelular(),
                body.getDireccion(),
                body.getId_ciudad(),
                body.getFecha_cumpleanos(),
                body.getEntidad_salud(),
                body.getEntidad_pension(),
                body.getEntidad_ARL(),
                body.getEstado(),
                body.getFecha_aniversario(),
                body.getPerfil_tecnico()
        };
        return dbCoreService.ejecutarQuery(SP_EMPLEADO_INSERT, parametros);
    }

    public int actualizarEmpleado(int id_empleado, EmpleadoIn.EmpleadoPUT body) throws SQLException {
        Object[] parametros = new Object[]{
                id_empleado,
                body.getId_tipo_doc(),
                body.getNo_documento(),
                body.getApellidos(),
                body.getNombres(),
                body.getEmail_personal(),
                body.getEmail_corporativo(),
                body.getCelular(),
                body.getDireccion(),
                body.getId_ciudad(),
                body.getFecha_cumpleanos(),
                body.getEntidad_salud(),
                body.getEntidad_pension(),
                body.getEntidad_ARL(),
                body.getEstado(),
                body.getFecha_aniversario(),
                body.getPerfil_tecnico()
        };
        return dbCoreService.ejecutarQuery(SP_EMPLEADO_UPDATE_X_ID_EMPLEADO, parametros);
    }

    public int actualizarEmpleadoFoto(int id_empleado, String fotografia, String url_fotografia) throws SQLException {
        Object[] parametros = new Object[]{
                id_empleado,
                fotografia,
                url_fotografia
        };
        return dbCoreService.ejecutarQuery(SP_EMPLEADO_UPDATE_FOTO_X_ID, parametros);
    }

    public int actualizarEmpleadoHoja(int id_empleado, String hoja_vida, String url_hoja_vida) throws SQLException {
        Object[] parametros = new Object[]{
                id_empleado,
                hoja_vida,
                url_hoja_vida
        };
        return dbCoreService.ejecutarQuery(SP_EMPLEADO_UPDATE_HOJA_X_ID, parametros);
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
