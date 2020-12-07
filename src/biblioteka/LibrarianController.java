package biblioteka;

import Connectivity.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibrarianController {

    public TextField textFieldUserName;
    public TextField textFieldUserFullName;
    public TextField textFieldUserPassword;
    public TextField textFieldUserEmail;
    public TextField textFieldBookAuthor;
    public TextField textFieldBookTitle;
    private static final String INSERT_BOOK_QUERY = "INSERT INTO books (book_author, book_title, book_available) VALUES (?, ?, 1)";
    private static final String INSERT_USER_QUERY = "INSERT INTO users (user_name, user_full_name, user_email, user_password, user_role) VALUES (?, ?, ?, ?, 3)";

    public void button_5(ActionEvent e) throws IOException
    {
        SceneController sceneController = new SceneController();
        sceneController.sceneSelector(e, "login");
    }

    public void button_insert_book(ActionEvent e) throws SQLException
    {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_QUERY);
        preparedStatement.setString(1, textFieldBookAuthor.getText());
        preparedStatement.setString(2, textFieldBookTitle.getText());
        preparedStatement.executeUpdate();
        connection.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Книгата е успешно внесена!");
        alert.show();
        textFieldBookTitle.clear();
        textFieldBookAuthor.clear();
    }

    public void button_insert_user(ActionEvent e) throws SQLException
    {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_QUERY);
        preparedStatement.setString(1, textFieldUserName.getText());
        preparedStatement.setString(2, textFieldUserFullName.getText());
        preparedStatement.setString(3, textFieldUserEmail.getText());
        preparedStatement.setString(4, textFieldUserPassword.getText());
        preparedStatement.executeUpdate();
        connection.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Корисникот е успешно внесен!");
        alert.show();
        textFieldUserName.clear();
        textFieldUserFullName.clear();
        textFieldUserPassword.clear();
        textFieldUserEmail.clear();
    }

    public void button_search_books(ActionEvent e) throws IOException
    {
        SceneController sceneController = new SceneController();
        sceneController.sceneSelector(e, "reader");
    }
}
