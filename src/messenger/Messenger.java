package messenger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Queue;
class Client implements Runnable {
    
    private DatagramPacket pock;
    private DatagramSocket sock;
    private String clientname, servername;
    private int port;
    private InetAddress ip;
    Thread t;
    Client(String clientname, int port, InetAddress ip, String servername) throws SocketException, IOException {
        t=new Thread(this);
        this.clientname = clientname;
        this.port = port;
        this.servername = servername;
        this.ip = ip;
        t.start();
    }
    public void send() throws SocketException, IOException {
        String msg, portvalue;
        portvalue = String.valueOf(port);
        msg = "Via:"+" " + servername + '\n' + "To:"+" " + servername + '\n' + "From:"+" "+ clientname + '\n' + "Port:"+" "+ portvalue;
        sock = new DatagramSocket();
        byte data[] = msg.getBytes();
        pock = new DatagramPacket(data, data.length);
        pock.setAddress(ip);
        pock.setPort(45555);
        sock.send(pock);
        sock.close();
    }
    @Override
    public void run() {
        try {
            send();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
public class Messenger extends Application {
    public static Queue queue;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("My Messenger");
        stage.show();
    }
    public static void main(String[] args) {
        queue=new LinkedList();    
        launch(args);
    }
    
}
