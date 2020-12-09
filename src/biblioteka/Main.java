package biblioteka;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static biblioteka.Constatns.*;

public class Main extends Application
{
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent login_scene = FXMLLoader.load(getClass().getResource("login.fxml"));
        window = primaryStage;
        window.setTitle(LOGIN_TITLE);
        window.getIcons().add(ICON);
        window.setScene(new Scene(login_scene, 400, 500));
        window.setResizable(false);
        window.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
