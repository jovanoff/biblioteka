package biblioteka;

import Connectivity.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import static biblioteka.Constatns.*;

public class ReaderController {
    public TextField textFieldSearchBook;
    public ToggleGroup radioGroupSearch;
    public TableView<Book> tableView;
    public TableColumn<Book, String> bookAuthor;
    public TableColumn<Book, String> bookTitle;
    public TableColumn<Book, Boolean> bookAvailable;
    public RadioButton rbutton_author;
    public RadioButton rbutton_title;
    @FXML javafx.scene.control.Button closeButton;
    ObservableList<Book> observableList = FXCollections.observableArrayList();

    //logout button
    public void button_3(ActionEvent e) throws IOException
    {
        SceneController sceneController = new SceneController();
        sceneController.sceneSelector(e, LOGIN_SCENE, LOGIN_TITLE);
    }

    //Search button
    public void button_4(ActionEvent e) throws SQLException
    {
        observableList.removeAll(observableList);

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM books");

        if(!textFieldSearchBook.getText().isEmpty()) {

            if(rbutton_author.isSelected()) {

                while (resultSet.next()) {
                    String book_author = resultSet.getString("book_author");
                    String book_title = resultSet.getString("book_title");

                    if (book_author.toLowerCase(Locale.ROOT).contains(textFieldSearchBook.getText().toLowerCase(Locale.ROOT))) {
                        Book book = new Book(book_author, book_title);
                        observableList.add(book);
                    }
                }
            }
            else
            {
                while (resultSet.next()) {
                    String book_author = resultSet.getString("book_author");
                    String book_title = resultSet.getString("book_title");

                    if (book_title.toLowerCase(Locale.ROOT).contains(textFieldSearchBook.getText().toLowerCase(Locale.ROOT))) {
                        Book book = new Book(book_author, book_title);
                        observableList.add(book);
                    }
                }
            }
        }
        else
        {
            while (resultSet.next())
            {
                Book book = new Book(resultSet.getString("book_author"), resultSet.getString("book_title"));
                observableList.add(book);
            }
        }
        bookAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        bookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        bookAvailable.setCellValueFactory(new PropertyValueFactory<>("available"));
        tableView.setItems(observableList);
    }

    public void exitButton(ActionEvent e)
    {
        Stage window = (Stage) closeButton.getScene().getWindow();
        window.close();
    }
}
