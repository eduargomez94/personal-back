package com.katary.personalback.utiles;

import com.dslplatform.json.DslJson;
import com.dslplatform.json.runtime.Settings;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.HashMap;

@Service
public class SerializadorService {
    private final static DslJson.Settings<Object> settings = Settings.withRuntime().includeServiceLoader();
    public final static DslJson<Object> dslJson = new DslJson<>(settings);

    public void serialize(HashMap<String, Object> response, ServletOutputStream outputStream) {
        try {
            dslJson.serialize(response, outputStream);
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public <T> T deserialize(Class<T> acumularClass, byte[] datos) {
        try {
            return dslJson.deserialize(acumularClass, datos, datos.length);
        } catch (IOException err) {
            err.printStackTrace();
        }
        return null;
    }
}
