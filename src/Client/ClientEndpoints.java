package Client;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnOpen;
import javax.websocket.Session;



@ClientEndpoint
public class ClientEndpoints {
    @OnOpen
    public void onOpen(Session session) {
        System.out.println(" " + session.getBasicRemote());
        try {
            String message = "Message From Client";
            System.out.println("Sending message to endpoint: " + message);
            session.getBasicRemote().sendText(message);
        } catch (Exception ex) {
            System.out.println("Error while sending message");
        }
    }
}

