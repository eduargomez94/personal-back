package com.katary.backpersona.esquema.io;

import com.dslplatform.json.CompiledJson;

public class ClienteIn {

    @CompiledJson
    public static class ClientePOST {
        private int id_cliente;
        private int tipo_documento;
        private String no_documento;
        private String nombre_razonsocial;
        private int id_ciudad;
        private String direccion;
        private String telefono_ppal;
        private String contacto;
        private String email;
        private String pagina_web;
        private String logo;
        private String estado;

        public ClientePOST() {
        }
        public boolean esInValido() {
            return no_documento == null || no_documento.isEmpty()
                    || nombre_razonsocial == null || nombre_razonsocial.isEmpty()
                    || direccion == null || direccion.isEmpty()
                    || telefono_ppal == null || telefono_ppal.isEmpty()
                    || contacto == null || contacto.isEmpty()
                    || email == null || email.isEmpty()
                    || pagina_web == null || pagina_web.isEmpty()
                    || logo == null || logo.isEmpty()
                    || estado == null || estado.isEmpty()
                    || tipo_documento == 0
                    || id_ciudad == 0;
        }

        public int getId_cliente() {
            return id_cliente;
        }

        public void setId_cliente(int id_cliente) {
            this.id_cliente = id_cliente;
        }

        public int getTipo_documento() {
            return tipo_documento;
        }

        public void setTipo_documento(int tipo_documento) {
            this.tipo_documento = tipo_documento;
        }

        public String getNo_documento() {
            return no_documento;
        }

        public void setNo_documento(String no_documento) {
            this.no_documento = no_documento;
        }

        public String getNombre_razonsocial() {
            return nombre_razonsocial;
        }

        public void setNombre_razonsocial(String nombre_razonsocial) {
            this.nombre_razonsocial = nombre_razonsocial;
        }

        public int getId_ciudad() {
            return id_ciudad;
        }

        public void setId_ciudad(int id_ciudad) {
            this.id_ciudad = id_ciudad;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getTelefono_ppal() {
            return telefono_ppal;
        }

        public void setTelefono_ppal(String telefono_ppal) {
            this.telefono_ppal = telefono_ppal;
        }

        public String getContacto() {
            return contacto;
        }

        public void setContacto(String contacto) {
            this.contacto = contacto;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPagina_web() {
            return pagina_web;
        }

        public void setPagina_web(String pagina_web) {
            this.pagina_web = pagina_web;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
    }

    @CompiledJson
    public static class ClientePUT {
        private int id_cliente;
        private int tipo_documento;
        private String no_documento;
        private String nombre_razonsocial;
        private int id_ciudad;
        private String direccion;
        private String telefono_ppal;
        private String contacto;
        private String email;
        private String pagina_web;
        private String logo;
        private String estado;


        public ClientePUT() {
        }

        public boolean esInValido() {
            return no_documento == null || no_documento.isEmpty()
                    || nombre_razonsocial == null || nombre_razonsocial.isEmpty()
                    || direccion == null || direccion.isEmpty()
                    || telefono_ppal == null || telefono_ppal.isEmpty()
                    || contacto == null || contacto.isEmpty()
                    || email == null || email.isEmpty()
                    || pagina_web == null || pagina_web.isEmpty()
                    || logo == null || logo.isEmpty()
                    || estado == null || estado.isEmpty()
                    || tipo_documento == 0
                    || id_ciudad == 0;
        }

        public int getId_cliente() {
            return id_cliente;
        }

        public void setId_cliente(int id_cliente) {
            this.id_cliente = id_cliente;
        }

        public int getTipo_documento() {
            return tipo_documento;
        }

        public void setTipo_documento(int tipo_documento) {
            this.tipo_documento = tipo_documento;
        }

        public String getNo_documento() {
            return no_documento;
        }

        public void setNo_documento(String no_documento) {
            this.no_documento = no_documento;
        }

        public String getNombre_razonsocial() {
            return nombre_razonsocial;
        }

        public void setNombre_razonsocial(String nombre_razonsocial) {
            this.nombre_razonsocial = nombre_razonsocial;
        }

        public int getId_ciudad() {
            return id_ciudad;
        }

        public void setId_ciudad(int id_ciudad) {
            this.id_ciudad = id_ciudad;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getTelefono_ppal() {
            return telefono_ppal;
        }

        public void setTelefono_ppal(String telefono_ppal) {
            this.telefono_ppal = telefono_ppal;
        }

        public String getContacto() {
            return contacto;
        }

        public void setContacto(String contacto) {
            this.contacto = contacto;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPagina_web() {
            return pagina_web;
        }

        public void setPagina_web(String pagina_web) {
            this.pagina_web = pagina_web;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
    }


}

