package com.katary.backpersona.esquema.io;

import com.dslplatform.json.CompiledJson;

public class PeriodoIn {

    @CompiledJson
    public static class PeriodoPOST {
        private int id_periodo;
        private int anio;
        private int mes;
        private String fecha_inicial;
        private String fecha_final;

        public PeriodoPOST() {
        }
        public boolean esInValido() {
            return  fecha_inicial == null || fecha_inicial.isEmpty()
                    || fecha_final == null || fecha_final.isEmpty()
                    || anio == 0
                    || mes == 0
            ;
        }

        public int getId_periodo() {
            return id_periodo;
        }

        public void setId_periodo(int id_periodo) {
            this.id_periodo = id_periodo;
        }

        public int getAnio() {
            return anio;
        }

        public void setAnio(int anio) {
            this.anio = anio;
        }

        public int getMes() {
            return mes;
        }

        public void setMes(int mes) {
            this.mes = mes;
        }

        public String getFecha_inicial() {
            return fecha_inicial;
        }

        public void setFecha_inicial(String fecha_inicial) {
            this.fecha_inicial = fecha_inicial;
        }

        public String getFecha_final() {
            return fecha_final;
        }

        public void setFecha_final(String fecha_final) {
            this.fecha_final = fecha_final;
        }
    }

    @CompiledJson
    public static class PeriodoPUT {
        private int id_periodo;
        private int anio;
        private int mes;
        private String fecha_inicial;
        private String fecha_final;


        public PeriodoPUT() {
        }

        public boolean esInValido() {
            return  fecha_inicial == null || fecha_inicial.isEmpty()
                    || fecha_final == null || fecha_final.isEmpty()
                    || anio == 0
                    || mes == 0
            ;
        }

        public int getId_periodo() {
            return id_periodo;
        }

        public void setId_periodo(int id_periodo) {
            this.id_periodo = id_periodo;
        }

        public int getAnio() {
            return anio;
        }

        public void setAnio(int anio) {
            this.anio = anio;
        }

        public int getMes() {
            return mes;
        }

        public void setMes(int mes) {
            this.mes = mes;
        }

        public String getFecha_inicial() {
            return fecha_inicial;
        }

        public void setFecha_inicial(String fecha_inicial) {
            this.fecha_inicial = fecha_inicial;
        }

        public String getFecha_final() {
            return fecha_final;
        }

        public void setFecha_final(String fecha_final) {
            this.fecha_final = fecha_final;
        }
    }
}

