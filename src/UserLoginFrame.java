import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserLoginFrame extends JFrame
{
    private  JTextField usernameField;
    private  JPasswordField passwordField;
    private Container cPanel;
    private JLabel label1, imgLabel;
    //private JTextField usernameField;
    //private JPasswordField passwordField;
    private JButton loginButton;
    private Font f1, f2, f4, f5;
    private Cursor cursor;
    private ImageIcon icon, logo;


    public UserLoginFrame()
    {
        setTitle("User Login");
        setSize(900, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        cPanel = this.getContentPane();
        cPanel.setLayout(null);
        cPanel.setBackground(Color.decode("#F2F2F2"));

        // Icon
        icon = new ImageIcon(getClass().getResource(""));
        this.setIconImage(icon.getImage());

        // Logo
        logo = new ImageIcon(getClass().getResource(""));
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
        label1.setText("User Login");
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

        /*setTitle("User Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel userLoginPanel = new JPanel();
        userLoginPanel.setLayout(new GridLayout(3, 2));

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        JButton loginButton = new JButton("Login");

        userLoginPanel.add(usernameLabel);
        userLoginPanel.add(usernameField);
        userLoginPanel.add(passwordLabel);
        userLoginPanel.add(passwordField);
        userLoginPanel.add(new JLabel());
        userLoginPanel.add(loginButton);

        add(userLoginPanel);
        setVisible(true);*/

        loginButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String inputUsername = usernameField.getText();
                String inputPassword = new String(passwordField.getPassword());

                // Authentication
                boolean isAuthenticated = false;

                for(int i = 0; i < LibraryManagementSystemGUI.userCount; i++)
                {
                    if(LibraryManagementSystemGUI.users[i].getUsername().equals(inputUsername) && LibraryManagementSystemGUI.users[i].getPassword().equals(inputPassword))
                    {
                        isAuthenticated = true;
                        break;
                    }
                }

                if(isAuthenticated)
                {
                    new UserOptionsFrame();
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }


    public static void main(String[] args)
    {
        new UserLoginFrame();
    }

}
