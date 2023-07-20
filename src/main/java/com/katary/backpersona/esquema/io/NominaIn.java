package com.katary.backpersona.esquema.io;

import com.dslplatform.json.CompiledJson;

import java.math.BigDecimal;

public class NominaIn {

    @CompiledJson
    public static class NominaPOST {
        private int id_nomina;
        private int id_contrato;
        private BigDecimal dev_basico;
        private BigDecimal dev_transporte;
        private BigDecimal ded_salud;
        private BigDecimal ded_pension;
        private BigDecimal ded_celular;
        private BigDecimal ded_retencion;
        private BigDecimal ded_otros;
        private BigDecimal neto;
        private BigDecimal cesantias;
        private BigDecimal intereses;
        private BigDecimal prima;
        private BigDecimal vacaciones;
        private BigDecimal pension;
        private BigDecimal comfamiliar;
        private BigDecimal riesgos;
        private BigDecimal total_mes;
        private BigDecimal costo_hora;
        private int dias_trabajados;
        private int id_periodo;

        public NominaPOST() {
        }
        public boolean esInValido() {
            return id_contrato == 0
                    || dias_trabajados == 0
                    || id_periodo == 0
            ;
        }

        public int getId_nomina() {
            return id_nomina;
        }

        public void setId_nomina(int id_nomina) {
            this.id_nomina = id_nomina;
        }

        public int getId_contrato() {
            return id_contrato;
        }

        public void setId_contrato(int id_contrato) {
            this.id_contrato = id_contrato;
        }

        public BigDecimal getDev_basico() {
            return dev_basico;
        }

        public void setDev_basico(BigDecimal dev_basico) {
            this.dev_basico = dev_basico;
        }

        public BigDecimal getDev_transporte() {
            return dev_transporte;
        }

        public void setDev_transporte(BigDecimal dev_transporte) {
            this.dev_transporte = dev_transporte;
        }

        public BigDecimal getDed_salud() {
            return ded_salud;
        }

        public void setDed_salud(BigDecimal ded_salud) {
            this.ded_salud = ded_salud;
        }

        public BigDecimal getDed_pension() {
            return ded_pension;
        }

        public void setDed_pension(BigDecimal ded_pension) {
            this.ded_pension = ded_pension;
        }

        public BigDecimal getDed_celular() {
            return ded_celular;
        }

        public void setDed_celular(BigDecimal ded_celular) {
            this.ded_celular = ded_celular;
        }

        public BigDecimal getDed_retencion() {
            return ded_retencion;
        }

        public void setDed_retencion(BigDecimal ded_retencion) {
            this.ded_retencion = ded_retencion;
        }

        public BigDecimal getDed_otros() {
            return ded_otros;
        }

        public void setDed_otros(BigDecimal ded_otros) {
            this.ded_otros = ded_otros;
        }

        public BigDecimal getNeto() {
            return neto;
        }

        public void setNeto(BigDecimal neto) {
            this.neto = neto;
        }

        public BigDecimal getCesantias() {
            return cesantias;
        }

        public void setCesantias(BigDecimal cesantias) {
            this.cesantias = cesantias;
        }

        public BigDecimal getIntereses() {
            return intereses;
        }

        public void setIntereses(BigDecimal intereses) {
            this.intereses = intereses;
        }

        public BigDecimal getPrima() {
            return prima;
        }

        public void setPrima(BigDecimal prima) {
            this.prima = prima;
        }

        public BigDecimal getVacaciones() {
            return vacaciones;
        }

        public void setVacaciones(BigDecimal vacaciones) {
            this.vacaciones = vacaciones;
        }

        public BigDecimal getPension() {
            return pension;
        }

        public void setPension(BigDecimal pension) {
            this.pension = pension;
        }

        public BigDecimal getComfamiliar() {
            return comfamiliar;
        }

        public void setComfamiliar(BigDecimal comfamiliar) {
            this.comfamiliar = comfamiliar;
        }

        public BigDecimal getRiesgos() {
            return riesgos;
        }

        public void setRiesgos(BigDecimal riesgos) {
            this.riesgos = riesgos;
        }

        public BigDecimal getTotal_mes() {
            return total_mes;
        }

        public void setTotal_mes(BigDecimal total_mes) {
            this.total_mes = total_mes;
        }

        public BigDecimal getCosto_hora() {
            return costo_hora;
        }

        public void setCosto_hora(BigDecimal costo_hora) {
            this.costo_hora = costo_hora;
        }

        public int getDias_trabajados() {
            return dias_trabajados;
        }

        public void setDias_trabajados(int dias_trabajados) {
            this.dias_trabajados = dias_trabajados;
        }

        public int getId_periodo() {
            return id_periodo;
        }

