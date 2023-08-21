package AI.RoundRobin;

import java.util.ArrayList;
import java.util.List;

public class RoundRobin{
    public static class LoadBalancer{
        private List<String> servers;
        private int currentIndex;

        public LoadBalancer(){
            servers = new ArrayList<>();
            currentIndex = 0;
        }

        public void addServer(String server){
            servers.add(server);
        }

        public String getNextServer(){
            String server = servers.get(currentIndex);
            currentIndex = (currentIndex + 1) % servers.size();
            return server;
        }
    }

    public static class RequestHandler{
        private LoadBalancer loadBalancer;

        public RequestHandler(LoadBalancer loadBalancer) {
            this.loadBalancer = loadBalancer;
        }

        public void handleRequest(){
            String server = loadBalancer.getNextServer();
            System.out.println("Handling request. Forwarding to server: " + server);
        }
    }

    public static void main(String[] args){
        LoadBalancer loadBalancer = new LoadBalancer();
        loadBalancer.addServer("Server1");
        loadBalancer.addServer("Server2");
        loadBalancer.addServer("Server3");

        RequestHandler requestHandler = new RequestHandler(loadBalancer);

        // Simulate handling requests
        for (int i = 0; i < 10; i++) {
            requestHandler.handleRequest();
        }
    }
}