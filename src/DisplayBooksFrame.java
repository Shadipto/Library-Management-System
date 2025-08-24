import javax.swing.*;
import java.awt.*;

public class DisplayBooksFrame extends JFrame {

    public DisplayBooksFrame() {
        setTitle("Display Books");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        JPanel displayBooksPanel = new JPanel(new BorderLayout());
        displayBooksPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Header Panel
        JPanel headerPanel = new JPanel();
        JLabel headerLabel = new JLabel("Books in Library:");
        headerLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        headerPanel.add(headerLabel);
        displayBooksPanel.add(headerPanel, BorderLayout.NORTH);

        // Books Panel
        JPanel booksPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Display all books
        for (int i = 0; i < LibraryManagementSystemGUI.bookCount; i++) {
            JLabel bookLabel = new JLabel((i + 1) + ". " + LibraryManagementSystemGUI.books[i].getTitle() + " by " + LibraryManagementSystemGUI.books[i].getAuthor());
            bookLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            booksPanel.add(bookLabel, gbc);
            gbc.gridy++;
        }

        displayBooksPanel.add(booksPanel, BorderLayout.CENTER);

        add(displayBooksPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DisplayBooksFrame::new);
    }
}
