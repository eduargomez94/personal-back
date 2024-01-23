package com.katary.personalback.esquema.io;

import com.dslplatform.json.CompiledJson;

public class ClienteIn {

    @CompiledJson
    public static class ClientePOST {
        private int tipo_documento;
        private String no_documento;
        private String nombre;
        private int id_ciudad;
        private String direccion;
        private String telefono;
        private String contacto;
        private String email;
        private String pagina_web;
        private String nombre_logo;
        private String file_logo;
        private int logo;
        private String estado;

        public ClientePOST() {
        }

        public boolean esInValido() {
            return no_documento == null || no_documento.isEmpty()
                    || nombre == null || nombre.isEmpty()
                    || tipo_documento == 0;
                    /*|| direccion == null || direccion.isEmpty()
                    || telefono == null || telefono.isEmpty()
                    || contacto == null || contacto.isEmpty()
                    || email == null || email.isEmpty()
                    || pagina_web == null || pagina_web.isEmpty()
                    || logo == null || logo.isEmpty()
                    || estado == null || estado.isEmpty()
                    || id_ciudad == 0;*/
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

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
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

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
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

        public String getNombre_logo() {
            return nombre_logo;
        }

        public void setNombre_logo(String nombre_logo) {
            this.nombre_logo = nombre_logo;
        }

        public String getFile_logo() {
            return file_logo;
        }

        public void setFile_logo(String file_logo) {
            this.file_logo = file_logo;
        }

        public int getLogo() {
            return logo;
        }

        public void setLogo(int logo) {
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
        private int tipo_documento;
        private String no_documento;
        private String nombre;
        private int id_ciudad;
        private String direccion;
        private String telefono;
        private String contacto;
        private String email;
        private String pagina_web;
        private String nombre_logo;
        private String file_logo;
        private int logo;
        private String estado;


        public ClientePUT() {
        }

        public boolean esInValido() {
            return no_documento == null || no_documento.isEmpty()
                    || nombre == null || nombre.isEmpty()
                    || tipo_documento == 0;
                    /*|| direccion == null || direccion.isEmpty()
                    || telefono == null || telefono.isEmpty()
                    || contacto == null || contacto.isEmpty()
                    || email == null || email.isEmpty()
                    || pagina_web == null || pagina_web.isEmpty()
                    || logo == null || logo.isEmpty()
                    || estado == null || estado.isEmpty()
                    || id_ciudad == 0;*/
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

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
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

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
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

        public String getNombre_logo() {
            return nombre_logo;
        }

        public void setNombre_logo(String nombre_logo) {
            this.nombre_logo = nombre_logo;
        }

        public String getFile_logo() {
            return file_logo;
        }

        public void setFile_logo(String file_logo) {
            this.file_logo = file_logo;
        }

        public int getLogo() {
            return logo;
        }

        public void setLogo(int logo) {
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

