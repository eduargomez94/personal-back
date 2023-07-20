package com.katary.backpersona.utiles;

public class Env {
    // Mysql
    public static final int PERSONA_MYSQL_CONNECTIONS = 3;
    public static final String PERSONA_MYSQL_JDBCURL = System.getenv("PERSONA_MYSQL_JDBCURL");
    public static final String PERSONA_MYSQL_USERNAME = System.getenv("PERSONA_MYSQL_USERNAME");
    public static final String PERSONA_MYSQL_PASSWORD = System.getenv("PERSONA_MYSQL_PASSWORD");
    // LOGS
    public static final String PERSONA_ENVIRONMENT = System.getenv("PERSONA_ENVIRONMENT") == null ? "" : System.getenv("PERSONA_ENVIRONMENT");

    //SFTP
    public static final String PERSONA_SFTP_HOST = System.getenv("PERSONA_SFTP_HOST");
    public static final String PERSONA_SFTP_USERNAME = System.getenv("PERSONA_SFTP_USERNAME");
    public static final String PERSONA_SFTP_PASSWORD = System.getenv("PERSONA_SFTP_PASSWORD");
    public static final String PERSONA_SFTP_RUTA_REMOTA = System.getenv("PERSONA_SFTP_RUTA_REMOTA");
}
