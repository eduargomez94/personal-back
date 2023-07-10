package com.katary.backpersona.esquema.bd.cliente;
public class Consultas {

    public static final String SP_CLIENTE_SELECT = "call personal.sp_cliente_select";
    public static final String SP_CLIENTE_SELECT_X_ID_CLIENTE = "call personal.sp_cliente_select_x_id_cliente(?)";
    public static final String SP_CLIENTE_INSERT = "call personal.sp_cliente_insert(?,?,?,?,?,?,?,?,?,?,?)";
    public static final String SP_CLIENTE_UPDATE_X_ID_CLIENTE = "call personal.sp_cliente_update_x_id_cliente(?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String SP_CLIENTE_DELETE_X_ID_CLIENTE = "call personal.sp_cliente_delete_x_id_cliente(?)";

}	  