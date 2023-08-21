package AI;

import java.io.*;
import java.net.*;

public class ProxyServer {
    public static void main(String[] args) {
        int port = 8098;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Proxy server listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ProxyThread(clientSocket).start();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

class ProxyThread extends Thread{
    private Socket clientSocket;

    public ProxyThread(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (Socket serverSocket = new Socket("www.example.com", 80);
             InputStream clientInput = clientSocket.getInputStream();
             OutputStream clientOutput = clientSocket.getOutputStream();
             InputStream serverInput = serverSocket.getInputStream();
             OutputStream serverOutput = serverSocket.getOutputStream()){

            byte[] request = new byte[8192];
            int bytesRead = clientInput.read(request);

            serverOutput.write(request, 0, bytesRead);
            serverOutput.flush();

            byte[] response = new byte[8192];
            int serverBytesRead = serverInput.read(response);

            clientOutput.write(response, 0, serverBytesRead);
            clientOutput.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

