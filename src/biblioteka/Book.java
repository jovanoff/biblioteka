package biblioteka;

public class Book
{
    public String author;
    public String title;
    public boolean available;

    public Book (String author, String title)
    {
        this.author = author;
        this.title = title;
        this.available = true;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getTitle()
    {
        return title;
    }

    public boolean isAvailable()
    {
        return available;
    }
}
