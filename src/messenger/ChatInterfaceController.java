package messenger;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChatInterfaceController implements Initializable {

    @FXML
    public TextField send;
    public TextArea messages;
    public Label name;
    public Button btn1;
    private String username;
    private String portno;
    private String chattername;

    @FXML
    public void sendmessage() throws UnknownHostException, IOException {
        String msg = send.getText();
        send.clear();
        if (msg != null) {
            ClientSenderfx ob = new ClientSenderfx(username, "CSE108", InetAddress.getByName("192.168.0.101"), msg, name.getText());
            //msg=msg.replace(":D","\uD83D\uDC31");
            msg = msg.replace(" :D", "\uD83D\uDE00");
            msg = msg.replace(" 3:)", "\uD83D\uDE08");
            msg = msg.replace(" ;)", "\uD83D\uDE09");
            msg = msg.replace(" ^_^", "\uD83D\uDE0A");
            msg = msg.replace(" -_-", "\uD83D\uDE11");
            msg = msg.replace(" :|", "\uD83D\uDE10");
            msg = msg.replace(" :*", "\uD83D\uDE19");
            msg = msg.replace(" :p", "\uD83D\uDE1C");
            msg = msg.replace(" :(", "\uD83D\uDE1E");
            msg = msg.replace(" >_<", "\uD83D\uDE20");
            msg = msg.replace(" :'(", "\uD83D\uDE22");
            msg = msg.replace(" :o", "\uD83D\uDE2E");
            msg = msg.replace(" :/", "\uD83D\uDE0F");
            messages.appendText("Myself: " +msg+ '\n');
        }
        
    }
    public void demoji()
    {
        send.appendText(" :D");
    }
    public void baka()
    {
        send.appendText(" :/");
    }
    public void cry()
    {
        send.appendText(" :'(");
    }
    public void happy()
    {
        send.appendText(" ^_^");
    }
    public void annoyed()
    {
        send.appendText(" -_-");
    }
    public void kiss()
    {
        send.appendText(" :*");
    }
    public void wow()
    {
        send.appendText(" :o");
    }
    public void tongue()
    {
        send.appendText(" :p");
    }
    public void sad()
    {
        send.appendText(" :(");
    }
    public void angry()
    {
        send.appendText(" >_<");
    }
    public void wink()
    {
        send.appendText(" ;)");
    }
    public void sendmessageenter(KeyEvent e) throws UnknownHostException {
        if(e.getCode().equals(KeyCode.ENTER)){
        String msg = send.getText();
        send.clear();
        if (msg != null) {
            ClientSenderfx ob = new ClientSenderfx(username, "CSE108", InetAddress.getByName("192.168.0.101"), msg, name.getText());
            //msg=msg.replace(":D","\uD83D\uDC31");
            msg = msg.replace(" :D", "\uD83D\uDE00");
            msg = msg.replace(" 3:)", "\uD83D\uDE08");
            msg = msg.replace(" ;)", "\uD83D\uDE09");
            msg = msg.replace(" ^_^", "\uD83D\uDE0A");
            msg = msg.replace(" -_-", "\uD83D\uDE11");
            msg = msg.replace(" :|", "\uD83D\uDE10");
            msg = msg.replace(" :*", "\uD83D\uDE19");
            msg = msg.replace(" :p", "\uD83D\uDE1C");
            msg = msg.replace(" :(", "\uD83D\uDE1E");
            msg = msg.replace(" >_<", "\uD83D\uDE20");
            msg = msg.replace(" :'(", "\uD83D\uDE22");
            msg = msg.replace(" :o", "\uD83D\uDE2E");
            msg = msg.replace(" :/", "\uD83D\uDE0F");
            messages.appendText("Myself: " +msg+ '\n');
        }
        }
    }

    class Receivemsg implements Runnable {

        Thread t;

        Receivemsg() {
            t = new Thread(this);
            t.start();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    showmsg();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }

        public void showmsg() throws IOException{
            if (FXMLDocumentController.ob.valueset) {
                String sendmsg = FXMLDocumentController.ob.getsendmsg();
                if (sendmsg != null) {
                    StringTokenizer st = new StringTokenizer(sendmsg);
                    StringTokenizer st1=new StringTokenizer(sendmsg);
                    StringTokenizer st2=new StringTokenizer(sendmsg);
                    if(Messenger.queue.contains(st2.nextToken())){
                    if (st.nextToken().equals(chattername)) {
                        try {
                            sendmsg = sendmsg.replace(" :D", "\uD83D\uDE00");
                            sendmsg = sendmsg.replace(" 3:)", "\uD83D\uDE08");
                            sendmsg = sendmsg.replace(" ;)", "\uD83D\uDE09");
                            sendmsg = sendmsg.replace(" ^_^", "\uD83D\uDE0A");
                            sendmsg = sendmsg.replace(" -_-", "\uD83D\uDE11");
                            sendmsg = sendmsg.replace(" :|", "\uD83D\uDE10");
                            sendmsg = sendmsg.replace(" :*", "\uD83D\uDE19");
                            sendmsg = sendmsg.replace(" :p", "\uD83D\uDE1C");
                            sendmsg = sendmsg.replace(" :(", "\uD83D\uDE1E");
                            sendmsg = sendmsg.replace(" >_<", "\uD83D\uDE20");
                            sendmsg = sendmsg.replace(" :'(", "\uD83D\uDE22");
                            sendmsg = sendmsg.replace(" :o", "\uD83D\uDE2E");
                            sendmsg = sendmsg.replace(" :/", "\uD83D\uDE0F");
                            messages.appendText(sendmsg + '\n');
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        FXMLDocumentController.ob.valueset = false;
                    }
                    }
                    else
                    {
                        FXMLDocumentController.chatname=st1.nextToken();
                        Messenger.queue.add(FXMLDocumentController.chatname);
                        Platform.runLater(()->{
                            try {
                                new newwindow(FXMLDocumentController.chatname).start();
                            } catch (IOException ex) {
                                Logger.getLogger(ChatInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        });
                        //FXMLDocumentController.ob.valueset = false;
                    }
                }

            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setText(FXMLDocumentController.getchatname());
        chattername = FXMLDocumentController.getchatname();
        username = FXMLDocumentController.getusername();
        portno = FXMLDocumentController.getportno();
        //Button button=new Button(" ",new ImageView("untitled4.png"));
        //pane.getChildren().add(button);
        new Receivemsg();
    }
}
