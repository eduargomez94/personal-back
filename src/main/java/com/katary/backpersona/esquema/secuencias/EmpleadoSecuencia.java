package com.katary.backpersona.esquema.secuencias;

import com.katary.backpersona.esquema.bd.empleado.EmpleadoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class EmpleadoSecuencia {
    private final EmpleadoDB empleadoDB;
    @Autowired
    public EmpleadoSecuencia(EmpleadoDB empleadoDB) {
        this.empleadoDB = empleadoDB;
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
        return empleadoDB.crearEmpleado(id_empleado, id_tipo_doc, no_documento, apellidos, nombres, email_personal, email_corporativo, celular, direccion, id_ciudad, hoja_vida, fecha_cumpleanos, entidad_salud, entidad_pension, entidad_ARL, estado, fotografia, fecha_aniversario, perfil_tecnico);
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
        return empleadoDB.actualizarEmpleado(id_empleado,id_tipo_doc,no_documento,apellidos,nombres,email_personal,email_corporativo,celular,direccion,id_ciudad,hoja_vida,fecha_cumpleanos,entidad_salud,entidad_pension,entidad_ARL,estado,fotografia,fecha_aniversario,perfil_tecnico);
    }
    public ArrayList<HashMap<String, Object>> obtenerEmpleados() throws SQLException {
        return empleadoDB.obtenerEmpleados();
    }
    public HashMap<String, Object> obtenerEmpleado(int id_empleado) throws SQLException {
        return empleadoDB.obtenerEmpleado(id_empleado);
    }
    public HashMap<String, Object> eliminarEmpleado(int id_empleado) throws SQLException {
        return empleadoDB.eliminarEmpleado(id_empleado);
    }
    public ArrayList<HashMap<String, Object>> obtenerTiposDocumentos() throws SQLException {
        return empleadoDB.obtenerTiposDocumentos();
    }
    public ArrayList<HashMap<String, Object>> obtenerCiudades(int id_depto) throws SQLException {
        return empleadoDB.obtenerCiudades(id_depto);
    }
    public ArrayList<HashMap<String, Object>> obtenerDepartamentos(int id_pais) throws SQLException {
        return empleadoDB.obtenerDepartamentos(id_pais);
    }
    public ArrayList<HashMap<String, Object>> obtenerPais() throws SQLException {
        return empleadoDB.obtenerPais();
    }
    public ArrayList<HashMap<String, Object>> obtenerTipoContratos() throws SQLException {
        return empleadoDB.obtenerTipoContratos();
    }
}

