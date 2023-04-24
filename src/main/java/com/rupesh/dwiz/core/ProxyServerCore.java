package com.rupesh.dwiz.core;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class ProxyServerCore {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MalformedURLException {

        String server = "http://localhost:9090";
        String subURI = request.getRequestURI().split("/employee2")[1];
        System.out.println("ProxyServlet: " + server + subURI);
        URL remoteServerURL = new URL(server+subURI);
        HttpURLConnection remoteServer = (HttpURLConnection) remoteServerURL.openConnection();
        remoteServer.setRequestMethod("POST");
        remoteServer.setDoOutput(true);
        remoteServer.getOutputStream().write(readBytes(request.getInputStream()));
        response.getOutputStream().write(readBytes((ServletInputStream) remoteServer.getInputStream()));
    }

    /**
     * Read and return the entire contents of the supplied {@link InputStream stream}. This method always closes the stream when
     * finished reading.
     *
     * @param stream the stream to the contents; may be null
     * @return the contents, or an empty byte array if the supplied reader is null
     * @throws IOException if there is an error reading the content
     */
    private byte[] readBytes(ServletInputStream stream ) throws IOException {
        if (stream == null) return new byte[] {};
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        boolean error = false;
        try {
            int numRead = 0;
            while ((numRead = stream.read(buffer)) > -1) {
                output.write(buffer, 0, numRead);
            }
        } catch (IOException e) {
            error = true; // this error should be thrown, even if there is an error closing stream
            throw e;
        } catch (RuntimeException e) {
            error = true; // this error should be thrown, even if there is an error closing stream
            throw e;
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                if (!error) throw e;
            }
        }
        output.flush();
        return output.toByteArray();
    }

}
