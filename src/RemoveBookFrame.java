import java.lang.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveBookFrame extends JFrame
{
    private Container cPanel;
    private JLabel label1, imgLabel;
    private JTextField titleField, authorField;
    private JButton removeButton;
    private Font f1, f2, f4, f5;
    private Cursor cursor;
    private ImageIcon icon, logo;

    public RemoveBookFrame()
    {
        setTitle("Remove Book");
        setSize(900, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        cPanel = this.getContentPane();
        cPanel.setLayout(null);
        cPanel.setBackground(Color.decode("#F2F2F2"));

        // Icon
        icon = new ImageIcon(getClass().getResource("icons/removeBook.png"));
        this.setIconImage(icon.getImage());

        // Logo
        logo = new ImageIcon(getClass().getResource("icons/removeBook.png"));
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
        label1.setText("Remove Book");
        label1.setBounds(420, 50, 500, 90);
        label1.setFont(f1);
        cPanel.add(label1);

        // User Name
        label1 = new JLabel();
        label1.setText("Title");
        label1.setBounds(430, 145, 500, 50);
        label1.setFont(f4);
        cPanel.add(label1);

        titleField = new JTextField();
        titleField.setBounds(590, 155, 210, 35);
        titleField.setFont(f5);
        cPanel.add(titleField);


        removeButton = new JButton("Remove");
        removeButton.setBounds(590, 325, 215, 50);
        removeButton.setFont(f2);
        removeButton.setCursor(cursor);
        removeButton.setForeground(Color.WHITE);
        removeButton.setBackground(Color.decode("#2E75B6"));
        cPanel.add(removeButton);

        setVisible(true);

        /*setTitle("Remove Book");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel removeBookPanel = new JPanel();
        removeBookPanel.setLayout(new GridLayout(2, 1));

        JLabel titleLabel = new JLabel("Enter title of the book to remove:");
        JTextField titleField = new JTextField();
        JButton removeButton = new JButton("Remove");

        removeBookPanel.add(titleLabel);
        removeBookPanel.add(titleField);
        removeBookPanel.add(removeButton);

        add(removeBookPanel);
        setVisible(true);*/

        removeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String titleToRemove = titleField.getText();
                boolean found = false;

                // Find the book to remove
                for (int i = 0; i < LibraryManagementSystemGUI.bookCount; i++)
                {
                    if (LibraryManagementSystemGUI.books[i].getTitle().equals(titleToRemove))
                    {
                        found = true;
                        // Remove book from array
                        for (int j = i; j < LibraryManagementSystemGUI.bookCount - 1; j++)
                        {
                            LibraryManagementSystemGUI.books[j] = LibraryManagementSystemGUI.books[j + 1];
                        }
                        LibraryManagementSystemGUI.bookCount--;
                        JOptionPane.showMessageDialog(null, "Book '" + titleToRemove + "' removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        break;
                    }
                }

                if (!found)
                {
                    JOptionPane.showMessageDialog(null, "Book '" + titleToRemove + "' not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args)
    {
        new RemoveBookFrame();
    }

}
