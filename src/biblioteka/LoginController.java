package biblioteka;

import Connectivity.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import static biblioteka.Constatns.*;

public class LoginController
{
    public SceneController sceneController = new SceneController();
    public TextField userNameField;
    public PasswordField userPasswordField;
    @FXML private javafx.scene.control.Button closeButton;

    public void button_1(ActionEvent e) throws SQLException, IOException
    {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet;

        String tempUserName = userNameField.getText();
        String tempUserPassword = userPasswordField.getText();

        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_QUERY);
        preparedStatement.setString(1, tempUserName);
        preparedStatement.setString(2, tempUserPassword);
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.next())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Нема таков корисник! Обиди се повторно.");
            alert.show();
            userNameField.clear();
            userPasswordField.clear();
        }
        else
        {
            String userRole = resultSet.getString(6);
            switch (userRole)
            {
                case "ADMIN":
                    sceneController.sceneSelector(e, ADMIN_SCENE, ADMIN_TITLE );
                    break;
                case "LIBRARIAN":
                    sceneController.sceneSelector(e, LIBRARIAN_SCENE, LIBRARIAN_TITLE );
                    break;
                case "READER":
                    sceneController.sceneSelector(e, READER_SCENE, READER_TITLE );
                    break;
            }

        }
    }

    public void exitButton(ActionEvent e)
    {
        Stage window = (Stage) closeButton.getScene().getWindow();
        window.close();
    }
}
