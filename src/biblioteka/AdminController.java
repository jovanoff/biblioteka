package biblioteka;

import Connectivity.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static biblioteka.Constatns.*;

public class AdminController {
    public TextField    userNameField;
    public TextField    userPasswordField;
    public ToggleGroup  userRoleSelect;
    public TextField    fullNameTextField;
    public TextField    userEmailField;
    public RadioButton  rbutton_Admin;
    public RadioButton  rbutton_User;
    public RadioButton  rbutton_Librarian;

    public void button_2(ActionEvent e) throws IOException
    {
        SceneController sceneController = new SceneController();
        sceneController.sceneSelector(e, LOGIN_SCENE, LOGIN_TITLE);
    }

    public void createNewUser(ActionEvent e) throws SQLException
    {
        if(userNameField.getText().length() > 3 && userPasswordField.getText().length() >= 5 && fullNameTextField.getText().length() > 5)
        {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, userNameField.getText());
            preparedStatement.setString(2, fullNameTextField.getText());
            preparedStatement.setString(3, userEmailField.getText());
            preparedStatement.setString(4, userPasswordField.getText());

            if(rbutton_Admin.isSelected())
            {
                preparedStatement.setString(5, "1");
            }
            else if(rbutton_Librarian.isSelected())
            {
                preparedStatement.setString(5, "2");
            }
            else
            {
                preparedStatement.setString(5, "3");
            }
            preparedStatement.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Корисникот е успешно внесен!");
            alert.show();
            userNameField.clear();
            fullNameTextField.clear();
            userEmailField.clear();
            userPasswordField.clear();
            userRoleSelect.selectToggle(rbutton_Admin);
        }
    }
}
