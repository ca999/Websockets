package Client;

import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;

public class Client {


    public static void classLoader() {
     ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
     try {
         Thread.currentThread().setContextClassLoader(Client.class.getClassLoader());
     } catch (Exception e) {

     } finally {
         Thread.currentThread().setContextClassLoader(classLoader);
     }
    }

    public static void main(String[] args) {
        try {
            Client.classLoader();
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            String uri = "https://localhost:8080/";
            System.out.println("Connecting to " + uri);
            container.connectToServer(ClientEndpoints.class, URI.create(uri));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