        public void setId_periodo(int id_periodo) {
            this.id_periodo = id_periodo;
        }
    }

    @CompiledJson
    public static class NominaPUT {
        private int id_nomina;
        private int id_contrato;
        private BigDecimal dev_basico;
        private BigDecimal dev_transporte;
        private BigDecimal ded_salud;
        private BigDecimal ded_pension;
        private BigDecimal ded_celular;
        private BigDecimal ded_retencion;
        private BigDecimal ded_otros;
        private BigDecimal neto;
        private BigDecimal cesantias;
        private BigDecimal intereses;
        private BigDecimal prima;
        private BigDecimal vacaciones;
        private BigDecimal pension;
        private BigDecimal comfamiliar;
        private BigDecimal riesgos;
        private BigDecimal total_mes;
        private BigDecimal costo_hora;
        private int dias_trabajados;
        private int id_periodo;


        public NominaPUT() {
        }

        public boolean esInValido() {
            return   id_contrato == 0
                    || dias_trabajados == 0
                    || id_periodo == 0;
        }

        public int getId_nomina() {
            return id_nomina;
        }

        public void setId_nomina(int id_nomina) {
            this.id_nomina = id_nomina;
        }

        public int getId_contrato() {
            return id_contrato;
        }

        public void setId_contrato(int id_contrato) {
            this.id_contrato = id_contrato;
        }

        public BigDecimal getDev_basico() {
            return dev_basico;
        }

        public void setDev_basico(BigDecimal dev_basico) {
            this.dev_basico = dev_basico;
        }

        public BigDecimal getDev_transporte() {
            return dev_transporte;
        }

        public void setDev_transporte(BigDecimal dev_transporte) {
            this.dev_transporte = dev_transporte;
        }

        public BigDecimal getDed_salud() {
            return ded_salud;
        }

        public void setDed_salud(BigDecimal ded_salud) {
            this.ded_salud = ded_salud;
        }

        public BigDecimal getDed_pension() {
            return ded_pension;
        }

        public void setDed_pension(BigDecimal ded_pension) {
            this.ded_pension = ded_pension;
        }

        public BigDecimal getDed_celular() {
            return ded_celular;
        }

        public void setDed_celular(BigDecimal ded_celular) {
            this.ded_celular = ded_celular;
        }

        public BigDecimal getDed_retencion() {
            return ded_retencion;
        }

        public void setDed_retencion(BigDecimal ded_retencion) {
            this.ded_retencion = ded_retencion;
        }

        public BigDecimal getDed_otros() {
            return ded_otros;
        }

        public void setDed_otros(BigDecimal ded_otros) {
            this.ded_otros = ded_otros;
        }

        public BigDecimal getNeto() {
            return neto;
        }

        public void setNeto(BigDecimal neto) {
            this.neto = neto;
        }

        public BigDecimal getCesantias() {
            return cesantias;
        }

        public void setCesantias(BigDecimal cesantias) {
            this.cesantias = cesantias;
        }

        public BigDecimal getIntereses() {
            return intereses;
        }

        public void setIntereses(BigDecimal intereses) {
            this.intereses = intereses;
        }

        public BigDecimal getPrima() {
            return prima;
        }

        public void setPrima(BigDecimal prima) {
            this.prima = prima;
        }

        public BigDecimal getVacaciones() {
            return vacaciones;
        }

        public void setVacaciones(BigDecimal vacaciones) {
            this.vacaciones = vacaciones;
        }

        public BigDecimal getPension() {
            return pension;
        }

        public void setPension(BigDecimal pension) {
            this.pension = pension;
        }

        public BigDecimal getComfamiliar() {
            return comfamiliar;
        }

        public void setComfamiliar(BigDecimal comfamiliar) {
            this.comfamiliar = comfamiliar;
        }

        public BigDecimal getRiesgos() {
            return riesgos;
        }

        public void setRiesgos(BigDecimal riesgos) {
            this.riesgos = riesgos;
        }

        public BigDecimal getTotal_mes() {
            return total_mes;
        }

        public void setTotal_mes(BigDecimal total_mes) {
            this.total_mes = total_mes;
        }

        public BigDecimal getCosto_hora() {
            return costo_hora;
        }

        public void setCosto_hora(BigDecimal costo_hora) {
            this.costo_hora = costo_hora;
        }

        public int getDias_trabajados() {
            return dias_trabajados;
        }

        public void setDias_trabajados(int dias_trabajados) {
            this.dias_trabajados = dias_trabajados;
        }

        public int getId_periodo() {
            return id_periodo;
        }

        public void setId_periodo(int id_periodo) {
            this.id_periodo = id_periodo;
        }
    }

}

