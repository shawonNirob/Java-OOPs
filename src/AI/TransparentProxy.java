package AI;

import java.io.*;
import java.net.*;

public class TransparentProxy {
    public static void main(String[] args) {
        int port = 8080; // Proxy server port

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Proxy server listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ProxyThread(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ProxyThrea extends Thread {
    private Socket clientSocket;

    public ProxyThrea(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (InputStream clientInput = clientSocket.getInputStream();
             OutputStream clientOutput = clientSocket.getOutputStream()) {

            // Read client request
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientInput));
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                System.out.println("Client: " + line);
            }

            // Forward request to the target server
            Socket serverSocket = new Socket("www.example.com", 80);
            InputStream serverInput = serverSocket.getInputStream();
            OutputStream serverOutput = serverSocket.getOutputStream();

            // Forward client request to the server
            serverOutput.write(line.getBytes());
            serverOutput.flush();

            // Read server response
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = serverInput.read(buffer)) != -1) {
                // Forward server response to the client
                clientOutput.write(buffer, 0, bytesRead);
                clientOutput.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

