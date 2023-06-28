package com.katary.backpersona.esquema.io;

import com.dslplatform.json.CompiledJson;

public class MenuIn {
    @CompiledJson
    public static class MenuPOST {

        private String email;
        private int id_rol;
        public MenuPOST() {
        }

        public boolean esInValido() {
            return   id_rol == 0;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getId_rol() {
            return id_rol;
        }

        public void setId_rol(int id_rol) {
            this.id_rol = id_rol;
        }
    }


}

