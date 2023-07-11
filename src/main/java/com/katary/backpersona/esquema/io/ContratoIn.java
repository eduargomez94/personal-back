package com.katary.backpersona.esquema.io;

import com.dslplatform.json.CompiledJson;

import java.math.BigDecimal;

public class ContratoIn {

    @CompiledJson
    public static class ContratoPOST {
        private int id_contrato;
        private int id_empleado;
        private int id_cargo;
        private String fecha_ingreso;
        private String fecha_retiro;
        private int empresa_ingreso;
        private int id_tipo_contrato;
        private BigDecimal salario_convenido;
        private BigDecimal bonificacion;
        private String estado;

        public ContratoPOST() {
        }
        public boolean esInValido() {
            return   fecha_ingreso == null || fecha_ingreso.isEmpty()
                    || fecha_retiro == null || fecha_retiro.isEmpty()
                    || estado == null || estado.isEmpty()
                    || id_empleado == 0
                    || id_cargo == 0
                    || empresa_ingreso == 0
                    || id_tipo_contrato == 0
            ;
        }

        public int getId_contrato() {
            return id_contrato;
        }

        public void setId_contrato(int id_contrato) {
            this.id_contrato = id_contrato;
        }

        public int getId_empleado() {
            return id_empleado;
        }

        public void setId_empleado(int id_empleado) {
            this.id_empleado = id_empleado;
        }

        public int getId_cargo() {
            return id_cargo;
        }

        public void setId_cargo(int id_cargo) {
            this.id_cargo = id_cargo;
        }

        public String getFecha_ingreso() {
            return fecha_ingreso;
        }

        public void setFecha_ingreso(String fecha_ingreso) {
            this.fecha_ingreso = fecha_ingreso;
        }

        public String getFecha_retiro() {
            return fecha_retiro;
        }

        public void setFecha_retiro(String fecha_retiro) {
            this.fecha_retiro = fecha_retiro;
        }

        public int getEmpresa_ingreso() {
            return empresa_ingreso;
        }

        public void setEmpresa_ingreso(int empresa_ingreso) {
            this.empresa_ingreso = empresa_ingreso;
        }

        public int getId_tipo_contrato() {
            return id_tipo_contrato;
        }

        public void setId_tipo_contrato(int id_tipo_contrato) {
            this.id_tipo_contrato = id_tipo_contrato;
        }

        public BigDecimal getSalario_convenido() {
            return salario_convenido;
        }

        public void setSalario_convenido(BigDecimal salario_convenido) {
            this.salario_convenido = salario_convenido;
        }

        public BigDecimal getBonificacion() {
            return bonificacion;
        }

        public void setBonificacion(BigDecimal bonificacion) {
            this.bonificacion = bonificacion;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
    }

    @CompiledJson
    public static class ContratoPUT {
        private int id_contrato;
        private int id_empleado;
        private int id_cargo;
        private String fecha_ingreso;
        private String fecha_retiro;
        private int empresa_ingreso;
        private int id_tipo_contrato;
        private BigDecimal salario_convenido;
        private BigDecimal bonificacion;
        private String estado;


        public ContratoPUT() {
        }

        public boolean esInValido() {
            return  fecha_ingreso == null || fecha_ingreso.isEmpty()
                    || fecha_retiro == null || fecha_retiro.isEmpty()
                    || estado == null || estado.isEmpty()
                    || id_empleado == 0
                    || id_cargo == 0
                    || empresa_ingreso == 0
                    || id_tipo_contrato == 0;
        }

        public int getId_contrato() {
            return id_contrato;
        }

        public void setId_contrato(int id_contrato) {
            this.id_contrato = id_contrato;
        }

        public int getId_empleado() {
            return id_empleado;
        }

        public void setId_empleado(int id_empleado) {
            this.id_empleado = id_empleado;
        }

        public int getId_cargo() {
            return id_cargo;
        }

        public void setId_cargo(int id_cargo) {
            this.id_cargo = id_cargo;
        }

        public String getFecha_ingreso() {
            return fecha_ingreso;
        }

        public void setFecha_ingreso(String fecha_ingreso) {
            this.fecha_ingreso = fecha_ingreso;
        }

        public String getFecha_retiro() {
            return fecha_retiro;
        }

        public void setFecha_retiro(String fecha_retiro) {
            this.fecha_retiro = fecha_retiro;
        }

        public int getEmpresa_ingreso() {
            return empresa_ingreso;
        }

        public void setEmpresa_ingreso(int empresa_ingreso) {
            this.empresa_ingreso = empresa_ingreso;
        }

        public int getId_tipo_contrato() {
            return id_tipo_contrato;
        }

        public void setId_tipo_contrato(int id_tipo_contrato) {
            this.id_tipo_contrato = id_tipo_contrato;
        }

        public BigDecimal getSalario_convenido() {
            return salario_convenido;
        }

        public void setSalario_convenido(BigDecimal salario_convenido) {
            this.salario_convenido = salario_convenido;
        }

        public BigDecimal getBonificacion() {
            return bonificacion;
        }

        public void setBonificacion(BigDecimal bonificacion) {
            this.bonificacion = bonificacion;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
    }


}

