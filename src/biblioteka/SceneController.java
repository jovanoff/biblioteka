package biblioteka;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneController
{
    public void sceneSelector(ActionEvent e, String sceneSelect, String title) throws IOException
    {
       Parent sceneParent = FXMLLoader.load(getClass().getResource(sceneSelect));
       Scene scene = new Scene(sceneParent);
       Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.setTitle(title);
       stage.show();
    }
}
