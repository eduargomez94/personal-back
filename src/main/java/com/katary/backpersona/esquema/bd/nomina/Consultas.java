package com.katary.backpersona.esquema.bd.nomina;
public class Consultas {

    public static final String SP_NOMINA_SELECT = "call personal.sp_nomina_select";
    public static final String SP_NOMINA_SELECT_X_ID_NOMINA = "call personal.sp_nomina_select_x_id_nomina(?)";
    public static final String SP_NOMINA_INSERT = "call personal.sp_nomina_insert(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String SP_NOMINA_UPDATE_X_ID_NOMINA = "call personal.sp_nomina_update_x_id_nomina(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String SP_NOMINA_DELETE_X_ID_NOMINA = "call personal.sp_nomina_delete_x_id_nomina(?)";

}	  