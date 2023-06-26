package com.katary.backpersona.utiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class DBCoreService {
    private final static Logger logger = LoggerFactory.getLogger(DBCoreService.class);
    public ArrayList<HashMap<String, Object>> obtenerElementos(String query, Object[] params) throws SQLException {
        try (
                Connection connection = MySqlCP.getDB().getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        query,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                )
        ) {
            int index;
            for (index = 0; index < params.length; index++) {
                statement.setObject(index + 1, params[index]);
            }

            ResultSet resultset = statement.executeQuery();
            ResultSetMetaData rsmd = resultset.getMetaData();

            resultset.last();
            int capacidad = resultset.getRow();
            if (capacidad == 0) {
                return new ArrayList<>(0);
            }
            resultset.beforeFirst();

            int cantidadColumnas = rsmd.getColumnCount();
            String[] props = new String[cantidadColumnas];
            for (index = 1; index <= cantidadColumnas; index++) {
                props[index - 1] = rsmd.getColumnName(index);
            }

            HashMap<String, Object> elemento = new HashMap<>(cantidadColumnas);
            ArrayList<HashMap<String, Object>> lista = new ArrayList<>(capacidad);
            while (resultset.next()) {
                elemento.clear();
                for (index = 0; index < cantidadColumnas; index++) {
                    elemento.put(props[index], resultset.getObject(props[index]));
                }
                lista.add(new HashMap<>(elemento));
            }
            resultset.close();

            return lista;
        }catch (Exception err) {
            logger.warn(err.getMessage() + " -> " + query);
            throw err;
        }
    }
    public HashMap<String, Object> obtenerElemento(String query, Object[] params) throws SQLException {
        try (
                Connection connection = MySqlCP.getDB().getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        query,
                        ResultSet.TYPE_FORWARD_ONLY,
                        ResultSet.CONCUR_READ_ONLY
                )
        ) {
            int index;
            for (index = 0; index < params.length; index++) {
                statement.setObject(index + 1, params[index]);
            }

            ResultSet resultset = statement.executeQuery();
            ResultSetMetaData rsmd = resultset.getMetaData();

            int cantidadColumnas = rsmd.getColumnCount();
            String[] props = new String[cantidadColumnas];

            for (index = 1; index <= cantidadColumnas; index++) {
                props[index - 1] = rsmd.getColumnName(index);
            }

            HashMap<String, Object> elemento = new HashMap<>(cantidadColumnas);
            while (resultset.next()) {
                for (index = 0; index < props.length; index++) {
                    elemento.put(props[index], resultset.getObject(props[index]));
                }
            }
            resultset.close();

            return elemento;
        } catch (Exception err) {
            logger.warn(err.getMessage() + " -> " + query);
            throw err;
        }
    }
}
