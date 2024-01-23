package com.katary.personalback.esquema.io;
import com.dslplatform.json.CompiledJson;
public class EmpleadoIn {
    @CompiledJson
    public static class EmpleadoPOST {
        private int id_empleado;
        private int id_tipo_doc;
        private String no_documento;
        private String apellidos;
        private String nombres;
        private String email_personal;
        private String email_corporativo;
        private String celular;
        private String direccion;
        private int id_ciudad;
        private String hoja_vida;
        private String fecha_cumpleanos;
        private int entidad_salud;
        private int entidad_pension;
        private int entidad_ARL;
        private String estado;
        private String fotografia;
        private String fecha_aniversario;
        private String perfil_tecnico;
        private String file_foto;
        private String url_fotografia;
        private String file_hoja;
        private String url_hoja_vida;

        public EmpleadoPOST() {
        }

        public boolean esInValido() {
            return  no_documento == null || no_documento.isEmpty()
                    || apellidos == null || apellidos.isEmpty()
                    || nombres == null || nombres.isEmpty()
                    || id_tipo_doc == 0;
            /*
                    || email_personal == null || email_personal.isEmpty()
                    || email_corporativo == null || email_corporativo.isEmpty()
                    || celular == null || celular.isEmpty()
                    || direccion == null || direccion.isEmpty()
                    || fecha_cumpleanos == null || fecha_cumpleanos.isEmpty()
                    || estado == null || estado.isEmpty()
                    || fecha_aniversario == null || fecha_aniversario.isEmpty()
                    || perfil_tecnico == null || perfil_tecnico.isEmpty()

                    || id_ciudad == 0
                    || entidad_salud == 0
                    || entidad_pension == 0
                    || entidad_ARL == 0;*/
        }
        public int getId_empleado() {
            return id_empleado;
        }
        public void setId_empleado(int id_empleado) {
            this.id_empleado = id_empleado;
        }

        public int getId_tipo_doc() {
            return id_tipo_doc;
        }

        public void setId_tipo_doc(int id_tipo_doc) {
            this.id_tipo_doc = id_tipo_doc;
        }

        public String getNo_documento() {
            return no_documento;
        }

