
// Import necessary classes
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Login class extending JFrame and implementing ActionListener
public class Login extends JFrame implements ActionListener {

    // Declaration of class variables
    JTextField text, passwordField;
    JButton nextButton, backButton, passwordButton;

    // Constructor for the Login class
    Login() {
        // Set the background color of the frame to white and layout to null
        setTitle("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Load and display an image on the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i = i1.getImage().getScaledInstance(550, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);
        JLabel image = new JLabel(i2);
        image.setBounds(450, 0, 550, 500);
        add(image);

        // Create and configure a label for the heading "QUIZ TEST"
        JLabel heading = new JLabel("QUIZ TEST");
        heading.setBounds(140, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(22, 99, 54));
        add(heading);

        // Create and configure a label for entering the name
        JLabel nameLabel = new JLabel("Enter Your Name");
        nameLabel.setBounds(160, 150, 300, 20);
        nameLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        nameLabel.setForeground(new Color(22, 99, 54));
        add(nameLabel);

        // Create a text field for entering the name
        text = new JTextField();
        text.setBounds(80, 200, 300, 25);
        text.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(text);

        // Create and configure a label for entering the password
        JLabel passwordLabel = new JLabel("Enter Your Password");
        passwordLabel.setBounds(160, 230, 300, 20);
        passwordLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        passwordLabel.setForeground(new Color(22, 99, 54));
        add(passwordLabel);

        // Create a text field for entering the password
        passwordField = new JPasswordField();
        passwordField.setBounds(80, 280, 300, 25);
        passwordField.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(passwordField);

        // Create and configure a button for proceeding to the next step
        nextButton = new JButton("Next");
        nextButton.setBounds(100, 330, 120, 25);
        nextButton.setBackground(new Color(22, 99, 54));
        nextButton.setForeground(Color.WHITE);
        nextButton.addActionListener(this);
        add(nextButton);

        // Create and configure a button for going back or exiting
        backButton = new JButton("Back");
        backButton.setBounds(250, 330, 120, 25);
        backButton.setBackground(new Color(22, 99, 54));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        // Configure the size, location, and visibility of the frame
        setSize(1000, 500);
        setLocation(200, 150);
        setVisible(true);
    }

    // ActionListener implementation for handling button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            // If "Next" button was clicked, get the entered name and open a new frame
            // (Rules class)
            String name = text.getText();
            String password = passwordField.getText();
            setVisible(false);
            new Rules(name);
        } else if (e.getSource() == backButton) {
            System.exit(0);
        }
    }

    // Main method to create an instance of the Login class
    public static void main(String[] args) {
        new Login();
    }
}
