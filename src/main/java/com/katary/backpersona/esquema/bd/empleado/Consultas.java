package com.katary.backpersona.esquema.bd.empleado;
public class Consultas {
    public static final String SP_EMPLEADO_INSERT = "call sp_empleado_insert(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String SP_EMPLEADO_UPDATE_X_ID_EMPLEADO = "call sp_empleado_update_x_id_empleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String SP_EMPLEADO_SELECT = "call sp_empleado_select";
    public static final String SP_EMPLEADO_SELECT_X_ID_EMPLEADO = "call sp_empleado_select_x_id_empleado(?)";
    public static final String SP_EMPLEADO_DELETE_X_ID_EMPLEADO = "call sp_empleado_delete_x_id_empleado(?)";
}
