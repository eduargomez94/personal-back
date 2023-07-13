package com.katary.backpersona.esquema.bd.cargo;
public class Consultas {

    public static final String SP_CARGO_SELECT = "call personal.sp_cargo_select";
    public static final String SP_CARGO_SELECT_X_ID_CARGO = "call personal.sp_cargo_select_x_id_cargo(?)";
    public static final String SP_CARGO_INSERT = "call personal.sp_cargo_insert(?,?)";
    public static final String SP_CARGO_UPDATE_X_ID_CARGO = "call personal.sp_cargo_update_x_id_cargo(?,?,?)";
    public static final String SP_CARGO_DELETE_X_ID_CARGO = "call personal.sp_cargo_delete_x_id_cargo(?)";

}	  