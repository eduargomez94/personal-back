package com.katary.backpersona.esquema.bd.contrato;
public class Consultas {

    public static final String SP_CONTRATO_SELECT = "call personal.sp_contrato_select";
    public static final String SP_CONTRATO_SELECT_X_ID_CONTRATO = "call personal.sp_contrato_select_x_id_contrato(?)";
    public static final String SP_CONTRATO_INSERT = "call personal.sp_contrato_insert(?,?,?,?,?,?,?,?,?)";
    public static final String SP_CONTRATO_UPDATE_X_ID_CONTRATO = "call personal.sp_contrato_update_x_id_contrato(?,?,?,?,?,?,?,?,?,?)";
    public static final String SP_CONTRATO_DELETE_X_ID_CONTRATO = "call personal.sp_contrato_delete_x_id_contrato(?)";

}	  