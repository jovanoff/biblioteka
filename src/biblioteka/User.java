package biblioteka;

public class User
{
    private String userName;
    private String fullName;  
    private String email;    
    private String role; // user, librarian, admin

    // TODO: 05-Dec-20 Implement loaned book, time for loaned book. 

    public User(String userName, String fullName, String email, String role) {
        this.userName = userName;   
        this.fullName = fullName;
        this.email = email;        
        this.role = role;
    }
}
