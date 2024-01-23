package com.katary.personalback.esquema.bd.asignacion;

public class Consultas {
    public static final String SP_ASIGNACION_SELECT = "call personal.sp_asignacion_select";
    public static final String SP_ASIGNACION_SELECT_ID = "call personal.sp_asignacion_select_id(?)";
    public static final String SP_PROYECTO_SELECT_ASIGNACION = "call personal.sp_proyecto_select_asignacion";
    public static final String SP_ASIGNACION_TABLA_SELECT = "call personal.sp_asignacion_tabla_select";
    public static final String SP_ASIGNACION_INSERT = "call personal.sp_asignacion_insert(?,?,?,?)";
    public static final String SP_ASIGNACION_UPDATE = "call personal.sp_asignacion_update(?,?,?,?,?)";
}	  