        public void setNo_documento(String no_documento) {
            this.no_documento = no_documento;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public String getNombres() {
            return nombres;
        }

        public void setNombres(String nombres) {
            this.nombres = nombres;
        }

        public String getEmail_personal() {
            return email_personal;
        }

        public void setEmail_personal(String email_personal) {
            this.email_personal = email_personal;
        }

        public String getEmail_corporativo() {
            return email_corporativo;
        }

        public void setEmail_corporativo(String email_corporativo) {
            this.email_corporativo = email_corporativo;
        }

        public String getCelular() {
            return celular;
        }

        public void setCelular(String celular) {
            this.celular = celular;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public int getId_ciudad() {
            return id_ciudad;
        }

        public void setId_ciudad(int id_ciudad) {
            this.id_ciudad = id_ciudad;
        }

        public String getHoja_vida() {
            return hoja_vida;
        }

        public void setHoja_vida(String hoja_vida) {
            this.hoja_vida = hoja_vida;
        }

        public String getFecha_cumpleanos() {
            return fecha_cumpleanos;
        }

        public void setFecha_cumpleanos(String fecha_cumpleanos) {
            this.fecha_cumpleanos = fecha_cumpleanos;
        }

        public int getEntidad_salud() {
            return entidad_salud;
        }

        public void setEntidad_salud(int entidad_salud) {
            this.entidad_salud = entidad_salud;
        }

        public int getEntidad_pension() {
            return entidad_pension;
        }

        public void setEntidad_pension(int entidad_pension) {
            this.entidad_pension = entidad_pension;
        }

        public int getEntidad_ARL() {
            return entidad_ARL;
        }

        public void setEntidad_ARL(int entidad_ARL) {
            this.entidad_ARL = entidad_ARL;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getFotografia() {
            return fotografia;
        }

        public void setFotografia(String fotografia) {
            this.fotografia = fotografia;
        }

        public String getFecha_aniversario() {
            return fecha_aniversario;
        }

        public void setFecha_aniversario(String fecha_aniversario) {
            this.fecha_aniversario = fecha_aniversario;
        }

        public String getPerfil_tecnico() {
            return perfil_tecnico;
        }

        public void setPerfil_tecnico(String perfil_tecnico) {
            this.perfil_tecnico = perfil_tecnico;
        }

        public String getFile_foto() {
            return file_foto;
        }

        public void setFile_foto(String file_foto) {
            this.file_foto = file_foto;
        }

        public String getUrl_fotografia() {
            return url_fotografia;
        }

        public void setUrl_fotografia(String url_fotografia) {
            this.url_fotografia = url_fotografia;
        }

        public String getFile_hoja() {
            return file_hoja;
        }

        public void setFile_hoja(String file_hoja) {
            this.file_hoja = file_hoja;
        }

        public String getUrl_hoja_vida() {
            return url_hoja_vida;
        }

        public void setUrl_hoja_vida(String url_hoja_vida) {
            this.url_hoja_vida = url_hoja_vida;
        }
    }
    @CompiledJson
    public static class EmpleadoPUT {
        private int id_empleado;
        private int id_tipo_doc;
        private String no_documento;
        private String apellidos;
        private String nombres;
        private String email_personal;
        private String email_corporativo;
        private String celular;
        private String direccion;
        private int id_ciudad;
        private String hoja_vida;
        private String fecha_cumpleanos;
        private int entidad_salud;
        private int entidad_pension;
        private int entidad_ARL;
        private String estado;
        private String fotografia;
        private String fecha_aniversario;
        private String perfil_tecnico;
        private String file_foto;
        private String url_fotografia;
        private String file_hoja;
        private String url_hoja_vida;

        public EmpleadoPUT() {
        }

        public boolean esInValido() {
            return  no_documento == null || no_documento.isEmpty()
                    || apellidos == null || apellidos.isEmpty()
                    || nombres == null || nombres.isEmpty()
                    || id_tipo_doc == 0;
            /*
                    || email_personal == null || email_personal.isEmpty()
                    || email_corporativo == null || email_corporativo.isEmpty()
                    || celular == null || celular.isEmpty()
                    || direccion == null || direccion.isEmpty()
                    || fecha_cumpleanos == null || fecha_cumpleanos.isEmpty()
                    || estado == null || estado.isEmpty()
                    || fecha_aniversario == null || fecha_aniversario.isEmpty()
                    || perfil_tecnico == null || perfil_tecnico.isEmpty()

                    || id_ciudad == 0
                    || entidad_salud == 0
                    || entidad_pension == 0
                    || entidad_ARL == 0;*/
        }

        public int getId_empleado() {
            return id_empleado;
        }

        public void setId_empleado(int id_empleado) {
            this.id_empleado = id_empleado;
        }

        public int getId_tipo_doc() {
            return id_tipo_doc;
        }

        public void setId_tipo_doc(int id_tipo_doc) {
            this.id_tipo_doc = id_tipo_doc;
        }

        public String getNo_documento() {
            return no_documento;
        }

        public void setNo_documento(String no_documento) {
            this.no_documento = no_documento;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public String getNombres() {
            return nombres;
        }

        public void setNombres(String nombres) {
            this.nombres = nombres;
        }

        public String getEmail_personal() {
            return email_personal;
        }

        public void setEmail_personal(String email_personal) {
            this.email_personal = email_personal;
        }

        public String getEmail_corporativo() {
            return email_corporativo;
        }

        public void setEmail_corporativo(String email_corporativo) {
            this.email_corporativo = email_corporativo;
        }

        public String getCelular() {
            return celular;
        }

        public void setCelular(String celular) {
            this.celular = celular;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public int getId_ciudad() {
            return id_ciudad;
        }

        public void setId_ciudad(int id_ciudad) {
            this.id_ciudad = id_ciudad;
        }

        public String getHoja_vida() {
            return hoja_vida;
        }

        public void setHoja_vida(String hoja_vida) {
            this.hoja_vida = hoja_vida;
        }

        public String getFecha_cumpleanos() {
            return fecha_cumpleanos;
        }

        public void setFecha_cumpleanos(String fecha_cumpleanos) {
            this.fecha_cumpleanos = fecha_cumpleanos;
        }

        public int getEntidad_salud() {
            return entidad_salud;
        }

        public void setEntidad_salud(int entidad_salud) {
            this.entidad_salud = entidad_salud;
        }

        public int getEntidad_pension() {
            return entidad_pension;
        }

        public void setEntidad_pension(int entidad_pension) {
            this.entidad_pension = entidad_pension;
        }

        public int getEntidad_ARL() {
            return entidad_ARL;
        }

        public void setEntidad_ARL(int entidad_ARL) {
            this.entidad_ARL = entidad_ARL;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getFotografia() {
            return fotografia;
        }

        public void setFotografia(String fotografia) {
            this.fotografia = fotografia;
        }

        public String getFecha_aniversario() {
            return fecha_aniversario;
        }

        public void setFecha_aniversario(String fecha_aniversario) {
            this.fecha_aniversario = fecha_aniversario;
        }

        public String getPerfil_tecnico() {
            return perfil_tecnico;
        }

        public void setPerfil_tecnico(String perfil_tecnico) {
            this.perfil_tecnico = perfil_tecnico;
        }

        public String getFile_foto() {
            return file_foto;
        }

        public void setFile_foto(String file_foto) {
            this.file_foto = file_foto;
        }

        public String getUrl_fotografia() {
            return url_fotografia;
        }

        public void setUrl_fotografia(String url_fotografia) {
            this.url_fotografia = url_fotografia;
        }

        public String getFile_hoja() {
            return file_hoja;
        }

        public void setFile_hoja(String file_hoja) {
            this.file_hoja = file_hoja;
        }

        public String getUrl_hoja_vida() {
            return url_hoja_vida;
        }

        public void setUrl_hoja_vida(String url_hoja_vida) {
            this.url_hoja_vida = url_hoja_vida;
        }
    }
}
