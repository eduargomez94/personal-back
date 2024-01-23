package com.katary.personalback.esquema.bd.proyecto;
public class Consultas {

    public static final String SP_PROYECTO_SELECT = "call personal.sp_proyecto_select";
    public static final String SP_PROYECTO_ACTIVOS_SELECT = "call personal.sp_proyecto_activos_select";
    public static final String SP_PROYECTO_SELECT_X_ID_PROYECTO = "call personal.sp_proyecto_select_x_id_proyecto(?)";
    public static final String SP_PROYECTO_INSERT = "call personal.sp_proyecto_insert(?,?,?,?,?,?,?,?,?)";
    public static final String SP_PROYECTO_UPDATE_X_ID_PROYECTO = "call personal.sp_proyecto_update_x_id_proyecto(?,?,?,?,?,?,?,?,?,?)";
    public static final String SP_PROYECTO_DELETE_X_ID_PROYECTO = "call personal.sp_proyecto_delete_x_id_proyecto(?)";

    public static final String SP_TIPO_PROYECTO_SELECT = "call personal.sp_tipo_proyecto_select";

}	  