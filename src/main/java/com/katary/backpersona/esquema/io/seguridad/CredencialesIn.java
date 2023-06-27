package com.katary.backpersona.esquema.io.seguridad;

import com.dslplatform.json.CompiledJson;
import org.springframework.stereotype.Component;

@Component
public class CredencialesIn {
    @CompiledJson
    public static class CredencialesPost {
        private String email;
        private String contrasena;
        public CredencialesPost() {
        }
        public boolean esInValido() {
            return email == null || email.isEmpty()
                    || contrasena == null || contrasena.isEmpty();
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getContrasena() {
            return contrasena;
        }

        public void setContrasena(String contrasena) {
            this.contrasena = contrasena;
        }
    }
}
