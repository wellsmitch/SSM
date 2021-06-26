package webSocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.song.controller.UserController;
import com.song.pojo.User;
import com.song.service.UserServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ServerEndpoint("/webSocket/{username}")
public class WebSocket {
    private static int onlineCount = 0;
    private static Map<String, WebSocket> clients = new ConcurrentHashMap<String, WebSocket>();
    private Session session;
    private String username;
    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    UserController userController;

    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session, EndpointConfig config) throws IOException {
        this.username = username = String.valueOf(Math.random());
        Map<String, Object> userProperties = config.getUserProperties();
        String httpSessionId = (String) config.getUserProperties().get("sessionId");

        System.out.println("有新连接加入！" + httpSessionId);
        this.session = session;
        addOnlineCount();
        clients.put(username, this);
        for (WebSocket item : clients.values()) {
            new Timer().schedule(new TimerTask() {
                @Override
                public synchronized void run() {
                    try {
                        Object sd = clients.get(item.username);
                        System.out.println(sd);
                        if (sd != null) {
                            User s = new User();
                            s.setNickName("aaaaaaaaaa");
                            JSONObject res = JSONObject.fromObject(s);
                            item.session.getAsyncRemote().sendText(String.valueOf(res));
                        } else {
                            System.out.println("没有了");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 0, 3L * 1000);
        }

    }

//    @OnClose
//    public void onClose() throws IOException {
//        clients.remove(username);
//        subOnlineCount();
//    }

    @OnMessage
    public void onMessage(String message) throws IOException {
        JSONObject jsonTo = JSONObject.fromObject(message);
        Map<String, Object> map = jsonTo;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("entry.getKey()" + entry.getKey() + "entry.getValue()" + entry.getValue());
        }
//        System.out.println("来了一个链接");
        sendMessageAll("给所有人");
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

//    public void sendText(WebSocket item, String message) {
//         if(item.session != null) {
//             item.session.getAsyncRemote().sendText(message);
//         }
//    }

    public void sendMessageAll(String message) throws IOException {
        for (WebSocket item : clients.values()) {
//            sendText(item, message);
            System.out.println("++++++++");
            System.out.println("发出去一个链接");
            item.session.getAsyncRemote().sendText(message);
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }

    public static synchronized Map<String, WebSocket> getClients() {
        return clients;
    }
}
