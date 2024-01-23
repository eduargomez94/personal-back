package com.katary.personalback.esquema.io;

import com.dslplatform.json.CompiledJson;

public class AsignacionIn {

    @CompiledJson
    public static class AsignacionPOST {
        private int id_proyecto;
        private int id_empleado;
        private String fecha_inicio;
        private String fecha_fin;

        public AsignacionPOST() {
        }

        public boolean esInValido() {
            return id_proyecto == 0
                    || id_empleado == 0;
        }

        public int getId_proyecto() {
            return id_proyecto;
        }

        public void setId_proyecto(int id_proyecto) {
            this.id_proyecto = id_proyecto;
        }

        public int getId_empleado() {
            return id_empleado;
        }

        public void setId_empleado(int id_empleado) {
            this.id_empleado = id_empleado;
        }

        public String getFecha_inicio() {
            return fecha_inicio;
        }

        public void setFecha_inicio(String fecha_inicio) {
            this.fecha_inicio = fecha_inicio;
        }

        public String getFecha_fin() {
            return fecha_fin;
        }

        public void setFecha_fin(String fecha_fin) {
            this.fecha_fin = fecha_fin;
        }
    }

    @CompiledJson
    public static class AsignacionPUT {
        private int id_proyecto;
        private int id_empleado;
        private String fecha_inicio;
        private String fecha_fin;


        public AsignacionPUT() {
        }

        public boolean esInValido() {
            return id_proyecto == 0
                    || id_empleado == 0;
        }

        public int getId_proyecto() {
            return id_proyecto;
        }

        public void setId_proyecto(int id_proyecto) {
            this.id_proyecto = id_proyecto;
        }

        public int getId_empleado() {
            return id_empleado;
        }

        public void setId_empleado(int id_empleado) {
            this.id_empleado = id_empleado;
        }

        public String getFecha_inicio() {
            return fecha_inicio;
        }

        public void setFecha_inicio(String fecha_inicio) {
            this.fecha_inicio = fecha_inicio;
        }

        public String getFecha_fin() {
            return fecha_fin;
        }

        public void setFecha_fin(String fecha_fin) {
            this.fecha_fin = fecha_fin;
        }
    }
}

