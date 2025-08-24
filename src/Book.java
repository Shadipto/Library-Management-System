import java.lang.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Book
{
    private String title;
    private String author;
    private boolean available;

    public String getTitle()
    {
        return this.title;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public boolean isAvailable()
    {
        return this.available;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setAvailable(boolean available)
    {
        this.available = available;
    }

}