import java.lang.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminOptionsFrame extends JFrame
{
    private Cursor cursor;
    private Container cPanel;
    private Font f1, f2, f3, f4, f5, f6;
    private JButton addBookButton, removeBookButton, displayBooksButton, addUserButton, removeUserButton, logoutButton;

    public AdminOptionsFrame()
    {
        setTitle("Admin Options");
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
        addBookButton = new JButton("Add Book");
        addBookButton.setBounds(200, 50, 250, 50);
        addBookButton.setFont(f2);
        addBookButton.setCursor(cursor);
        addBookButton.setForeground(Color.WHITE);
        addBookButton.setBackground(Color.decode("#2E75B6"));
        cPanel.add(addBookButton);

        // remove book
        removeBookButton = new JButton("Remove Book");
        removeBookButton.setBounds(200, 120, 250, 50);
        removeBookButton.setFont(f2);
        removeBookButton.setCursor(cursor);
        removeBookButton.setForeground(Color.WHITE);
        removeBookButton.setBackground(Color.decode("#2E75B6"));
        cPanel.add(removeBookButton);

        // display
        displayBooksButton = new JButton("Display Books");
        displayBooksButton.setBounds(200, 190, 250, 50);
        displayBooksButton.setFont(f2);
        displayBooksButton.setCursor(cursor);
        displayBooksButton.setForeground(Color.WHITE);
        displayBooksButton.setBackground(Color.decode("#2E75B6"));
        cPanel.add(displayBooksButton);

        // add user
        addUserButton = new JButton("Add User");
        addUserButton.setBounds(200, 260, 250, 50);
        addUserButton.setFont(f2);
        addUserButton.setCursor(cursor);
        addUserButton.setForeground(Color.WHITE);
        addUserButton.setBackground(Color.decode("#2E75B6"));
        cPanel.add(addUserButton);

        // remove user
        removeUserButton = new JButton("Remove User");
        removeUserButton.setBounds(200, 330, 250, 50);
        removeUserButton.setFont(f2);
        removeUserButton.setCursor(cursor);
        removeUserButton.setForeground(Color.WHITE);
        removeUserButton.setBackground(Color.decode("#2E75B6"));
        cPanel.add(removeUserButton);

        // logout
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(200, 400, 250, 50);
        logoutButton.setFont(f2);
        logoutButton.setCursor(cursor);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(Color.decode("#2E75B6"));
        cPanel.add(logoutButton);

        setVisible(true);

        /*setTitle("Admin Options");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel adminOptionsPanel = new JPanel();
        adminOptionsPanel.setLayout(new GridLayout(6, 1));

        JButton addBookButton = new JButton("Add Book");
        JButton removeBookButton = new JButton("Remove Book");
        JButton displayBooksButton = new JButton("Display Books");
        JButton addUserButton = new JButton("Add User");
        JButton removeUserButton = new JButton("Remove User");
        JButton logoutButton = new JButton("Logout");

        adminOptionsPanel.add(addBookButton);
        adminOptionsPanel.add(removeBookButton);
        adminOptionsPanel.add(displayBooksButton);
        adminOptionsPanel.add(addUserButton);
        adminOptionsPanel.add(removeUserButton);
        adminOptionsPanel.add(logoutButton);

        add(adminOptionsPanel)*/



        addBookButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // Adding book
                new AddBookFrame();
            }
        });

        removeBookButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // Removing a book
                new RemoveBookFrame();
            }
        });

        displayBooksButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // Displaying books
                new DisplayBooksFrame();
            }
        });

        addUserButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                // Adding a user
                new AddUserFrame();
            }
        });

        removeUserButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                // Removing a user
                new RemoveUserFrame();
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
        new AdminOptionsFrame();
    }
}
