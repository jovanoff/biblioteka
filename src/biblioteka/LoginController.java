package biblioteka;

import Connectivity.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.*;
import java.util.Locale;

public class LoginController
{
    public SceneController sceneController = new SceneController();
    public TextField userNameField;
    public TextField userPasswordField;

    private static final String SEARCH_QUERY = "SELECT * FROM users Where user_name = ? and user_password = ?";

    public void button_1(ActionEvent e) throws SQLException, IOException {
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
        }
        else
        {
            String userRole = resultSet.getString(6);
            sceneController.sceneSelector(e, userRole.toLowerCase(Locale.ROOT));
        }
    }
}
