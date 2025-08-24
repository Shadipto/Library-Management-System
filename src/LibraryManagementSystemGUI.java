import java.lang.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryManagementSystemGUI extends JFrame
{
    public static Book[] books = new Book[100];
    public static int bookCount = 0;

    public static User[] users = new User[100];
    public static int userCount = 0;

    private Cursor cursor;
    private Container cPanel;
    private Font f1, f2, f3, f4, f5, f6;
    private JButton adminButton, userButton, exitButton;

    private JPanel panel;

    private static JTextField usernameField;
    private static JPasswordField passwordField;
    private static JFrame adminFrame;

    public LibraryManagementSystemGUI()
    {
        setTitle("Library Management System");
        setSize(650, 500);
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
        adminButton = new JButton("Admin");
        adminButton.setBounds(200, 70, 250, 50);
        adminButton.setFont(f2);
        adminButton.setCursor(cursor);
        adminButton.setForeground(Color.WHITE);
        adminButton.setBackground(Color.decode("#2E75B6"));
        cPanel.add(adminButton);

        // remove book
        userButton = new JButton("User");
        userButton.setBounds(200, 140, 250, 50);
        userButton.setFont(f2);
        userButton.setCursor(cursor);
        userButton.setForeground(Color.WHITE);
        userButton.setBackground(Color.decode("#2E75B6"));
        cPanel.add(userButton);

        // display
        exitButton = new JButton("Exit");
        exitButton.setBounds(200, 210, 250, 50);
        exitButton.setFont(f2);
        exitButton.setCursor(cursor);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(Color.decode("#2E75B6"));
        cPanel.add(exitButton);

        setVisible(true);

        /*setTitle("Library Management System");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        adminButton = new JButton("Admin");
        userButton = new JButton("User");
        exitButton = new JButton("Exit");


        // Fonts and Size
        Font buttonFont = new Font("JetBrains Mono", Font.BOLD, 30);
        adminButton.setFont(buttonFont);
        userButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        panel.add(adminButton);
        panel.add(userButton);
        panel.add(exitButton);

        add(panel);*/

        adminButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new AdminLoginFrame();
            }
        });

        userButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new UserLoginFrame();
            }
        });

        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args)
    {
        new LibraryManagementSystemGUI().setVisible(true);
    }
}