package biblioteka;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent login_scene = FXMLLoader.load(getClass().getResource("login.fxml"));
        window = primaryStage;
        window.setTitle("Login");
        window.setScene(new Scene(login_scene, 260, 300));
        window.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
