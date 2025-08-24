import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookFrame extends JFrame
{
    private Container cPanel;
    private JLabel label1, imgLabel;
    private JTextField titleField, authorField;
    private JButton addButton;
    private Font f1, f2, f4, f5;
    private Cursor cursor;
    private ImageIcon icon, logo;

    private void addBook(String title, String author)
    {
        if (LibraryManagementSystemGUI.bookCount < 100)
        {
            Book newBook = new Book();
            newBook.setTitle(title);
            newBook.setAuthor(author);
            newBook.setAvailable(true);
            LibraryManagementSystemGUI.books[LibraryManagementSystemGUI.bookCount] = newBook;
            LibraryManagementSystemGUI.bookCount++;
            System.out.println("Book added: " + title + " by " + author);
        }
        else
        {
            System.out.println("Cannot add more books. Library capacity reached.");
        }
    }


    public AddBookFrame()
    {
        setTitle("Add Book");
        setSize(900, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        cPanel = this.getContentPane();
        cPanel.setLayout(null);
        cPanel.setBackground(Color.decode("#F2F2F2"));

        // Icon
        icon = new ImageIcon(getClass().getResource("icons/addBook.jpg"));
        this.setIconImage(icon.getImage());

        // Logo
        logo = new ImageIcon(getClass().getResource("icons/addBook.jpg"));
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
        label1.setText("Add Book");
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

        // Password
        label1 = new JLabel();
        label1.setText("Author");
        label1.setBounds(430, 205, 500, 50);
        label1.setFont(f4);
        cPanel.add(label1);

        authorField = new JTextField();
        authorField.setBounds(590, 215, 210, 35);
        authorField.setFont(f2);
        cPanel.add(authorField);

        addButton = new JButton("Add");
        addButton.setBounds(590, 325, 215, 50);
        addButton.setFont(f2);
        addButton.setCursor(cursor);
        addButton.setForeground(Color.WHITE);
        addButton.setBackground(Color.decode("#2E75B6"));
        cPanel.add(addButton);

        setVisible(true);

        /*setTitle("Add Book");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel addBookPanel = new JPanel();
        addBookPanel.setLayout(new GridLayout(4, 2));

        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField();
        JLabel authorLabel = new JLabel("Author:");
        JTextField authorField = new JTextField();

        JButton addButton = new JButton("Add");

        addBookPanel.add(titleLabel);
        addBookPanel.add(titleField);
        addBookPanel.add(authorLabel);
        addBookPanel.add(authorField);
        addBookPanel.add(new JLabel());
        addBookPanel.add(addButton);

        add(addBookPanel);*/

        addButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String title = titleField.getText();
                String author = authorField.getText();

                if (!title.isEmpty() && !author.isEmpty())
                {
                    addBook(title, author);
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please fill in both title and author fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args)
    {
        AddBookFrame addBookFrame = new AddBookFrame();
    }
}
