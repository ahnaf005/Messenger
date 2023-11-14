package messenger;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class FXMLDocumentController implements Initializable {
    @FXML
    public static ClientReceiverfx ob;
    private Label label;
    private int c;
    public Label label1;
    public Label label2;
    public Label label3;
    public TextField user;
    public TextField chat;
    public TextField port;
    public Button startchat;
    public static String chatname;
    public static String username;
    public static String portno;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    public void startchat() throws IOException
    {
        username=user.getText();
        chatname=chat.getText();
        portno=port.getText();
        Messenger.queue.add((chatname));
        String portnum=portno;
        if(c==0 && username!=null && portnum!=null)
        {
            new Client(username,Integer.parseInt(portnum),InetAddress.getByName("192.168.0.101"),"CSE108");
            user.setEditable(false);
            port.setEditable(false);
            ob=new ClientReceiverfx(username,Integer.parseInt(portnum),"CSE108");
            c++;
        }
        if(username!=null && chatname!=null && portno!=null)
        {
            newwindow(chatname);
        }
        chat.clear();
    }
    public static void newwindow(String a) throws IOException
    {
        new newwindow(a).start();
    }
    static String getchatname()
    {
        return chatname;
    }
    static String getusername()
    {
        return username;
    }
    static String getportno(){
        return portno;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       c=0;
    }
    
}
