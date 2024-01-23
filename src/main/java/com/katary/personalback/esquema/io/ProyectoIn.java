package com.katary.personalback.esquema.io;

import com.dslplatform.json.CompiledJson;

import java.math.BigDecimal;

public class ProyectoIn {

    @CompiledJson
    public static class ProyectoPOST {
        private String nombre;
        private String descripcion;
        private int id_tipo_proyecto;
        private String fecha_inicio;
        private String fecha_fin_proyectada;
        private String fecha_fin_real;
        private BigDecimal valor_presupuestado;
        private int id_cliente;
        private String estado;

        public ProyectoPOST() {
        }

        public boolean esInValido() {
            return nombre == null || nombre.isEmpty()
                    || id_cliente == 0;
                    /*
                    || descripcion == null || descripcion.isEmpty()
                    || fecha_inicio == null || fecha_inicio.isEmpty()
                    || fecha_terminacion_pres == null || fecha_terminacion_pres.isEmpty()
                    || fecha_terminacion_real == null || fecha_terminacion_real.isEmpty()
                    || estado == null || estado.isEmpty()
                    || id_tipo_proyecto == 0;*/
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public int getId_tipo_proyecto() {
            return id_tipo_proyecto;
        }

        public void setId_tipo_proyecto(int id_tipo_proyecto) {
            this.id_tipo_proyecto = id_tipo_proyecto;
        }

        public String getFecha_inicio() {
            return fecha_inicio;
        }

        public void setFecha_inicio(String fecha_inicio) {
            this.fecha_inicio = fecha_inicio;
        }

        public String getFecha_fin_proyectada() {
            return fecha_fin_proyectada;
        }

        public void setFecha_fin_proyectada(String fecha_fin_proyectada) {
            this.fecha_fin_proyectada = fecha_fin_proyectada;
        }

        public String getFecha_fin_real() {
            return fecha_fin_real;
        }

        public void setFecha_fin_real(String fecha_fin_real) {
            this.fecha_fin_real = fecha_fin_real;
        }

        public BigDecimal getValor_presupuestado() {
            return valor_presupuestado;
        }

        public void setValor_presupuestado(BigDecimal valor_presupuestado) {
            this.valor_presupuestado = valor_presupuestado;
        }

        public int getId_cliente() {
            return id_cliente;
        }

        public void setId_cliente(int id_cliente) {
            this.id_cliente = id_cliente;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
    }

    @CompiledJson
    public static class ProyectoPUT {
        private String nombre;
        private String descripcion;
        private int id_tipo_proyecto;
        private String fecha_inicio;
        private String fecha_fin_proyectada;
        private String fecha_fin_real;
        private BigDecimal valor_presupuestado;
        private int id_cliente;
        private String estado;


        public ProyectoPUT() {
        }

        public boolean esInValido() {
            return nombre == null || nombre.isEmpty()
                    || id_cliente == 0;
                    /*
                    || descripcion == null || descripcion.isEmpty()
                    || fecha_inicio == null || fecha_inicio.isEmpty()
                    || fecha_terminacion_pres == null || fecha_terminacion_pres.isEmpty()
                    || fecha_terminacion_real == null || fecha_terminacion_real.isEmpty()
                    || estado == null || estado.isEmpty()
                    || id_tipo_proyecto == 0;*/
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public int getId_tipo_proyecto() {
            return id_tipo_proyecto;
        }

        public void setId_tipo_proyecto(int id_tipo_proyecto) {
            this.id_tipo_proyecto = id_tipo_proyecto;
        }

        public String getFecha_inicio() {
            return fecha_inicio;
        }

        public void setFecha_inicio(String fecha_inicio) {
            this.fecha_inicio = fecha_inicio;
        }

        public String getFecha_fin_proyectada() {
            return fecha_fin_proyectada;
        }

        public void setFecha_fin_proyectada(String fecha_fin_proyectada) {
            this.fecha_fin_proyectada = fecha_fin_proyectada;
        }

        public String getFecha_fin_real() {
            return fecha_fin_real;
        }

        public void setFecha_fin_real(String fecha_fin_real) {
            this.fecha_fin_real = fecha_fin_real;
        }

        public BigDecimal getValor_presupuestado() {
            return valor_presupuestado;
        }

        public void setValor_presupuestado(BigDecimal valor_presupuestado) {
            this.valor_presupuestado = valor_presupuestado;
        }

        public int getId_cliente() {
            return id_cliente;
        }

        public void setId_cliente(int id_cliente) {
            this.id_cliente = id_cliente;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
    }


}

