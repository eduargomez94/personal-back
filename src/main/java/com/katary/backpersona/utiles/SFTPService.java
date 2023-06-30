package com.katary.backpersona.utiles;

import com.jcraft.jsch.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class SFTPService {
    private final static Logger logger = LoggerFactory.getLogger(SFTPService.class);

    public String cargarArchivo(MultipartFile file) {
        String host = Env.PERSONA_SFTP_HOST;
        int port = 22;
        String username = Env.PERSONA_SFTP_USERNAME;
        String password = Env.PERSONA_SFTP_PASSWORD;
        String sshHostKeyFingerprint = Env.PERSONA_SFTP_SSHHOSTKEY;

        String remoteDir = Env.PERSONA_SFTP_RUTA_REMOTA;

        JSch jsch = new JSch();
        Session session = null;
        ChannelSftp channelSftp = null;

        try {
            session = jsch.getSession(username, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setConfig("PreferredAuthentications", "password");

            session.connect();

            channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
            // Subir el archivo al servidor SFTP
            channelSftp.put(file.getInputStream(), remoteDir + "/" + file.getOriginalFilename());



        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (session != null && session.isConnected()) {
                session.disconnect();
            }
        }

        return remoteDir + "/" + file.getOriginalFilename();
    }
}
