package com.katary.personalback.utiles;

import com.jcraft.jsch.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

@Service
public class SFTPService {
    private final static Logger logger = LoggerFactory.getLogger(SFTPService.class);

    public String cargarArchivo(MultipartFile file) {
        String host = Env.PERSONA_SFTP_HOST;
        int port = 22;
        String username = Env.PERSONA_SFTP_USERNAME;
        String password = Env.PERSONA_SFTP_PASSWORD;

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

    public String cargarArchivo(InputStream file, String fileName) {
        String host = Env.PERSONA_SFTP_HOST;
        int port = 22;
        String username = Env.PERSONA_SFTP_USERNAME;
        String password = Env.PERSONA_SFTP_PASSWORD;

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
            channelSftp.put(file, remoteDir + "/" + fileName);
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            throw new RuntimeException(e);
        } finally {
            if (session != null && session.isConnected()) {
                session.disconnect();
            }
        }

        return remoteDir + "/" + fileName;
    }

    public String descargarArchivo(String remoteFilePath) {
        String host = Env.PERSONA_SFTP_HOST;
        int port = 22;
        String username = Env.PERSONA_SFTP_USERNAME;
        String password = Env.PERSONA_SFTP_PASSWORD;

        JSch jsch = new JSch();
        Session session = null;
        ChannelSftp channelSftp;

        try {
            session = jsch.getSession(username, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setConfig("PreferredAuthentications", "password");

            session.connect();

            channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();

            InputStream inputStream = channelSftp.get(remoteFilePath);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            byte[] inputBytes = outputStream.toByteArray();

            String base64String = Base64.getEncoder().encodeToString(inputBytes);

            inputStream.close();
            outputStream.close();

            channelSftp.disconnect();
            session.disconnect();

            String[] file = remoteFilePath.split("/");
            return getFileTypeBase64(file[file.length - 1]) + base64String;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getFileTypeBase64(String fileName) {
        String ext = getFileExtension(fileName);
        if (ext.equalsIgnoreCase("png")) {
            return "data:image/png;base64,";
        } else if (ext.equalsIgnoreCase("jpeg")) {
            return "data:image/jpeg;base64,";
        } else if (ext.equalsIgnoreCase("jpg")) {
            return "data:image/jpg;base64,";
        } else if (ext.equalsIgnoreCase("pdf")) {
            return "data:application/pdf;base64,";
        }  else {
            return "";
        }
    }

    public String getFileExtension(String fileName) {
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
}
