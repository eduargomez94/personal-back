package com.katary.backpersona.utiles;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

public class MySqlCP {
    private final static Logger logger = LoggerFactory.getLogger(MySqlCP.class);

    public static boolean iniciado = false;
    private static DataSource db;

    private static synchronized void createPool() {
        if (iniciado) return;

        HikariConfig config = new HikariConfig();



        config.setJdbcUrl(Env.PERSONA_MYSQL_JDBCURL);
        config.setUsername(Env.PERSONA_MYSQL_USERNAME);
        config.setPassword(Env.PERSONA_MYSQL_PASSWORD);
        config.setMaximumPoolSize(Env.PERSONA_MYSQL_CONNECTIONS);

        MySqlCP.db = new HikariDataSource(config);
        iniciado = true;

        logger.info("+-------------------------------+");
        logger.info("|       Connected to MySQL      |");
        logger.info("+-------------------------------+");
    }

    public static DataSource getDB() {
        if (!iniciado) createPool();
        return MySqlCP.db;
    }
}
