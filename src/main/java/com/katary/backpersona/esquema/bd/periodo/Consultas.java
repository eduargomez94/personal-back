package com.katary.backpersona.esquema.bd.periodo;
public class Consultas {

    public static final String SP_PERIODOS_NOMINA_SELECT = "call personal.sp_periodos_nomina_select";
    public static final String SP_PERIODOS_NOMINA_SELECT_X_ID_PERIODO = "call personal.sp_periodos_nomina_select_x_id_periodo(?)";
    public static final String SP_PERIODOS_NOMINA_INSERT = "call personal.sp_periodos_nomina_insert(?,?,?,?)";
    public static final String SP_PERIODOS_NOMINA_UPDATE_X_ID_PERIODO = "call personal.sp_periodos_nomina_update_x_id_periodo(?,?,?,?,?)";
    public static final String SP_PERIODOS_NOMINA_DELETE_X_ID_PERIODO = "call personal.sp_periodos_nomina_delete_x_id_periodo(?)";

}	  