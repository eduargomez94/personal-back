package com.katary.personalback.esquema.io;

import com.dslplatform.json.CompiledJson;

public class EntidadIn {

    @CompiledJson
    public static class EntidadPOST {
        private int id_entidad;
        private String nombre;
        private String tipo;

        public EntidadPOST() {
        }
        public boolean esInValido() {
            return  nombre == null || nombre.isEmpty()
                    || tipo == null || tipo.isEmpty();
        }

        public int getId_entidad() {
            return id_entidad;
        }

        public void setId_entidad(int id_entidad) {
            this.id_entidad = id_entidad;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
    }

    @CompiledJson
    public static class EntidadPUT {
        private int id_entidad;
        private String nombre;
        private String tipo;


        public EntidadPUT() {
        }

        public boolean esInValido() {
            return  nombre == null || nombre.isEmpty()
                    || tipo == null || tipo.isEmpty();
        }

        public int getId_entidad() {
            return id_entidad;
        }

        public void setId_entidad(int id_entidad) {
            this.id_entidad = id_entidad;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
    }

}
