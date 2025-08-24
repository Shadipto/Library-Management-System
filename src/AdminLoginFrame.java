import java.lang.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminLoginFrame extends JFrame
{
    private Container cPanel;
    private JLabel label1, imgLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private Font f1, f2, f4, f5;
    private Cursor cursor;
    private ImageIcon icon, logo;

    public AdminLoginFrame()
    {
        setTitle("Admin Login");
        setSize(900, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        cPanel = this.getContentPane();
        cPanel.setLayout(null);
        cPanel.setBackground(Color.decode("#F2F2F2"));

        // Icon
        icon = new ImageIcon(getClass().getResource("icons/qq.jpg"));
        this.setIconImage(icon.getImage());

        // Logo
        logo = new ImageIcon(getClass().getResource("icons/qq.jpg"));
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
        label1.setText("Admin Login");
        label1.setBounds(420, 50, 500, 90);
        label1.setFont(f1);
        cPanel.add(label1);

        // User Name
        label1 = new JLabel();
        label1.setText("Name");
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

        loginButton = new JButton("Login");
        loginButton.setBounds(590, 325, 215, 50);
        loginButton.setFont(f2);
        loginButton.setCursor(cursor);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.decode("#2E75B6"));
        cPanel.add(loginButton);

        setVisible(true);

        /*JPanel adminPanel = new JPanel();
        adminPanel.setLayout(new GridLayout(3, 2));

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        JButton loginButton = new JButton("Login");

        adminPanel.add(usernameLabel);
        adminPanel.add(usernameField);
        adminPanel.add(passwordLabel);
        adminPanel.add(passwordField);
        adminPanel.add(loginButton);

        add(adminPanel);
        setVisible(true);*/

        /*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Admin Login");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#F2F2F2"));

        f1 = new Font("Segoe UI Black", Font.BOLD, 60);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI Semibold", Font.PLAIN, 35);
        f4 = new Font("Segoe UI", Font.PLAIN, 30);
        f5 = new Font("Segoe UI", Font.PLAIN, 22);
        f6 = new Font("Segoe UI", Font.PLAIN, 25);

        label1 = new JLabel();
        label1.setText("Admin Login");
        label1.setBounds(420, 50, 500, 90);
        label1.setFont(f1);
        c.add(label1);

        // User Name
        label1 = new JLabel();
        label1.setText("Name");
        label1.setBounds(430, 145, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf1 = new JTextField();
        tf1.setBounds(590, 155, 210, 35);
        tf1.setFont(f5);
        c.add(tf1);

        // Password
        label1 = new JLabel();
        label1.setText("Password");
        label1.setBounds(430, 205, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf2 = new JPasswordField();
        tf2.setBounds(590, 215, 210, 35);
        tf2.setFont(f2);
        tf2.setEchoChar('*');
        c.add(tf2);

        btn3 = new JButton("Login");
        btn3.setBounds(590, 325, 215, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2E75B6"));
        c.add(btn3);


        this.setVisible(true);*/


        loginButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String adminUsername = usernameField.getText();
                String adminPassword = new String(passwordField.getPassword());

                // authentication
                if (adminUsername.equals("admin") && adminPassword.equals("admin"))
                {
                    new AdminOptionsFrame();
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid admin name or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args)
    {
        new AdminLoginFrame();
    }
}
