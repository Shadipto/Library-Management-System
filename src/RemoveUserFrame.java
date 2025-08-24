import java.lang.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveUserFrame extends JFrame
{
    private Container cPanel;
    private JLabel label1, imgLabel;
    private JTextField usernameField, authorField;
    private JButton removeButton;
    private Font f1, f2, f4, f5;
    private Cursor cursor;
    private ImageIcon icon, logo;

    private void removeUser(String usernameToRemove)
    {
        boolean found = false;

        // Search the user
        for (int i = 0; i < LibraryManagementSystemGUI.userCount; i++)
        {
            if (LibraryManagementSystemGUI.users[i].getUsername().equals(usernameToRemove))
            {
                // Shift elements in the array to remove the user
                for (int j = i; j < LibraryManagementSystemGUI.userCount - 1; j++)
                {
                    LibraryManagementSystemGUI.users[j] = LibraryManagementSystemGUI.users[j + 1];
                }
                LibraryManagementSystemGUI.userCount--;
                found = true;
                System.out.println("User '" + usernameToRemove + "' removed successfully.");
                break;
            }
        }

        if (!found)
        {
            JOptionPane.showMessageDialog(null, "User '" + usernameToRemove + "' not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public RemoveUserFrame()
    {
        setTitle("Remove User");
        setSize(900, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        cPanel = this.getContentPane();
        cPanel.setLayout(null);
        cPanel.setBackground(Color.decode("#F2F2F2"));

        // Icon
        icon = new ImageIcon(getClass().getResource("icons/removeUser.png"));
        this.setIconImage(icon.getImage());

        // Logo
        logo = new ImageIcon(getClass().getResource("icons/removeUser.png"));
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
        label1.setText("Remove User");
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


        removeButton = new JButton("Remove");
        removeButton.setBounds(590, 325, 215, 50);
        removeButton.setFont(f2);
        removeButton.setCursor(cursor);
        removeButton.setForeground(Color.WHITE);
        removeButton.setBackground(Color.decode("#2E75B6"));
        cPanel.add(removeButton);

        setVisible(true);

        /*setTitle("Remove User");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel removeUserPanel = new JPanel();
        removeUserPanel.setLayout(new GridLayout(2, 1));

        JLabel usernameLabel = new JLabel("Enter the username of the user to remove:");
        JTextField usernameField = new JTextField();
        JButton removeButton = new JButton("Remove");

        removeUserPanel.add(usernameLabel);
        removeUserPanel.add(usernameField);
        removeUserPanel.add(removeButton);

        add(removeUserPanel);
        setVisible(true);*/

        removeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String usernameToRemove = usernameField.getText();

                removeUser(usernameToRemove);
                dispose();
            }
        });
    }

    public static void main(String[] args)
    {
        new RemoveUserFrame();
    }
}
