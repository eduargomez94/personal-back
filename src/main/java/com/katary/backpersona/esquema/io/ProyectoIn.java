package com.katary.backpersona.esquema.io;

import com.dslplatform.json.CompiledJson;

import java.math.BigDecimal;

public class ProyectoIn {

    @CompiledJson
    public static class ProyectoPOST {
        private int id_proyecto;
        private String nombre_proyecto;
        private String descripcion;
        private int id_tipo_proyecto;
        private String fecha_inicio;
        private String fecha_terminacion_pres;
        private String fecha_terminacion_real;
        private BigDecimal valor_presupuestado;
        private BigDecimal valor_real;
        private int id_cliente;
        private String estado;

        public ProyectoPOST() {
        }
        public boolean esInValido() {
            return  nombre_proyecto == null || nombre_proyecto.isEmpty()
                    || descripcion == null || descripcion.isEmpty()
                    || fecha_inicio == null || fecha_inicio.isEmpty()
                    || fecha_terminacion_pres == null || fecha_terminacion_pres.isEmpty()
                    || fecha_terminacion_real == null || fecha_terminacion_real.isEmpty()
                    || estado == null || estado.isEmpty()
                    || id_tipo_proyecto == 0
                    || id_cliente == 0;
        }

        public int getId_proyecto() {
            return id_proyecto;
        }

        public void setId_proyecto(int id_proyecto) {
            this.id_proyecto = id_proyecto;
        }

        public String getNombre_proyecto() {
            return nombre_proyecto;
        }

        public void setNombre_proyecto(String nombre_proyecto) {
            this.nombre_proyecto = nombre_proyecto;
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

        public String getFecha_terminacion_pres() {
            return fecha_terminacion_pres;
        }

        public void setFecha_terminacion_pres(String fecha_terminacion_pres) {
            this.fecha_terminacion_pres = fecha_terminacion_pres;
        }

        public String getFecha_terminacion_real() {
            return fecha_terminacion_real;
        }

        public void setFecha_terminacion_real(String fecha_terminacion_real) {
            this.fecha_terminacion_real = fecha_terminacion_real;
        }

        public BigDecimal getValor_presupuestado() {
            return valor_presupuestado;
        }

        public void setValor_presupuestado(BigDecimal valor_presupuestado) {
            this.valor_presupuestado = valor_presupuestado;
        }

        public BigDecimal getValor_real() {
            return valor_real;
        }

        public void setValor_real(BigDecimal valor_real) {
            this.valor_real = valor_real;
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
        private int id_proyecto;
        private String nombre_proyecto;
        private String descripcion;
        private int id_tipo_proyecto;
        private String fecha_inicio;
        private String fecha_terminacion_pres;
        private String fecha_terminacion_real;
        private BigDecimal valor_presupuestado;
        private BigDecimal valor_real;
        private int id_cliente;
        private String estado;


        public ProyectoPUT() {
        }

        public boolean esInValido() {
            return  nombre_proyecto == null || nombre_proyecto.isEmpty()
                    || descripcion == null || descripcion.isEmpty()
                    || fecha_inicio == null || fecha_inicio.isEmpty()
                    || fecha_terminacion_pres == null || fecha_terminacion_pres.isEmpty()
                    || fecha_terminacion_real == null || fecha_terminacion_real.isEmpty()
                    || estado == null || estado.isEmpty()
                    || id_tipo_proyecto == 0
                    || id_cliente == 0
            ;
        }

        public int getId_proyecto() {
            return id_proyecto;
        }

        public void setId_proyecto(int id_proyecto) {
            this.id_proyecto = id_proyecto;
        }

        public String getNombre_proyecto() {
            return nombre_proyecto;
        }

        public void setNombre_proyecto(String nombre_proyecto) {
            this.nombre_proyecto = nombre_proyecto;
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

        public String getFecha_terminacion_pres() {
            return fecha_terminacion_pres;
        }

        public void setFecha_terminacion_pres(String fecha_terminacion_pres) {
            this.fecha_terminacion_pres = fecha_terminacion_pres;
        }

        public String getFecha_terminacion_real() {
            return fecha_terminacion_real;
        }

        public void setFecha_terminacion_real(String fecha_terminacion_real) {
            this.fecha_terminacion_real = fecha_terminacion_real;
        }

        public BigDecimal getValor_presupuestado() {
            return valor_presupuestado;
        }

        public void setValor_presupuestado(BigDecimal valor_presupuestado) {
            this.valor_presupuestado = valor_presupuestado;
        }

        public BigDecimal getValor_real() {
            return valor_real;
        }

        public void setValor_real(BigDecimal valor_real) {
            this.valor_real = valor_real;
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

