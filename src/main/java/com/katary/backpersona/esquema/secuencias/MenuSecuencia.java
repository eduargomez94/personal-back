package com.katary.backpersona.esquema.secuencias;

import com.katary.backpersona.esquema.bd.menu.MenuDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MenuSecuencia {
    private final MenuDB menuDB;

    @Autowired
    public MenuSecuencia(MenuDB menuDB) {
        this.menuDB = menuDB;
    }

    public ArrayList<HashMap<String, Object>> obtenerMenus(String email,
                                                           int id_rol
                                                           ) throws SQLException {
        return menuDB.obtenerMenus(email,id_rol);
    }
}

