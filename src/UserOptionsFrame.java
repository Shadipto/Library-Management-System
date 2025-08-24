import java.lang.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserOptionsFrame extends JFrame
{
    private Cursor cursor;
    private Container cPanel;
    private Font f1, f2, f3, f4, f5, f6;
    private JButton searchBooksButton, borrowBookButton, returnBookButton, logoutButton;


    private void searchBooks() {
        StringBuilder availableBooks = new StringBuilder("<html><body><h2>Available Books:</h2><ul>");

        boolean availableBooksFound = false;

        for (int i = 0; i < LibraryManagementSystemGUI.bookCount; i++) {
            if (LibraryManagementSystemGUI.books[i].isAvailable()) {
                // Append information about book
                availableBooks.append("<li><b>Title:</b> ")
                        .append(LibraryManagementSystemGUI.books[i].getTitle())
                        .append(", <b>Author:</b> ")
                        .append(LibraryManagementSystemGUI.books[i].getAuthor())
                        .append("</li>");
                availableBooksFound = true;
            }
        }

        availableBooks.append("</ul></body></html>");

        if (availableBooksFound) {
            JOptionPane.showMessageDialog(null, availableBooks.toString(), "Available Books", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "<html><body>No available books at the moment</body></html>", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /*private void searchBooks()
    {
        StringBuilder availableBooks = new StringBuilder("Available Books:\n");

        boolean availableBooksFound = false;

        for (int i = 0; i < LibraryManagementSystemGUI.bookCount; i++)
        {
            if (LibraryManagementSystemGUI.books[i].isAvailable())
            {
                // Append information about book
                availableBooks.append("Title: ").append(LibraryManagementSystemGUI.books[i].getTitle()).append(", Author: ").append(LibraryManagementSystemGUI.books[i].getAuthor()).append("\n");
                availableBooksFound = true;
            }
        }

        if (availableBooksFound)
        {
            JOptionPane.showMessageDialog(null, availableBooks.toString(), "Available Books", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No available books at the moment", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }*/

    /*private void borrowBook()
    {
        String bookToBorrow = JOptionPane.showInputDialog(null, "Enter the title of the book you want to borrow:");

        boolean bookFound = false;
        for (int i = 0; i < LibraryManagementSystemGUI.bookCount; i++)
        {
            if (LibraryManagementSystemGUI.books[i].getTitle().equalsIgnoreCase(bookToBorrow) && LibraryManagementSystemGUI.books[i].isAvailable())
            {
                bookFound = true;
                LibraryManagementSystemGUI.books[i].setAvailable(false);
                JOptionPane.showMessageDialog(null, "Book '" + bookToBorrow + "' borrowed successfully!");
                break;
            }
        }

        if (!bookFound)
        {
            JOptionPane.showMessageDialog(null, "Book '" + bookToBorrow + "' not found or not available for borrowing", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }*/

    /*private void returnBook()
    {
        String bookToReturn = JOptionPane.showInputDialog(null, "Enter the title of the book you want to return:");

        boolean bookFound = false;
        for (int i = 0; i < LibraryManagementSystemGUI.bookCount; i++)
        {
            if (LibraryManagementSystemGUI.books[i].getTitle().equalsIgnoreCase(bookToReturn) && !LibraryManagementSystemGUI.books[i].isAvailable())
            {
                bookFound = true;
                LibraryManagementSystemGUI.books[i].setAvailable(true);
                JOptionPane.showMessageDialog(null, "Book '" + bookToReturn + "' returned successfully!");
                break;
            }
        }

        if (!bookFound)
        {
            JOptionPane.showMessageDialog(null, "Book '" + bookToReturn + "' not found or not borrowed by you", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }*/

    public UserOptionsFrame()
    {
        setTitle("User Options");
        setSize(650, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        cPanel = this.getContentPane();
        cPanel.setLayout(null);
        cPanel.setBackground(Color.decode("#F2F2F2"));

        f1 = new Font("Segoe UI Black", Font.BOLD, 25);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f4 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f5 = new Font("Segoe UI", Font.PLAIN, 25);
        f6 = new Font("Segoe UI", Font.PLAIN, 25);

        // Add book
        searchBooksButton = new JButton("Search Book");
        searchBooksButton.setBounds(200, 70, 250, 50);
        searchBooksButton.setFont(f2);
        searchBooksButton.setCursor(cursor);
        searchBooksButton.setForeground(Color.WHITE);
        searchBooksButton.setBackground(Color.decode("#2E75B6"));
        cPanel.add(searchBooksButton);

        // remove book
        borrowBookButton = new JButton("Borrow Book");
        borrowBookButton.setBounds(200, 140, 250, 50);
        borrowBookButton.setFont(f2);
        borrowBookButton.setCursor(cursor);
        borrowBookButton.setForeground(Color.WHITE);
        borrowBookButton.setBackground(Color.decode("#2E75B6"));
        cPanel.add(borrowBookButton);

        // display
        returnBookButton = new JButton("Return Book");
        returnBookButton.setBounds(200, 210, 250, 50);
        returnBookButton.setFont(f2);
        returnBookButton.setCursor(cursor);
        returnBookButton.setForeground(Color.WHITE);
        returnBookButton.setBackground(Color.decode("#2E75B6"));
        cPanel.add(returnBookButton);

        // logout
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(200, 280, 250, 50);
        logoutButton.setFont(f2);
        logoutButton.setCursor(cursor);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(Color.decode("#2E75B6"));
        cPanel.add(logoutButton);

        setVisible(true);

        /*setTitle("User Options");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel userOptionsPanel = new JPanel();
        userOptionsPanel.setLayout(new GridLayout(4, 1));

        JButton searchBooksButton = new JButton("Search Books");
        JButton borrowBookButton = new JButton("Borrow Book");
        JButton returnBookButton = new JButton("Return Book");
        JButton logoutButton = new JButton("Logout");

        userOptionsPanel.add(searchBooksButton);
        userOptionsPanel.add(borrowBookButton);
        userOptionsPanel.add(returnBookButton);
        userOptionsPanel.add(logoutButton);

        add(userOptionsPanel);
        setVisible(true);*/

        searchBooksButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                searchBooks();
            }
        });

        borrowBookButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new BorrowBookFrame();
            }
        });

        returnBookButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new ReturnBookFrame();
                dispose();
            }
        });

        logoutButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });
    }

    public static void main(String[] args)
    {
        new UserOptionsFrame();
    }
}

