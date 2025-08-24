import java.lang.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrowBookFrame extends JFrame
{
    private Container cPanel;
    private JLabel label1, imgLabel;
    private JTextField titleField, authorField;
    private JButton borrowButton;
    private Font f1, f2, f4, f5;
    private Cursor cursor;
    private ImageIcon icon, logo;

    public  BorrowBookFrame()
    {
        setTitle("Borrow Book");
        setSize(900, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        cPanel = this.getContentPane();
        cPanel.setLayout(null);
        cPanel.setBackground(Color.decode("#F2F2F2"));

        // Icon
        icon = new ImageIcon(getClass().getResource("icons/borrowBook.jpg"));
        this.setIconImage(icon.getImage());

        // Logo
        logo = new ImageIcon(getClass().getResource("icons/borrowBook.jpg"));
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
        label1.setText("Borrow Book");
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


        borrowButton = new JButton("Borrow");
        borrowButton.setBounds(590, 325, 215, 50);
        borrowButton.setFont(f2);
        borrowButton.setCursor(cursor);
        borrowButton.setForeground(Color.WHITE);
        borrowButton.setBackground(Color.decode("#2E75B6"));
        cPanel.add(borrowButton);

        setVisible(true);

        borrowButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String bookToBorrow = titleField.getText();

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
            }
        });
    }

    public static void main(String[] args)
    {
        new BorrowBookFrame();
    }
}