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
    public void sceneSelector(ActionEvent e, String s) throws IOException
    {
       Parent admin_scene_parent = FXMLLoader.load(getClass().getResource(s + ".fxml"));
       Scene admin_scene = new Scene(admin_scene_parent);
       Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
       window.setScene(admin_scene);
       window.show();
    }
}
