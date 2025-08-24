import java.lang.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserFrame extends JFrame
{
    private Container cPanel;
    private JLabel label1, imgLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton addButton;
    private Font f1, f2, f4, f5;
    private Cursor cursor;
    private ImageIcon icon, logo;

    private void addUser(String username, String password)
    {
        // Check if the user exists
        for (int i = 0; i < LibraryManagementSystemGUI.userCount; i++)
        {
            if (LibraryManagementSystemGUI.users[i].getUsername().equals(username))
            {
                System.out.println("Username already exists. Please choose a different one.");
                return;
            }
        }
        if (LibraryManagementSystemGUI.userCount < 100)
        {
            LibraryManagementSystemGUI.users[LibraryManagementSystemGUI.userCount] = new User(username, password);
            LibraryManagementSystemGUI.userCount++;
            System.out.println("User added: " + username);
        }
        else
        {
            System.out.println("Cannot add more users. User capacity reached.");
        }
    }

    public AddUserFrame()
    {
        setTitle("Add User");
        setSize(900, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        cPanel = this.getContentPane();
        cPanel.setLayout(null);
        cPanel.setBackground(Color.decode("#F2F2F2"));

        // Icon
        icon = new ImageIcon(getClass().getResource("icons/addUser.png"));
        this.setIconImage(icon.getImage());

        // Logo
        logo = new ImageIcon(getClass().getResource("icons/addUser.png"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(30, 50, logo.getIconWidth(), logo.getIconHeight());
        cPanel.add(imgLabel);

        // Fonts
        f1 = new Font("Segoe UI Black", Font.BOLD, 60);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f4 = new Font("Segoe UI", Font.PLAIN, 30);
        f5 = new Font("Segoe UI", Font.PLAIN, 22);

        // Title
        label1 = new JLabel();
        label1.setText("Add User");
        label1.setBounds(420, 50, 500, 90);
        label1.setFont(f1);
        cPanel.add(label1);

        // User Name
        label1 = new JLabel();
        label1.setText("Username");
        label1.setBounds(430, 145, 500, 50);
        label1.setFont(f4);
        cPanel.add(label1);

        usernameField = new JTextField();
        usernameField.setBounds(590, 155, 210, 35);
        usernameField.setFont(f5);
        cPanel.add(usernameField);

        // Password
        label1 = new JLabel();
        label1.setText("Password");
        label1.setBounds(430, 205, 500, 50);
        label1.setFont(f4);
        cPanel.add(label1);

        passwordField = new JPasswordField();
        passwordField.setBounds(590, 215, 210, 35);
        passwordField.setFont(f2);
        passwordField.setEchoChar('*');
        cPanel.add(passwordField);

        addButton = new JButton("Add");
        addButton.setBounds(590, 325, 215, 50);
        addButton.setFont(f2);
        addButton.setCursor(cursor);
        addButton.setForeground(Color.WHITE);
        addButton.setBackground(Color.decode("#2E75B6"));
        cPanel.add(addButton);

        setVisible(true);

        /*setTitle("Add User");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel addUserPanel = new JPanel();
        addUserPanel.setLayout(new GridLayout(4, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton addButton = new JButton("Add");

        addUserPanel.add(usernameLabel);
        addUserPanel.add(usernameField);
        addUserPanel.add(passwordLabel);
        addUserPanel.add(passwordField);
        addUserPanel.add(new JLabel());
        addUserPanel.add(addButton);

        add(addUserPanel);
        setVisible(true);*/

        addButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                addUser(username, password);
                dispose();
            }
        });
    }

    public static void main(String[] args)
    {
        AddUserFrame addUserFrame = new AddUserFrame();
    }


}
