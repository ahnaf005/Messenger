package messenger;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class newwindow1 {
    String chattername;
    newwindow1(String chattername)
    {
        this.chattername=chattername;
    }
    public void start() throws IOException
    {
        //Parent root = FXMLLoader.load(getClass().getResource("ChatInterface.fxml"));
        Parent root=new AnchorPane();
        Scene scene = new Scene(root);
        Stage stage1=new Stage();
        stage1.setTitle("Messaging with "+chattername);
        stage1.setScene(scene);
        stage1.show();
    }
}
