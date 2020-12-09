package biblioteka;

import javafx.scene.image.Image;

public final class Constatns {
    public static final Image ICON = new Image("32x32.png");
    public static final String ADMIN_TITLE = "Библиотека - Админ";
    public static final String LOGIN_TITLE = "Библиотека - Логин";
    public static final String READER_TITLE = "Библиотека - Читател";
    public static final String LIBRARIAN_TITLE = "Библиотека - Библиотекар";
    public static final String ADMIN_SCENE = "admin.fxml";
    public static final String LOGIN_SCENE = "login.fxml";
    public static final String READER_SCENE = "reader.fxml";
    public static final String LIBRARIAN_SCENE = "librarian.fxml";
    public static final String INSERT_QUERY = "INSERT INTO users (user_name, user_full_name, user_email, user_password, user_role) VALUES (?, ?, ?, ?, ?)";
    public static final String SEARCH_QUERY = "SELECT * FROM users Where user_name = ? and user_password = ?";
}
