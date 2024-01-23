package com.katary.personalback.esquema.io;

import com.dslplatform.json.CompiledJson;

public class CargoIn {

    @CompiledJson
    public static class CargoPOST {
        private int id_cargo;
        private String descripcion_cargo;
        private int id_categoria;

        public CargoPOST() {
        }
        public boolean esInValido() {
            return descripcion_cargo == null || descripcion_cargo.isEmpty()
                    || id_categoria == 0;
        }

        public int getId_cargo() {
            return id_cargo;
        }

        public void setId_cargo(int id_cargo) {
            this.id_cargo = id_cargo;
        }

        public String getDescripcion_cargo() {
            return descripcion_cargo;
        }

        public void setDescripcion_cargo(String descripcion_cargo) {
            this.descripcion_cargo = descripcion_cargo;
        }

        public int getId_categoria() {
            return id_categoria;
        }

        public void setId_categoria(int id_categoria) {
            this.id_categoria = id_categoria;
        }
    }

    @CompiledJson
    public static class CargoPUT {
        private int id_cargo;
        private String descripcion_cargo;
        private int id_categoria;


        public CargoPUT() {
        }

        public boolean esInValido() {
            return descripcion_cargo == null || descripcion_cargo.isEmpty()
                    || id_categoria == 0;
        }

        public int getId_cargo() {
            return id_cargo;
        }

        public void setId_cargo(int id_cargo) {
            this.id_cargo = id_cargo;
        }

        public String getDescripcion_cargo() {
            return descripcion_cargo;
        }

        public void setDescripcion_cargo(String descripcion_cargo) {
            this.descripcion_cargo = descripcion_cargo;
        }

        public int getId_categoria() {
            return id_categoria;
        }

        public void setId_categoria(int id_categoria) {
            this.id_categoria = id_categoria;
        }
    }


}

