package com.katary.backpersona.esquema.bd.seguridad;

public class Consultas {
    public static final String SP_USUARIOS_SELECT_X_EMAIL = "call sp_usuarios_select_x_email(?)";

    public static final String SP_ROL_USUARIO_SELECT_X_EMAIL = "call sp_rol_usuario_select_x_email(?)";
}
