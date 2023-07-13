package com.katary.backpersona.esquema.bd.entidad;

public class Consultas {
    public static final String SP_ENTIDAD_SELECT_X_TIPO = "call sp_entidad_select_x_tipo(?)";
    public static final String SP_ENTIDAD_SELECT = "call personal.sp_entidad_select";
    public static final String SP_ENTIDAD_SELECT_X_ID_ENTIDAD = "call personal.sp_entidad_select_x_id_entidad(?)";
    public static final String SP_ENTIDAD_INSERT = "call personal.sp_entidad_insert(?,?)";
    public static final String SP_ENTIDAD_UPDATE_X_ID_ENTIDAD = "call personal.sp_entidad_update_x_id_entidad(?,?,?)";
    public static final String SP_ENTIDAD_DELETE_X_ID_ENTIDAD = "call personal.sp_entidad_delete_x_id_entidad(?)";
}
